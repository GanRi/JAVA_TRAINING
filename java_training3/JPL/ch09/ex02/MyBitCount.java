package ch09.ex02;

public class MyBitCount {
	public int bitCount(int num) {
		int nBitNum = 0;
		while (0 < num) {
			num &= (num - 1);
			nBitNum++;
		}
		return nBitNum;
	}

	public static void main(String args[]) {
		MyBitCount bitCount = new MyBitCount();
		System.out.println(Integer.toBinaryString(10) + "   number: " + bitCount.bitCount(10));
		System.out.println(Integer.toBinaryString(45) + "   number: " + bitCount.bitCount(45));
		System.out.println(Integer.toBinaryString(511) + "   number: " + bitCount.bitCount(511));
		
	}
}
