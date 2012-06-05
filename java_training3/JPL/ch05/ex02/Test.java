package ch05.ex02;

public class Test {
	public static void main(String[] args){
		
	BankAccount account = new BankAccount();	
	
	account.deposit(10000);
	account.deposit(200);
	account.withdraw(5000);
	account.deposit(300);		
	account.withdraw(400);		
	account.deposit(1000);				
	account.deposit(200);
	account.withdraw(2500);		
	account.deposit(400);		
	account.deposit(300);		
	account.withdraw(100);		
	for(int i=0; i<11; i++){			
			System.out.println(account.history().next());
		}
	}
}
