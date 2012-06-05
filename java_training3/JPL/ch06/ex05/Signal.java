package ch06.ex05;

import java.awt.Color;

public enum Signal {
	GREEN {
		@Override
		public Color getColor() {
			return Color.GREEN;
		}
	},
	YELLOW {
		@Override
		public Color getColor() {
			return Color.YELLOW;
		}
	},
	RED {
		@Override
		public Color getColor() {
			return Color.RED;
		}
	};
	public abstract Color getColor();

}