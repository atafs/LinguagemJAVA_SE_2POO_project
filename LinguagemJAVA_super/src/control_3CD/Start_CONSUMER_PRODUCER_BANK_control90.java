package control_3CD;

import pt.progJava.americoLib.control90.Account;
import pt.progJava.americoLib.control90.Deposit;
import pt.progJava.americoLib.control90.Withdraw;

public class Start_CONSUMER_PRODUCER_BANK_control90 {

	public static void main(String[] args) {
		
		//INICIAL VALUE
		int initialFunds = 2;
		
		//INSTANTIATE
		Account account = new Account(initialFunds);
		Deposit deposit = new Deposit(account);
		Withdraw withdraw = new Withdraw(account);
		
		//START THREADS
		deposit.start();
		withdraw.start();
		
		//SLEEP on the THREAD in MAIN
		try {
			Thread.sleep(2*1000);
			
			deposit.interrupt();
			withdraw.interrupt();
			
			deposit.join();
			withdraw.join();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	
		
		//PRINTS
		System.out.println("[INICIAL funds: " + initialFunds + "]");
		System.out.println("[TOTAL withdrawn: " + withdraw.getFundsWithdrawn() + "]");
		System.out.println("[TOTAL deposited: " + deposit.getFundsDeposited() + "]\n");
		
		//COMPUTE BALANCE
		int computeBalance = initialFunds + ( deposit.getFundsDeposited() - withdraw.getFundsWithdrawn() );
		System.out.println("[Balance SHOULD be: " + computeBalance + "]");
		System.out.println("[Balance in ACCOUNT: " + account.getBalance() + "]");
		
		//CONDITION
		if(computeBalance != account.getBalance()) {
			System.out.println("\n[SOmething IS VERY WRONG!!! The two values do NOT match!!!");
		} else {
			System.out.println("[All is GOOD!!! Not going to BANKRUPTCY just yet ;-)");
		}
		
		

	}

}
