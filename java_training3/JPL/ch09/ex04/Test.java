package ch09.ex04;

public class Test {
	public static void main(String[] args) {
		System.out.println(3 << 2L - 1);// 6
		System.out.println((3 << 2L) - 1);// 11
		System.out.println(10 < 12 == 6 > 17);// false
		System.out.println(10 << 12 == 6 >> 17);// false
		System.out.println(13.5e-1 % Float.POSITIVE_INFINITY);// 13.5e-1
		System.out.println(Float.POSITIVE_INFINITY + Double.NEGATIVE_INFINITY);// NaN
		System.out.println(Double.POSITIVE_INFINITY - Float.NEGATIVE_INFINITY);// Infinity
		System.out.println(0.0 / -0.0 == -0.0 / 0.0);// false
		System.out.println(Integer.MAX_VALUE + Integer.MIN_VALUE);// -1
		System.out.println(Long.MAX_VALUE + 5);// Long.Min_VALUE + 4
		System.out.println((short) 5 * (byte) 10);// 50

		Base b1 = new Derive();
		// Derive d2 = b.test();
		Base b2 = new DeriveDerive();
		Base b3 = b2.test();
	}
}

class Base {
	public Base test() {
		return new Base();
	}
}

class Derive extends Base {
	public Derive test() {
		return new Derive();
	}
}

class DeriveDerive extends Derive {
	public DeriveDerive test() {
		return new DeriveDerive();
	}
}
