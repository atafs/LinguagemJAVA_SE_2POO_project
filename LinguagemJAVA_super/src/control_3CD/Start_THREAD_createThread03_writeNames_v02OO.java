package control_3CD;

import java.util.Random;

public class Start_THREAD_createThread03_writeNames_v02OO extends Thread {

	//ATTRIBUTES
	private final int DEZ = 10; //numero de iteracoes
	
	@Override
	public void run() {
		
		//ACTION of THREAD
		for (int i = 0; i < DEZ; i++) {

			try {
				System.err.println("[" + currentThread().getName().toString() + " -> count-" + i + "]");
				sleep(new Random().nextInt(1000)); //2,5seconds
					
			} catch (InterruptedException e) {
				System.out.println("\n[ERROR: "+ currentThread() + " WAS INTERRUPTED...]\n");
			}
		}
	}

	
	//TESTS
	public static void main(String[] args) {
		
		System.out.println("PROGRAM -> START");
		
		//INSTANTIATE
		Start_THREAD_createThread03_writeNames_v02OO thread1 = new Start_THREAD_createThread03_writeNames_v02OO();
		thread1.start();
		
		Start_THREAD_createThread03_writeNames_v02OO thread2 = new Start_THREAD_createThread03_writeNames_v02OO();
		thread2.start();
		
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		//PRINTS
		System.out.println("PROGRAM -> END");
		
	}


}
