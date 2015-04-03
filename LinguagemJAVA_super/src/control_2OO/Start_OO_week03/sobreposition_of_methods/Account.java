package control_2OO.Start_OO_week03.sobreposition_of_methods;

public class Account {

	// ATTRIBUTES
	private double balance;
	private long id;

	// CONSTRUCTOR
	public Account(long id) {
		this.balance = 500; //minimal value
		this.id = id;
	}

	public Account(double balance, long id) {
		this.balance = balance;
		this.id = id;
	}

	// METHODS
	public void deposit(double amount) {
		balance += amount;
		System.out.println("Value deposited: " + amount + "; New Value Balance: " + balance);
	}

	public void withdrawal(double amount) {
		
		//CHECK IF THERE IS ENOUGH VALUE
		if (balance - amount >= 0) {
			balance -= amount;
			System.out.println("Value withdraw: " + amount + "; New Value Balance: " + balance);

		} else {
			System.out.println("ERROR: Not emought balance. Chose a Different amount...");
		}
	}

	// TOSTRING
	public String toString() {
		return "Balance: " + balance + "; From the Account: " + id;
	}

	// GETTERS AND SETTERS
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
