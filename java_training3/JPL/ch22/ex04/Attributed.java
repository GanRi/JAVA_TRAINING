package ch22.ex04;

import java.util.Observable;
import java.util.Observer;

public class Attributed implements Observer {

	Attr attr;

	public Attributed(final Attr attr) {
		this.attr = attr;
		attr.addObserver(this);
	}

	@Override
	public void update(final Observable attr, final Object value) {
		if (attr != this.attr) {
			throw new IllegalArgumentException();
		}

		System.out.println("Received changed attr : " + value);
	}

}
