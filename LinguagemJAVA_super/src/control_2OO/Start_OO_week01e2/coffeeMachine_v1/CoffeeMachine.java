package control_2OO.Start_OO_week01e2.coffeeMachine_v1;

import java.util.ArrayList;

import control_2OO.Start_OO_week01e2.coffeeMachine_v1.enums.StatusMachine;

public class CoffeeMachine {

	// ATTRIBUTES
	private ArrayList<Product> list;
	private double credit;
	private double change;
	private Product selectedProduct;
	private StatusMachine status;

	// CONSTRUCTOR
	public CoffeeMachine(ArrayList<Product> list) {
		this.list = list;
		status = StatusMachine.INACTIVE;
	}

	/** VOID: pay for a coffee */
	public void insertCoin(double value) {

		// check for the readiness of the machine
		if (status == StatusMachine.INACTIVE) {
			status = StatusMachine.PAYING;
		}

		// credit available to buy coffee
		credit += value;
	}

	/** VOID: select and take the product from the machine */
	public void itemSelection(String productName) {

		if (status == StatusMachine.PAYING) {
			// check if is in the list and check for the credit if it is enough
			for (Product product : list) {
				if (productName.equals(product.getName())
						&& credit >= product.getPrice()) {
					selectedProduct = product;

					// serving the coffee
					status = StatusMachine.DISPENSING;

					// stop the cycle (efficiency)
					return;
				} else {
					System.err.println("------------- COFFEE MACHINE ----------------\n");
					System.err.println("ERROR: THERE IS NO SUCH PRODUCT\n");
				}
			}
		}
	}

	/** VOID: filling the cup and leading with the change and credit */
	public void finishedFilling() {
		if (status == StatusMachine.DISPENSING) {

			// check if a product was selected, therefore exists
			if (selectedProduct != null) {
				status = StatusMachine.WAITING_PICKUP;

				// get change = value inserted - the price of the product
				change = credit - selectedProduct.getPrice();
			} else {
				// nothing was purchased
				change = credit;

				// change state of the machine
				status = StatusMachine.PAYING;
			}
		}
	}

	/** VOID: ending the process of purchase of the product */
	public void clientPickedUpCupAndChange() {
		if (status == StatusMachine.WAITING_PICKUP) {
			
			//return change
			if(change > 0)
				System.err.println("RETURNING THE CHANGE: " + change + ". WAIT A MOMENT...\n");
			
			// finish and restart the machine
			status = StatusMachine.INACTIVE;
			credit = 0;
			change = 0;
			selectedProduct = null;
		}
	}

	/** ToSTRING */
	@Override
	public String toString() {

		// create a print
		String toReturn = "------------- COFFEE MACHINE ----------------\n";
		toReturn += "STATUS: " + status + "\n";
		toReturn += "CREDIT: " + credit + "\n";

		// to prevent to break with null
		if (selectedProduct != null)
			toReturn += "SELECTED: " + selectedProduct.toString() + "\n";
		else
			toReturn += "SELECTED: ... \n";
		
		toReturn += "CHANGE: " + change + "\n";
		return toReturn;
	}
}
