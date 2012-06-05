package ch03.ex12;

public abstract class SortHarness {
	private Object[] values;

	public SortHarness(Object[] values) {
		this.values = values;
	}

	public void sort() {
		for (int i = 0; i < values.length; ++i) {
			for (int j = i + 1; j < values.length; ++j) {
				if (compare(i, j)) {
					swap(i, j);
				}
			}
		}
	}

	public abstract boolean compare(int i, int j);

	public Object getValue(int i) {
		return values[i];
	}

	private void swap(int i, int j) {
		Object tmp = values[i];
		values[i] = values[j];
		values[j] = tmp;
	}
}
