package ch12.ex01;

public class Test {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();

		Integer i1 = new Integer(1);
		Integer i2 = new Integer(2);
		Integer i3 = new Integer(2);

		list.add(i1);
		list.add(i2);
		list.add(i3);

		try {
			System.out.println("found : " + list.find(i1) + ", Hashcode = "
					+ i1.hashCode());
			System.out.println("found : " + list.find(i2) + ", Hashcode = "
					+ i2.hashCode());

			Integer i1_1 = new Integer(1);
			System.out.println("found : " + list.find(i1_1) + ", Hashcode = "
					+ i1_1.hashCode());

			System.out.println("found : " + list.find(i3) + ", Hashcode = "
					+ i3.hashCode());

		} catch (ObjectNotFoundException e) {
			System.out.println("not found : " + e.ob + ",  Hashcode = "
					+ e.hashCode());
			e.printStackTrace();
		}

		try {
			list.add(null);
			System.out.println("found : " + list.find(null) + ", Hashcode = "
					+ i1.hashCode());

		} catch (ObjectNotFoundException e) {
			System.out.println("not found : " + e.ob + ",  Hashcode = "
					+ e.hashCode());
			e.printStackTrace();
		}

	}

}
