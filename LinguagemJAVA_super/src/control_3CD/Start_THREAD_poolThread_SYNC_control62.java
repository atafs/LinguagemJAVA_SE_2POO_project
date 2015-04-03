package control_3CD;

import pt.progJava.americoLib.control62.Counter;
import pt.progJava.americoLib.control62.MyThread;

public class Start_THREAD_poolThread_SYNC_control62 {
	private static final int NUM_THREADS = 5;

	public static void main(String[] args) {
		
		//inicializar do Counter e do Array de Threads
		Counter c = new Counter();
		MyThread[] t = new MyThread[NUM_THREADS];
		
		long time = System.currentTimeMillis();
		
		//inicializar as Threads
		for(int i =0; i < NUM_THREADS; i++){
			t[i]= new MyThread(c);
			t[i].start();
		}
		
		//junta as threads: join()???
		for(int i =0; i < NUM_THREADS; i++){
			try {
				t[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//controlo do tempo, counter and time
		time = System.currentTimeMillis() - time;
		System.out.println("[Counter = " + c.getC() + "]; [units]");
		System.out.println("[Time = " + time + "]; [ms]");
	}
}
