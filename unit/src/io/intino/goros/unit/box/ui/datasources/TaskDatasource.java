package io.intino.goros.unit.box.ui.datasources;

import io.intino.alexandria.ui.model.datasource.PageDatasource;
import io.intino.alexandria.ui.services.push.UISession;
import io.intino.goros.unit.box.UnitBox;
import io.intino.goros.unit.util.AccountHelper;
import org.monet.space.kernel.model.Account;
import org.monet.space.kernel.model.Task;

public abstract class TaskDatasource extends PageDatasource<Task> {
	protected final UnitBox box;
	protected final UISession session;
	protected final Account account;

	protected TaskDatasource(UnitBox box, UISession session) {
		this.box = box;
		this.session = session;
		this.account = AccountHelper.account(session);
	}
}
