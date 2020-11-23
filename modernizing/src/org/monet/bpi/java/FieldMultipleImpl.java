package org.monet.bpi.java;

import org.monet.bpi.Field;
import org.monet.bpi.FieldMultiple;
import org.monet.bpi.types.Term;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SuppressWarnings("unchecked")
public class FieldMultipleImpl<T extends Field<?>, V> implements FieldMultiple<T, V>, Iterable<V> {

	@Override
	public String getCode() {
		return null;
	}

	@Override
	public T addNew() {
		return null;
	}

	@Override
	public T addNew(V newValue) {
		return null;
	}

	@Override
	public List<T> addNewAll(List<V> newValues) {
		return null;
	}

	@Override
	public T insert(int index) {
		return null;
	}

	@Override
	public T insert(int index, V newValue) {
		return null;
	}

	@Override
	public void remove(int index) {

	}

	@Override
	public void remove(V newValue) {

	}

	@Override
	public void removeAll() {

	}

	@Override
	public V get(int index) {
		return null;
	}

	@Override
	public T getAsField(int index) {
		return null;
	}

	@Override
	public int getCount() {
		return 0;
	}

	@Override
	public ArrayList<V> getAll() {
		return null;
	}

	@Override
	public ArrayList<T> getAllFields() {
		return null;
	}

	@Override
	public ArrayList<Term> getAllAsTerm() {
		return null;
	}

	@Override
	public Iterator<V> iterator() {
		return null;
	}
}
