package ch11.ex01;

public class Test {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();

		list.add(null);
		System.out.println(list.get(0));
		list.add(0);
		list.add(2);
		list.add(1);
		list.add(0, 8);
		list.add(5, 6);

		Object[] array = list.toArray();
		for (Object i : array) {
			System.out.println(i);
		}

		System.out.println(list.remove(2));
		System.out.println();

		array = list.toArray();
		for (Object i : array) {
			System.out.println(i);
		}

		System.out.println();
		list.clear();
		array = list.toArray();
		for (Object i : array) {
			System.out.println(i);
		}

		list.add(10);
		list.remove(0);

	}

}
