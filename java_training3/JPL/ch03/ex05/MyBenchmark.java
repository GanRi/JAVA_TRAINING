package ch03.ex05;

public class MyBenchmark extends Benchmark {
	@Override
	void benchmark() {
		System.out.println();
	}

	public static void main(String[] args) {
		int count = Integer.parseInt(args[0]);
		long time = new MyBenchmark().repeat(count);
		System.out.println(count + " methods in " + time + " nanoseconds");
	}
}
