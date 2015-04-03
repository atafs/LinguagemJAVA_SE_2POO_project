package control_2OO.Start_OO_week01e2.lampEnergyUsed_vProf;

import java.util.ArrayList;

public class LampTest {

	
	public static void main(String[] args) {
		
		Lamp l1 = new Lamp(10);
		Lamp l2 = new Lamp(30);
		Lamp l3 = new Lamp(50);
		
		ArrayList<Lamp> list = new ArrayList<Lamp>();
		
		list.add(l1);
		list.add(l2);
		list.add(l3);
		
		for (Lamp lamp : list) {
			System.out.println(lamp.toString());
		}
		
		for (Lamp lamp : list) {
			lamp.turnOn();
		}
		
		double initialTime = System.currentTimeMillis();
		double finalTime = System.currentTimeMillis();
		while(finalTime - initialTime < 5 * 1000){
			finalTime = System.currentTimeMillis();
		}
		
		for (Lamp lamp : list) {
			lamp.turnOff();
		}
		
		for (Lamp lamp : list) {
			System.out.println(lamp.toString());
		}
	}
}
