package io.intino.goros.unit.box.ui.displays;

import io.intino.alexandria.ui.Soul;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractRouteDispatcher implements io.intino.alexandria.ui.displays.DisplayRouteDispatcher {
    private static java.util.Map<String, String> patterns = new HashMap<>();

    public AbstractRouteDispatcher() {
        registerPatterns();
    }

    @Override
    public void dispatch(Soul soul, String address) {
        address = address.replaceFirst(soul.session().browser().basePath(), "");
        List<String> params = paramsOf(address);
        if (address.length() <= 1) { dispatchHome(soul); return; }
        if (address.matches(patterns.get("home"))) { dispatchHome(soul); return; }
        if (address.matches(patterns.get("roles"))) { dispatchRoles(soul); return; }
    }

    public abstract void dispatchHome(Soul soul);
    public abstract void dispatchRoles(Soul soul);

    private void registerPatterns() {
        if (patterns.size() > 0) return;
        patterns.put("home", "\\/goros-home");
        patterns.put("roles", "\\/roles");
    }

    private String patternOf(String address) {
        if (address.matches(patterns.get("home"))) return patterns.get("home");
        else if (address.matches(patterns.get("home"))) return patterns.get("home");
        else if (address.matches(patterns.get("roles"))) return patterns.get("roles");
        return null;
    }

    private List<String> paramsOf(String address) {
        return paramsOf(address, patternOf(address));
    }

    private List<String> paramsOf(String address, String pattern) {
        if (pattern == null) return java.util.Collections.emptyList();
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(address);
        if (!m.find()) return Collections.emptyList();
        List<String> result = new ArrayList<>();
        for (int i=1; i<=m.groupCount(); i++) result.add(m.group(i));
        return result;
    }

}