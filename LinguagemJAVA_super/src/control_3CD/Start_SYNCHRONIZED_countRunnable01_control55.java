package control_3CD;

import pt.progJava.americoLib.control55.Contador;
import pt.progJava.americoLib.control55.MyThread;

public class Start_SYNCHRONIZED_countRunnable01_control55 {
	
	private static final int NUM_THREADS = 5;

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		
		Contador c = new Contador();
		Thread[] t = new Thread[NUM_THREADS];
		long time = System.currentTimeMillis();
		
		//inicializar um conjunto de Threads
		for(int i =0; i < NUM_THREADS; i++){
			String s = "Thread" + i;
			
			t[i]= new Thread(new MyThread(c, s));
			t[i].start();
		}
		
		for(int i =0; i < NUM_THREADS; i++){
			try {
				t[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		time = System.currentTimeMillis() - time;
		System.out.println("------------------------------");
		System.out.println("\nNumber of Threads = " + t.length);
		System.out.println("Number of Counts EACH thread = " + new MyThread(c, "").getMaxCount());
		System.out.println("\nCounter = " + c.getValor());
		System.out.println("Time = " + time + "; [ms]");
		System.out.println("\n------------------------------\n");

		

	}

}
