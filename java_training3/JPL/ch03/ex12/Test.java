package ch03.ex12;

public class Test {
	public static void main(String[] args) {
		Integer[] sortData = { 2222, 47, 992, 10, 3,342 };
		SimpleSort sort = new SimpleSort(sortData);
		sort.sort();
		for (int i = 0; i < sortData.length; i++) {
			System.out.println(sortData[i]);
		}
	}
}
