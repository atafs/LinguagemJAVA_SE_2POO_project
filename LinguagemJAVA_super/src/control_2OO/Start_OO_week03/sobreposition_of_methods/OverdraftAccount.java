package control_2OO.Start_OO_week03.sobreposition_of_methods;


public class OverdraftAccount extends Account{
	
	//ATTRIBUTE
	protected double overdraftAmount;
	
	//CONSTRUCTOR
	public OverdraftAccount(long id) {
		super(id);
	}
	
	
	public OverdraftAccount(double overdraftAmount, long id) {
		super(id);
		this.overdraftAmount = overdraftAmount;
	}
	
	public void methodOnlyOfOverdraftAccount() {
		System.out.println("ONLY FROM OverDraftAccount");
	}
	
	//OVERRIDE
	@Override
	public void withdrawal(double amount) {
		if (super.getBalance() - amount >= 0) {
			super.withdrawal(amount);
		} else if (super.getBalance() + overdraftAmount  - amount >= 0) {
			overdraftAmount -= amount - getBalance();
			super.withdrawal(super.getBalance());
			System.out.println("ERROR: Not emought balance. Chose a Different amount...");
		}
	}
	
	// TOSTRING
	@Override
	public String toString() {
		return "Account Balance: " + super.getBalance() + "; Id: " + super.getId() +  "; OverdraftAmount: " + overdraftAmount;
	} 
	
}
