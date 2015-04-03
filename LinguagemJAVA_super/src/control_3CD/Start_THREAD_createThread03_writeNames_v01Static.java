package control_3CD;

import java.util.Random;

public class Start_THREAD_createThread03_writeNames_v01Static extends Thread {

	//ATTRIBUTES
	private String[] nomes = { "Americo", "Tomas" };
	
	//INSTANTIATE
	private static Thread threadPrimeiroNome = new Start_THREAD_createThread03_writeNames_v01Static();
	private static Thread threadSegundoNome = new Start_THREAD_createThread03_writeNames_v01Static();
	private static final int DEZ = 10; //numero de iteracoes
	private static int countPrints;


	@Override
	public void run() {
		
		//ACTION of THREAD
		for (int i = 0; i < DEZ; i++) {

			try {
				if(currentThread().equals(threadPrimeiroNome)) {
					System.err.println("[" + currentThread().getName().toString() + " -> " + nomes[0] + ", count-" + i + "]");
					countPrints++;
					sleep(new Random().nextInt(1000)); //2,5seconds
					
				} else {
					System.out.println("\t\t\t\t[" + currentThread().getName().toString() + " -> " + nomes[1] + ", count-" + i + "]");
					countPrints++;
					sleep(new Random().nextInt(1000)); //2,5seconds
					
					//TEST: verify if its Alive in iteration 7
					if( i == ((int)Math.random()*10) ) 
						System.err.println("\n\t\t\t\t[" + currentThread() + " -> isAlive: " + threadSegundoNome.isAlive() + "]\n");
				}
				
			} catch (InterruptedException e) {
				System.out.println("\n[ERROR: "+ currentThread() + " WAS INTERRUPTED...]\n");
				break; //if threadPrimeiroNome is interrupted
			}
		}
	}
	
	//TESTS
	public static void main(String[] args) {
		
		System.out.println("PROGRAM -> START");
		
		//START
		threadPrimeiroNome.start();
		threadSegundoNome.start();
		
		try {
			
			//INTERRUPT
			System.out.println("\n" + currentThread() +  " sleep from 0-10 seconds (random)\n");
			sleep(new Random().nextInt(10000)); //10seconds
			
			threadPrimeiroNome.interrupt();
			//threadSegundoNome.interrupt();
			
			//JOIN
			threadPrimeiroNome.join();
			threadSegundoNome.join();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		//PRINTS
		System.err.println("\n\n[threadPrimeiroNome -> isAlive: " + threadPrimeiroNome.isAlive() + "]");
		System.err.println("[threadSegundoNome -> isAlive: " + threadSegundoNome.isAlive() + "]");
		System.out.println("COUNT PRINTS -> " + countPrints);
		System.out.println("PROGRAM -> END");
		
	}
}
