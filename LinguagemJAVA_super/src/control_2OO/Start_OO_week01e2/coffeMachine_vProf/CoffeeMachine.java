package control_2OO.Start_OO_week01e2.coffeMachine_vProf;

import java.util.ArrayList;

public class CoffeeMachine {

	private Status status;
	private ArrayList<Product> list;
	private double credit;
	private double change;
	private Product selectedProduct;
	
	
	public CoffeeMachine(ArrayList<Product> list) {
		this.list = list;
		status = Status.INACTIVE;
	}
	
	public void insertCoin(double value) {
		if(status == Status.INACTIVE) {
			status = Status.PAYING;
		}
		
		credit += value;
	}
	
	public void itemSelection(String productName) {
		if(status == Status.PAYING) {
			
			for (Product product : list) {
				if(productName.equals(product.getName())) {
					if(credit >= product.getPrice()) {
						selectedProduct = product;
						status = Status.DISPENSING;
						return;
					}
				}
			}
		}
	}
	
	public void finishedFilling() {
		if(status == Status.DISPENSING) {
			
			if(selectedProduct != null) {
				status = Status.WAITING_PICKUP;
				change = credit - selectedProduct.getPrice();
			
			} else {
				change = credit;
				status = Status.PAYING;
			}
		}
	}
	
	public void clientPickedUpCupAndChange() {
		if(status == Status.WAITING_PICKUP) {
			status = Status.INACTIVE;
			credit = 0;
			change = 0;
			selectedProduct = null;
		}
	}
	
	public String toString() {
		String toReturn = "------ Coffee Machine --------\n";
		toReturn += "Status: " + status + "\n";
		toReturn += "Credit: " + credit + "\n";
		if(selectedProduct != null)
			toReturn += "SelectedProduct: " + selectedProduct.toString() + "\n";
		else
			toReturn += "SelectedProduct: ...\n";
			
		toReturn += "Change: " + change + "\n";
		return toReturn;
	}
	
	
	
	
	
	
}
