package control_2OO.Start_OO_week03.sobreposition_of_methods;

public class Test {

	public static void main(String[] args) {

		// INSTANTIATE
		Account account = new Account(2000, 1);
		Account account2 = new Account(1000, 2);
		OverdraftAccount overAcc = new OverdraftAccount(300, 3);
		OverdraftAccount overAcc2 = new OverdraftAccount(200, 4);
		OverdraftAccount overAcc3 = (OverdraftAccount) overAcc;

		// METHODS
		System.out.println("");
		System.out.println("------------PRINT1--------------");
		System.out.println("Account Balance: " + account.getBalance()
				+ "; Id: " + account.getId());
		System.out.println("Account Balance: " + account2.getBalance()
				+ "; Id: " + account2.getId());
		System.out.println(overAcc + ";");
		System.out.println(overAcc2 + ";");

		// MORE
		System.out.println("");
		System.out.println("------------PRINT2--------------");
		account.deposit(500);
		account.withdrawal(200);
		account.withdrawal(5000);

		System.out.println("");

		overAcc.deposit(500);
		overAcc.withdrawal(50);
		overAcc.withdrawal(949);

		// MORE
		System.out.println("");
		System.out.println("------------PRINT3--------------");
		System.out.println(account.toString());
		System.out.println(overAcc.toString());
		overAcc3.methodOnlyOfOverdraftAccount();

		// MORE
		System.out.println("");
		System.out.println("------------PRINT4--------------");
		account.withdrawal(200000);

	}

}
