package control_3CD;

import pt.progJava.americoLib.control51.MyThread;

public class Start_THREAD_threadClass02_control51 {
	
	//atributo
	private static final int NUM_THREAD = 10;
	
	//main
	public static void main(String[] args) {
		
		//criar um array the Threads
		Thread[] threads = new MyThread[NUM_THREAD];
		
		//ciclo de repeticao (um conj de Threads)
		for(int i=0; i < NUM_THREAD; i++) {
			
			threads[i] = new MyThread(i); //instanciar a class MyTread
			threads[i].start();//iniciar a thread
		}	
		
		//criar o apanha excepcoes
		try {
			
			//dentro do try catch: juntar as threads na posicao 0
			threads[0].join();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//interromper todas as threads (ciclo de repeticao)
		for (int i=1; i< NUM_THREAD; i++) {
			threads[i].interrupt();
		}
		
		//imprime uma mensagem de fim
		System.out.println("DONE");
		
	}
}
