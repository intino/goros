package io.intino.goros.util;

import org.monet.metamodel.Definition;
import org.monet.metamodel.DesktopDefinition;
import org.monet.metamodel.SourceDefinition;
import org.monet.space.kernel.model.Dictionary;
import org.monet.space.kernel.model.Source;
import org.monet.space.kernel.model.Term;
import org.siani.itrules.framebuilder.FrameBuilder;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class SourceHelper {

    public static Source<SourceDefinition> locateSource(String code) {
        List<Source<SourceDefinition>> sources = new ArrayList<>(LayerHelper.sourceLayer().loadSourceList(code, null).get().values());
        return sources.size() > 0 ? sources.get(0) : null;
    }

    public static String typeLabel(Term term) {
        if (term.isCategory()) return "C";
        else if (term.isSuperTerm()) return "S";
        return "T";
    }

    public static String typeColor(Term term) {
        if (term.isCategory()) return "#4CAF50";
        else if (term.isSuperTerm()) return "#2896F3";
        return "#272C34";
    }

}
