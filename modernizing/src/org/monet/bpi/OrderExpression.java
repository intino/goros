package org.monet.bpi;

import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class OrderExpression {

	private LinkedHashMap<Param, OrderType> orderFields = new LinkedHashMap<Param, OrderType>();

	public enum OrderType {
		ASC, DESC
	}

	public void add(Param field, OrderType type) {
		orderFields.put(field, type);
	}

	public void add(Param field) {
		this.add(field, OrderType.ASC);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (Entry<Param, OrderType> entry : this.orderFields.entrySet()) {
			builder.append(getColumn(entry.getKey()));
			builder.append(" ");
			builder.append(entry.getValue().toString());
			builder.append(", ");
		}
		if (builder.length() > 0)
			builder.delete(builder.length() - 2, builder.length());
		return builder.toString();
	}

	private String getColumn(Param param) {
		Object value = param.getValue();

		if (value instanceof Timestamp)
			return param.getColumnExtended();

		return param.getColumn();
	}


}
