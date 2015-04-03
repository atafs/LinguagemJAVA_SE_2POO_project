package control_2OO.Start_OO_week01e2.lampEnergyUsed_v1;

import java.util.ArrayList;

public class LampTest {

	// ATTRIBUTES
	private static ArrayList<Lamp> list = new ArrayList<>();
	private static int count = 0;

	public static void main(String[] args) {

		// INSTANTIATE
		list.add(new Lamp(60, 1));
		list.add(new Lamp(30, 2));

		echoOn(list.get(0).toString());

		list.get(0).setLampOnTime();
		list.get(1).setLampOnTime();
		echoList();

		// SLEEP
		try {
			Thread.sleep(3000);
			list.get(0).setLampOffTime();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		list.get(0).calcDurationOnTime();
		list.get(0).calcConsuption();
		echoList();

		sleepWithoutThread(4000);
		
		list.get(1).setLampOffTime();
		list.get(1).calcDurationOnTime();
		list.get(1).calcConsuption();
		echoList();

	}

	/** VOID: works as a clock ;-) */
	public static void sleepWithoutThread(int milis) {

		// LOCAL variables
		double initialTime = System.currentTimeMillis();
		double finalTime = System.currentTimeMillis();

		// WHILE
		while (finalTime - initialTime < milis) {
			finalTime = System.currentTimeMillis();

		}

	}

	/** VOID: PRINT ToSTRING OF THE MACHINE */
	public static void echoList() {
		System.out.println("-------------LIST" + count + "--------------");
		for (Lamp lamp : list) {
			System.out.println(lamp.toString());
		}
		System.out.println("-------------END--------------");
		count++;

	}

	public static void echoOff(String s) {
		System.err.println(s);
	}

	public static void echoOn(String s) {
		System.out.println(s);
	}

}
