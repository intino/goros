package io.intino.goros.modernizing.monet.renderers.templates.konos;

import io.intino.itrules.template.Rule;
import io.intino.itrules.template.Template;

import java.util.ArrayList;
import java.util.List;

public class IndexTemplate extends Template {

    @Override
    public List<Rule> ruleSet() {
        List<Rule> result = new ArrayList<>();
        result.addAll(new IndexDefinitionTemplate().ruleSet());
        result.addAll(new NodeDefinitionTemplate().ruleSet());
        return result;
    }

}