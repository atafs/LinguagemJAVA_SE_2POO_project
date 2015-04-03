package control_2OO.Start_OO_week01e2.coffeeMachine_v1.tests;

import java.util.ArrayList;

import control_2OO.Start_OO_week01e2.coffeeMachine_v1.CoffeeMachine;
import control_2OO.Start_OO_week01e2.coffeeMachine_v1.Product;

public class CoffeeMachineTest {

	//ATTRIBUTES
	private static CoffeeMachine machine;
	private static ArrayList<Product> list = new ArrayList<>();
	
	//MAIN
	public static void main(String[] args) {
		
		//INSTANTIATE
		machine = new CoffeeMachine(list);
		list.add(new Product("Expresso", 1.0));
		list.add(new Product("Cappuccino", 2.5));
		list.add(new Product("Chocolate", 1.5));
		list.add(new Product("Tea", 0.5));
		
		echoMachine();
		
		machine.insertCoin(2);
		echoMachine();		
		
		machine.insertCoin(1);
		echoMachine();		
		
		machine.itemSelection("Cappuccino");
		echoMachine();		
		
		machine.itemSelection("Am");
		echoMachine();
		
		machine.finishedFilling();
		echoMachine();		
		
		machine.clientPickedUpCupAndChange();
		echoMachine();

		//empty spaces
		for (int i = 0; i < 4; i++) {
			System.out.println();
		}
		
		
	}
	
	/** VOID: PRINT ToSTRING OF THE MACHINE */
	public static void echoMachine() {
		System.out.println(machine.toString());

	}

}
