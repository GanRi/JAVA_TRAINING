package ch01.ex15;

public interface LookupExp extends Lookup{
	void add(Object value, String name);
	void remove(String name);
}
