package ch22.ex03;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;

public class MyWhichChars {
	// private BitSet used = new BitSet();
	private final HashMap<Integer, BitSet> map = new HashMap<Integer, BitSet>();

	public MyWhichChars(final String str) {
		for (int i = 0; i < str.length(); i++) {
			final char c = str.charAt(i);
			final int highByte = (c & 0xff00) >> 8;
			final int lowByte = c & 0xff;

			BitSet bitSet = this.map.get(highByte);
			if (bitSet == null) {
				bitSet = new BitSet();
				this.map.put(highByte, bitSet);
			}

			bitSet.set(lowByte);
		}
	}

	@Override
	public String toString() {

		String desc = "{\n";
		final Set<Entry<Integer, BitSet>> entrySet = this.map.entrySet();
		for (final Entry<Integer, BitSet> entry : entrySet) {
			final BitSet used = entry.getValue();
			desc += "[";
			for (int i = used.nextSetBit(0); i >= 0; i = used.nextSetBit(i + 1)) {
				desc += (char) i;
			}
			desc += "]\n";
		}
		desc += "}";

		return desc;
	}
}
