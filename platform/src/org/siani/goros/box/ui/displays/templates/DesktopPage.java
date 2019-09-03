package org.siani.goros.box.ui.displays.templates;

import org.siani.goros.box.GorosBox;
import org.siani.goros.box.ui.displays.notifiers.DesktopPageNotifier;

import java.util.List;

import static io.intino.alexandria.ui.displays.UserMessage.Type.Info;

public class DesktopPage extends AbstractDesktopPage<DesktopPageNotifier, GorosBox> {
    private View currentView;

    public DesktopPage(GorosBox box) {
        super(box);
    }

    @Override
    public void init() {
        super.init();
        initLinks();
        initTabs();
        addViews();
    }

    private void initLinks() {
        links.onSelect(e -> links.notifyUser("user clicked " + e.selection().get(0), Info));
    }

    private void initTabs() {
        viewSelector.add("Opción 1");
        viewSelector.add("Opción 2");
        viewSelector.onSelect(e -> {
            List<Object> selection = e.selection();
            if (selection.size() <= 0) return;
            showView((String) selection.get(0));
        });
        viewSelector.refresh();
    }

    private void showView(String option) {
        if (currentView != null) currentView.hide();
        if (option.equals("Opción 1")) currentView = (View) view("Vista 1").show();
        else currentView = (View) view("Vista 2").show();
    }

    private void addViews() {
        add("Vista 1", true);
        add("Vista 2", false);
    }

    private void add(String label, boolean visible) {
        View view = views.add();
        view.label.value(label);
        view.visible(visible);
        if (visible) currentView = view;
    }

    private View view(String label) {
        return views.children(View.class).stream().filter(v -> v.label.value().equals(label)).findFirst().orElse(null);
    }
}