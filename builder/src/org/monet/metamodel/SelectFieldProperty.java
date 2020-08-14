package org.monet.metamodel;

import org.monet.metamodel.interfaces.IsInitiable;

import java.util.HashMap;
import java.util.List;

// SelectFieldDeclaration
// Declaración que se utiliza para modelar un	campo de selección

public class SelectFieldProperty extends SelectFieldPropertyBase implements IsInitiable {

	private HashMap<String, Object> termValues = new HashMap<String, Object>();
	private HashMap<Object, String> termCodes = new HashMap<Object, String>();
	private boolean isInitialized = false;
	private TermsProperty termsProperty = null;

	public void init() {
		SelectProperty selectDefinition = this.getSelect();

		if (this._termsProperty != null)
			this.processTermList(this._termsProperty._termPropertyList);

		if (selectDefinition != null && selectDefinition.getDepth() == null)
			selectDefinition._depth = 1L;

		this.isInitialized = true;
	}

	@Override
	public TermsProperty getTerms() {
		return termsProperty != null ? termsProperty : super.getTerms();
	}

	public String getTermCode(String sValue) {
		if (!isInitialized)
			this.init();
		if (!this.termCodes.containsKey(sValue))
			return null;
		return this.termCodes.get(sValue);
	}

	private void processTermList(List<TermProperty> termList) {
		for (TermProperty term : termList) {
			this.termCodes.put(term._label, term._key);
			this.termValues.put(term._key, term._label);
			processTermList(term._termPropertyList);
		}
	}

}
