package io.intino.goros.builder;

import io.intino.goros.builder.monet.Dictionary;
import io.intino.goros.builder.renderers.*;
import io.intino.goros.builder.util.ZipUtil;
import org.monet.metamodel.*;
import org.monet.metamodel.internal.TaskOrderDefinition;

import java.io.File;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class GorosBuilder {
    private final Modernization modernization;
    private Dictionary dictionary;
    private DefinitionRendererFactory factory = new DefinitionRendererFactory();

    public GorosBuilder(Modernization modernization) {
        this.modernization = modernization;
    }

    public void compile() {
        loadDictionary();
        createProjectSkeleton();
        compileDefinitions();
    }

    private void createProjectSkeleton() {
        File projectDir = modernization.projectDirectory();
        if (projectDir.exists()) return;
        projectDir.mkdirs();
        ZipUtil.decompress(GorosBuilder.class.getResourceAsStream("/skeleton.zip"), projectDir.getAbsolutePath());
        new ArtifactRenderer(dictionary, modernization).write();
        new MainRenderer(dictionary, modernization).write();
        new BoxRenderer(dictionary, modernization).write();
        new GraphRenderer(dictionary, modernization).write();
    }

    private void compileDefinitions() {
        new UIRenderer(dictionary, modernization, definitions().collect(toList())).write();
        new ThemeRenderer(dictionary, modernization).write();
        new TranslationsRenderer(dictionary, modernization).write();
        new TasksRenderer(dictionary, modernization).write();
        definitions().forEach(this::compileDefinition);
    }

    private void compileDefinition(Definition definition) {
        if (definition.getType() == null) return;
        factory.renderer(dictionary, modernization, definition).write();
    }

    private void loadDictionary() {
        dictionary = new Dictionary();
        org.monet.metamodel.Dictionary.injectCurrentInstance(dictionary);
        dictionary.initialize(modernization.businessModel().getAbsolutePath());
    }

    private Stream<Definition> definitions() {
        return dictionary.getAllDefinitions().stream().filter(d -> isRoot(d) && !excluded(d));
    }

    private boolean isRoot(Definition definition) {
        if (definition instanceof TaskOrderDefinition) return false;
        if (definition instanceof NodeDefinition) return true;
        if (definition instanceof ActivityDefinition) return true;
        if (definition instanceof SourceDefinition) return true;
        return definition instanceof IndexDefinition;
    }

    private boolean excluded(Definition definition) {
        List<String> excludedList = modernization.excludedDefinitions();
        return excludedList.contains(definition.getName()) || excludedList.contains(definition.getCode());
    }

}
