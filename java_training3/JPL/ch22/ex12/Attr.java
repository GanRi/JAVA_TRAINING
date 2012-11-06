package ch22.ex12;

public class Attr {
	private final String name;
	private Object value = null;

	public Attr(final String name) {
		this.name = name;
	}

	public Attr(final String name, final Object value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return this.name;
	}

	public Object getValue() {
		return this.value;
	}

	public Object setValue(final Object newValue) {
		final Object oldVal = this.value;
		this.value = newValue;
		return oldVal;
	}

	@Override
	public String toString() {
		return this.name + "='" + this.value + "'";
	}
}