package ch22.ex12;

public interface Attributed {
	void add(Attr newAttr);

	Attr find(String attrName);

	Attr remove(String attrName);

	java.util.Iterator<Attr> attrs();
}
