package control_3CD;

import pt.progJava.americoLib.control65.MyThread;
import pt.progJava.americoLib.control65.ThreadGUI;

public class Start_SWING_RACE01_HORSE_control65 {

	/* *********************atributos****************************** */
	private static final int NUM_THREADS = 3;// 3 cavalos

	/* ************************main******************************** */
	public static void main(String[] args) {
		
		// instanciar o array de threads (varias)
		Thread[] threads = new MyThread[NUM_THREADS];
		// instanciar a GUI classe
		ThreadGUI guiTread = new ThreadGUI();

		// instanciar as threads e iniciar
		for (int i = 0; i < NUM_THREADS; i++) {
			threads[i] = new MyThread(i, "HorseISCTE" + i, guiTread);
			// iniciar a thread
			threads[i].start();
		}

		try {
			// junta as threads na posicao zero do array 
			threads[0].join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < NUM_THREADS; i++) {
			// mata as threads e confirma se estao mesmo mortas
			threads[0].interrupt();
			threads[i].isAlive();
			System.out.println(threads[i].toString());
			
		}
		System.out.println("Concluido com Sucesso!!");

	}

}
