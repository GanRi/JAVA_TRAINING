package ch22.ex04;

import java.util.Observable;

public class Attr extends Observable {
	private final String name;
	private Object value = null;

	public Attr(final String name) {
		this.name = name;
	}

	public Attr(final String name, final Object value) {
		this.name = name;
		this.value = value;
	}

	public Object getValue() {
		return this.value;
	}

	public String getName() {
		return this.name;
	}

	public Object setValue(final Object newValue) {
		final Object oldValue = this.value;
		this.value = newValue;
		super.setChanged();
		super.notifyObservers(newValue);
		return oldValue;
	}

	@Override
	public String toString() {
		return this.name + "='" + this.value + "'";
	}
}
