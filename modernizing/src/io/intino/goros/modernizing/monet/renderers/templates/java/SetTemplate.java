package io.intino.goros.modernizing.monet.renderers.templates.java;

import io.intino.itrules.template.Rule;
import io.intino.itrules.template.Template;

import java.util.ArrayList;
import java.util.List;

public class SetTemplate extends Template {

    @Override
    public List<Rule> ruleSet() {
        List<Rule> result = new ArrayList<>();
        result.addAll(new SetDefinitionTemplate().ruleSet());
        result.addAll(new NodeDefinitionTemplate().ruleSet());
        return result;
    }

}