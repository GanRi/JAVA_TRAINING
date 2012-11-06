package ch22.ex12;

import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;

public class TokenizerVersion {
	public static Attributed readAttrs(final Reader source) throws IOException {
		final StreamTokenizer in = new StreamTokenizer(source);
		final AttributedImpl attrs = new AttributedImpl();
		Attr attr = null;
		in.commentChar('#'); // '#' is ignore-to-end comment
		in.ordinaryChar('/'); // was original comment char
		while (in.nextToken() != StreamTokenizer.TT_EOF) {
			if (in.ttype == StreamTokenizer.TT_WORD) {
				if (attr != null) {
					attr.setValue(in.sval);
					attr = null; // used this one up
				} else {
					attr = new Attr(in.sval);
					attrs.add(attr);
				}
			} else if (in.ttype == '=') {
				if (attr == null) {
					throw new IOException("misplaced '='");
				}
			} else {
				if (attr == null) {
					throw new IOException("bad Attr name");
				}
				attr.setValue(new Double(in.nval));
				attr = null;
			}
		}
		return attrs;
	}
}
