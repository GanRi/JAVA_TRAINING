package ch04.ex02;

public class SimpleSort implements SortHarness<Integer> {

	private Integer[] sortData;

	public SimpleSort(Integer[] sortData) {
		this.sortData = sortData;
	}

	@Override
	public void sort() {
		for (int i = 0; i < sortData.length; ++i) {
			for (int j = i + 1; j < sortData.length; ++j) {
				if (compare(i, j)) {
					swap(i, j);
				}
			}
		}
	}

	@Override
	public boolean compare(	int i, int j) {
		Integer value_i = (Integer) getValue(i);
		Integer value_j = (Integer) getValue(j);
		if (value_i > value_j)
			return true;
		return false;
	}

	@Override
	public Integer getValue(int i) {
		return sortData[i];
	}

	@Override
	public void swap(int i, int j) {
		Integer tmp = sortData[i];
		sortData[i] = sortData[j];
		sortData[j] = tmp;
	}


}
