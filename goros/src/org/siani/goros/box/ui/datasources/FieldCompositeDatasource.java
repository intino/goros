package org.siani.goros.box.ui.datasources;

import io.intino.alexandria.ui.services.push.UISession;
import org.monet.bpi.Field;
import org.monet.bpi.FieldComposite;
import org.siani.goros.box.GorosBox;

public class FieldCompositeDatasource {
    private final GorosBox box;
    private final UISession session;
    private final FieldComposite field;

    public FieldCompositeDatasource(GorosBox box, UISession session, FieldComposite field) {
        this.box = box;
        this.session = session;
        this.field = field;
    }

    public <T, F extends Field<V>, V> T getField(String code) {
        return field.getField(code);
    }

}