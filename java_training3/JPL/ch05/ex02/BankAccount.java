package ch05.ex02;

public class BankAccount {
	private long number;
	private long balance;
	private History history = new History();

	public class Action {
		private String act;
		private long amount;

		Action(String act, long amount) {
			this.act = act;
			this.amount = amount;
		}

		public String toString() {
			return number + ": " + act + " " + amount;
		}
	}

	public void deposit(long amount) {
		
		balance += amount;
		history.add(new Action("deposit", amount));
	}

	public void withdraw(long amount) {
		
		balance -= amount;
		history.add(new Action("withdraw", amount));
	}

	public History history() {
		return history;
	}

	public class History {
		private static final int MAX_SIZE = 10;
		private Action[] actions = new Action[MAX_SIZE];
		private int index,nextIndex;

		public Action next() {
			if (nextIndex < actions.length) {
				return actions[nextIndex++];
			} else {
				return null;
			}
		}

		public void add(Action action) {
			if (index < MAX_SIZE) {
				actions[index] = action;
			} else {
				for (int i = 0; i < actions.length - 1; i++) {
					actions[i] = actions[i + 1];
				}
				actions[actions.length - 1] = action;
			}
			index++;
		}
	}
}
