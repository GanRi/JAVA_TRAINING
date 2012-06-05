package ch03.ex12;

public class SimpleSort extends SortHarness {

	public SimpleSort(Integer[] values) {
		super(values);
	}

	@Override
	public boolean compare(int i, int j) {
		Integer value_i = (Integer) getValue(i);
		Integer value_j = (Integer) getValue(j);
		if (value_i > value_j)
			return true;
		return false;
	}

}
