package control_3CD;

import pt.progJava.americoLib.control54.CounterSynchronized;
import pt.progJava.americoLib.control54.MyThread;

public class Start_SYNCHRONIZED_countThreads01_control54 {
	private static final int NUM_THREADS = 5;

	public static void main(String[] args) {
		
		//INSTANTIATE
		CounterSynchronized c = new CounterSynchronized();
		MyThread[] t = new MyThread[NUM_THREADS];
		long time = System.currentTimeMillis();
		
		//START THREADS
		for(int i =0; i < NUM_THREADS; i++){
			try {
				t[i]= new MyThread(c);
				t[i].start();
				System.out.println("THREAD: " + i + " created!!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}
		
		//JOIN THREADS
		for(int i =0; i < NUM_THREADS; i++){
			try {
				t[i].join();
				System.out.println("JOIN: " + i + " created!!");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//TIME
		time = System.currentTimeMillis() - time;
		System.out.println("\nNUMBERS Counted = " + c.getC() + "; [units]");
		System.out.println("Time = " + time + "; [ms]");
	}
}
