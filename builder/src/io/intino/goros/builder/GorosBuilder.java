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
    private RendererFactory factory = new RendererFactory();

    public GorosBuilder(Modernization modernization) {
        this.modernization = modernization;
    }

    public void compile(File businessModelFile) {
        prepareModel(businessModelFile);
        createProjectSkeleton();
        compileDefinitions();
    }

    private void createProjectSkeleton() {
        File projectDir = modernization.projectDirectory();
        if (projectDir.exists()) return;
        projectDir.mkdirs();
        ZipUtil.decompress(GorosBuilder.class.getResourceAsStream("/skeleton.zip"), projectDir.getAbsolutePath());
        new ArtifactRenderer(modernization).write();
        new MainRenderer(modernization).write();
        new BoxRenderer(modernization).write();
    }

    private void compileDefinitions() {
        new UIRenderer(modernization, definitions().collect(toList())).write();
        definitions().forEach(this::compileDefinition);
    }

    private void compileDefinition(Definition definition) {
        if (definition.getType() == null) return;
        factory.renderer(modernization, definition).write();
    }

    private void prepareModel(File businessModelFile) {
        decompressBusinessModel(businessModelFile);
        loadDictionary(businessModelFile);
    }

    private void loadDictionary(File businessModelFile) {
        dictionary = new Dictionary();
        org.monet.metamodel.Dictionary.injectCurrentInstance(dictionary);
        dictionary.initialize(businessModelDir(businessModelFile).getAbsolutePath());
    }

    private void decompressBusinessModel(File businessModelFile) {
        File sourceDir = businessModelDir(businessModelFile);
        if (sourceDir.exists()) return;
        ZipUtil.decompress(businessModelFile, sourceDir.getAbsoluteFile().getAbsolutePath());
    }

    private File businessModelDir(File businessModelFile) {
        return new File(businessModelFile.getParentFile() + "/" + businessModelFile.getName().substring(0, businessModelFile.getName().lastIndexOf(".")));
    }

    private Stream<Definition> definitions() {
        return dictionary.getAllDefinitions().stream().filter(d -> isRoot(d) && !excluded(d));
    }

    private boolean isRoot(Definition definition) {
        if (definition instanceof TaskOrderDefinition) return false;
        if (definition instanceof NodeDefinition) return true;
        if (definition instanceof TaskDefinition) return true;
        if (definition instanceof SourceDefinition) return true;
        return definition instanceof IndexDefinition;
    }

    private boolean excluded(Definition definition) {
        List<String> excludedList = modernization.excludedDefinitions();
        return excludedList.contains(definition.getName()) || excludedList.contains(definition.getCode());
    }

}
