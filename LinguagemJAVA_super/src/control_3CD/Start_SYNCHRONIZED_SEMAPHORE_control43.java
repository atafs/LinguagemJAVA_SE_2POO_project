package control_3CD;

import java.util.concurrent.Semaphore;

public class Start_SYNCHRONIZED_SEMAPHORE_control43 {
	
	public static void main(String[] args) {
		
		Account americoAcount = new Account();
		System.out.println("Acount balance BEFORE deposit: " + americoAcount.getBalance());
		
		americoAcount.deposit(5000);
		System.err.println("\t\t\t\t\tAcount balance AFTER deposit:  " + americoAcount.getBalance());
		
	}
	
	//INNER CLASS
	public static class Account {
		
		//CREATE SEMAPHORE
		private static Semaphore semaphore = new Semaphore(1);
		private int balance = 0;
		
		//GETTER
		public int getBalance() {
			return balance;
		}
		
		//DEPOSIT
		public void deposit(int amount) {
			
			try {
				
				semaphore.acquire(); //acquire a permit
				int newBalance = balance + amount; //add amount
				
				Thread.sleep(1000); //data-corruption problem or communication problems
				
				balance = newBalance; //update balance
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaphore.release(); //release a permit
			}
		}
		
		
	}
}






