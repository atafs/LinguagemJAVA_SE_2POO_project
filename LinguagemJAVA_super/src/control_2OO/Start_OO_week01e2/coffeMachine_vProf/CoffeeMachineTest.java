package control_2OO.Start_OO_week01e2.coffeMachine_vProf;

import java.util.ArrayList;

public class CoffeeMachineTest {

	public static void main(String[] args) {
		
		Product product1 = new Product("Expresso", 1.0);
		Product product2 = new Product("Cappuccino", 2.0);
		Product product3 = new Product("Chocolate", 2.0);
		
		ArrayList<Product> list = new ArrayList<Product>();
		
		list.add(product1);
		list.add(product2);
		list.add(product3);
		
		CoffeeMachine machine = new CoffeeMachine(list);
		
		System.out.println(machine.toString());
		
		machine.insertCoin(2);
		System.out.println(machine.toString());
		
		machine.insertCoin(1);
		System.out.println(machine.toString());
		
		machine.itemSelection("Product");
		System.out.println(machine.toString());
		
		machine.finishedFilling();
		System.out.println(machine.toString());
		
		machine.clientPickedUpCupAndChange();
		System.out.println(machine.toString());
		
	}
}
