package ch22.ex15;

import java.util.Stack;

public class DoubleOperate {
	private final Stack<Character> priStack = new Stack<Character>();
	private final Stack<Double> numStack = new Stack<Double>();

	public double caculate(final String str) {

		String temp;
		StringBuffer tempNum = new StringBuffer();
		final StringBuffer string = new StringBuffer().append(str);

		while (string.length() != 0) {
			temp = string.substring(0, 1);
			string.delete(0, 1);
			if (!this.isNum(temp)) {
				if (!"".equals(tempNum.toString())) {
					final double num = Double.parseDouble(tempNum.toString());
					this.numStack.push(num);
					tempNum.delete(0, tempNum.length());
				}

				while (!this.compare(temp.charAt(0)) && !this.priStack.empty()) {
					final double a = this.numStack.pop();
					final double b = this.numStack.pop();
					final char ope = this.priStack.pop();
					double result = 0;
					switch (ope) {
					case '+':
						result = b + a;
						this.numStack.push(result);
						break;
					case '-':
						result = b - a;
						this.numStack.push(result);
						break;
					case '*':
						result = b * a;
						this.numStack.push(result);
						break;
					case '/':
						result = b / a;
						this.numStack.push(result);
						break;
					case '%':
						result = b % a;
						this.numStack.push(result);
						break;
					}

				}
				if (temp.charAt(0) != '#') {
					this.priStack.push(new Character(temp.charAt(0)));
					if (temp.charAt(0) == ')') {
						this.priStack.pop();
						this.priStack.pop();
					}
				}
			} else {
				tempNum = tempNum.append(temp);
			}
		}
		return this.numStack.pop();
	}

	private boolean isNum(final String temp) {
		return temp.matches("[0-9.]");
	}

	private boolean compare(final char str) {
		if (this.priStack.empty()) {
			return true;
		}
		final char last = this.priStack.lastElement();
		if (last == '(') {
			return true;
		}
		switch (str) {
		case '#':
			return false;
		case '(':
			return true;
		case ')':
			return false;
		case '*': {
			if (last == '+' || last == '-') {
				return true;
			} else {
				return false;
			}
		}
		case '/': {
			if (last == '+' || last == '-') {
				return true;
			} else {
				return false;
			}
		}
		case '%': {
			if (last == '+' || last == '-') {
				return true;
			} else {
				return false;
			}
		}
		case '+':
			return false;
		case '-':
			return false;
		}
		return true;
	}

	public static void main(final String args[]) {
		final DoubleOperate operate = new DoubleOperate();
		double t = operate.caculate("13.1+4.33*(4.2*10-10/2)#");
		System.out.println(t);
		t = operate.caculate("21+3/2+5%2+100-90.0#");
		System.out.println(t);
	}

}
