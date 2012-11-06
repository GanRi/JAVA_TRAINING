package ch22.ex04;

public class Test {
	public static void main(final String[] args) {
		final Attr attr = new Attr("name", "tom");
		final Attributed observer1 = new Attributed(attr);
		final Attributed observer2 = new Attributed(attr);
		final Attributed observer3 = new Attributed(attr);
		attr.setValue("jerry");
	}
}
