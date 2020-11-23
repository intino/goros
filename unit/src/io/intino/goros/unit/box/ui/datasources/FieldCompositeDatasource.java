package io.intino.goros.unit.box.ui.datasources;

import io.intino.alexandria.ui.services.push.UISession;
import io.intino.goros.unit.box.UnitBox;
import org.monet.bpi.Field;
import org.monet.bpi.FieldComposite;

public class FieldCompositeDatasource {
    private final UnitBox box;
    private final UISession session;
    private final FieldComposite field;

    public FieldCompositeDatasource(UnitBox box, UISession session, FieldComposite field) {
        this.box = box;
        this.session = session;
        this.field = field;
    }

    public <T, F extends Field<V>, V> T getField(String code) {
        return field.getField(code);
    }

}