package org.siani.goros.box.ui.displays.templates;

import org.siani.goros.box.GorosBox;
import org.siani.goros.box.ui.displays.notifiers.DesktopPageNotifier;

import java.util.List;

public class DesktopPage extends AbstractDesktopPage<DesktopPageNotifier, GorosBox> {
    private View currentView;

    public DesktopPage(GorosBox box) {
        super(box);
    }

    @Override
    public void init() {
        super.init();
        initViewSelector();
        addViews();
    }

    private void initViewSelector() {
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
        if (option.equals("Opción 1")) view("Vista 1").show();
        else view("Vista 2").show();
    }

    private void addViews() {
        add("Vista 1", true);
        add("Vista 2", false);
    }

    private void add(String label, boolean visible) {
        View view = views.add();
        view.label.update(label);
        view.visible(visible);
        if (visible) currentView = view;
    }

    private View view(String label) {
        return views.children(View.class).stream().filter(v -> v.label.value().equals(label)).findFirst().orElse(null);
    }
}