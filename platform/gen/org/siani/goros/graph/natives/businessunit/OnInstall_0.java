package org.siani.goros.graph.natives.businessunit;

/**BusinessUnit#/Users/mcaballero/Proyectos/goros/platform/src/org/siani/goros/graph/Model.tara#14#1**/
public class OnInstall_0 implements org.siani.goros.graph.functions.SetupFunction, io.intino.tara.magritte.Function {
	private org.siani.goros.graph.BusinessUnit self;

	@Override
	public void execute() {
		org.siani.goros.graph.Model.onInstall(self);
	}

	@Override
	public void self(io.intino.tara.magritte.Layer context) {
		self = (org.siani.goros.graph.BusinessUnit) context;
	}

	@Override
	public Class<? extends io.intino.tara.magritte.Layer> selfClass() {
		return org.siani.goros.graph.BusinessUnit.class;
	}
}