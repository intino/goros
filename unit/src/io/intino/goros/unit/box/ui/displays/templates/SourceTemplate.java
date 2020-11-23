package io.intino.goros.unit.box.ui.displays.templates;

import io.intino.goros.unit.box.UnitBox;
import io.intino.goros.unit.util.Formatters;
import io.intino.goros.unit.util.SourceHelper;
import org.monet.metamodel.SourceDefinition;
import org.monet.space.kernel.model.Source;

public class SourceTemplate extends AbstractSourceTemplate<UnitBox> {
    private String desktopLabel;
    private String desktopPath;
    private Source<SourceDefinition> source;

    public SourceTemplate(UnitBox box) {
        super(box);
    }

    public SourceTemplate desktop(String label, String path) {
        this.desktopLabel = label;
        this.desktopPath = path;
        return this;
    }

    public SourceTemplate open(String key) {
        source = SourceHelper.locateSource(key);
        refresh();
        return this;
    }

    @Override
    public void refresh() {
        super.refresh();
        desktopLink.title(desktopLabel);
        desktopLink.address(path -> desktopPath);
        desktopLink.visible(desktopPath != null);
        desktopLinkSeparator.visible(desktopPath != null);
        label.value(source.getLabel());
        content.onTermsCountChange(this::refreshCount);
        content.source(source);
        content.refresh();
    }

    private void refreshCount(long countValue) {
        count.value(Formatters.countMessage(countValue, translate("Term").toLowerCase(), translate("Terms").toLowerCase()));
    }

}