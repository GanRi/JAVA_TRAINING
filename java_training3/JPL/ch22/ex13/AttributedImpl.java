package ch22.ex13;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class AttributedImpl implements Attributed, Iterable<Attr> {
	protected Map<String, Attr> attrTable = new HashMap<String, Attr>();

	public void add(final Attr newAttr) {
		this.attrTable.put(newAttr.getName(), newAttr);
	}

	public Attr find(final String name) {
		return this.attrTable.get(name);
	}

	public Attr remove(final String name) {
		return this.attrTable.remove(name);
	}

	public Iterator<Attr> attrs() {
		return this.attrTable.values().iterator();
	}

	public Iterator<Attr> iterator() {
		return this.attrs();
	}
}