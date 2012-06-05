package ch04.ex02;

public interface SortHarness<T> {
	void sort();

	boolean compare(int i, int j);

	T getValue(int i);

	void swap(int i, int j);

}
