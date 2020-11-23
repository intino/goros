package org.monet.metamodel;

import org.monet.metamodel.internal.Ref;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// NodeDefinition
// Declaración abstracta de un nodo. Un nodo es un elemento navegable del sistema de información

public abstract class NodeDefinition extends NodeDefinitionBase {
	private NodeViewProperty defaultView = null;
	protected List<NodeViewProperty> viewList = new ArrayList<NodeViewProperty>();
	protected List<NodeViewProperty> tabViewList = new ArrayList<NodeViewProperty>();
	protected Map<String, NodeViewProperty> viewsMap = new HashMap<String, NodeViewProperty>();
	protected Map<String, RuleProperty> rulesMap = null;

	public boolean isPublic() {
		return this._isPrivate == null;
	}

	public boolean isContainer() {
		return this instanceof ContainerDefinition;
	}

	public boolean isDesktop() {
		return this instanceof DesktopDefinition;
	}

	public boolean isCollection() {
		return this instanceof CollectionDefinition;
	}

	public boolean isCatalog() {
		return this instanceof CatalogDefinition;
	}

	public boolean isSet() {
		return this instanceof SetDefinition;
	}

	public boolean isForm() {
		return this instanceof FormDefinition;
	}

	public boolean isDocument() {
		return this instanceof DocumentDefinition;
	}

	public boolean isPrototypable() {

		if (this instanceof ContainerDefinition) {
			ContainerDefinition definition = (ContainerDefinition) this;
			return definition.isPrototypable();
		}

		if (this instanceof FormDefinition) {
			FormDefinition definition = (FormDefinition) this;
			return definition.isPrototypable();
		}

		return false;
	}

	public boolean isGeoreferenced() {

		if (this instanceof ContainerDefinition) {
			ContainerDefinition definition = (ContainerDefinition) this;
			return definition.getIsGeoreferenced() != null;
		}

		if (this instanceof FormDefinition) {
			FormDefinition definition = (FormDefinition) this;
			return definition.getIsGeoreferenced() != null;
		}

		return false;
	}

	public boolean hasMappings() {

		if (this instanceof FormDefinition) {
			FormDefinition definition = (FormDefinition) this;
			return definition.getMappingList().size() > 0;
		}

		if (this instanceof DocumentDefinition) {
			DocumentDefinition definition = (DocumentDefinition) this;
			return definition.getMappingList().size() > 0;
		}

		return false;
	}

	public NodeViewProperty getDefaultView() {
		return this.defaultView;
	}

	public void setDefaultView(NodeViewProperty defaultView) {
		this.defaultView = defaultView;
	}

	public NodeViewProperty getNodeView(String key) {
		return this.viewsMap.get(key);
	}

	protected void initRulesMap() {
		this.rulesMap = new HashMap<String, RuleProperty>();
		for (RuleNodeProperty rule : this._ruleNodePropertyList)
			this.rulesMap.put(rule.getCode(), rule);
		for (RuleViewProperty rule : this._ruleViewPropertyList)
			this.rulesMap.put(rule.getCode(), rule);
		for (RuleOperationProperty rule : this._ruleOperationPropertyList)
			this.rulesMap.put(rule.getCode(), rule);
	}

	public RuleProperty getRule(String ruleCode) {
		if (this.rulesMap == null)
			initRulesMap();

		return this.rulesMap.get(ruleCode);
	}

	public boolean isComponent() {
		if (this.isDocument()) {
			return ((DocumentDefinition) this).isComponent();
		} else if (this.isCatalog()) {
			return ((CatalogDefinition) this).isComponent();
		} else if (this.isForm()) {
			return ((FormDefinition) this).isComponent();
		} else if (this.isCollection()) {
			return ((CollectionDefinition) this).isComponent();
		}
		return false;
	}

	public List<Ref> getRoles() {
		if (this.isDesktop()) {
			return ((DesktopDefinition) this).getFor().getRole();
		} else if (this.isContainer()) {
			ContainerDefinition definition = (ContainerDefinition) this;
			if (definition.isEnvironment()) {
				return definition.getFor().getRole();
			}
		}
		return null;
	}

	public boolean isEnvironment() {
		if (this.isContainer()) {
			ContainerDefinition definition = (ContainerDefinition) this;
			return definition.isEnvironment();
		}
		return this.isDesktop();
	}

	public boolean requirePartnerContext() {
		return this._requirePartnerContextProperty != null;
	}

	public List<NodeViewProperty> getViewDefinitionList() {
		return this.viewList;
	}

	public List<NodeViewProperty> getTabViewDefinitionList() {
		return this.tabViewList;
	}

}
