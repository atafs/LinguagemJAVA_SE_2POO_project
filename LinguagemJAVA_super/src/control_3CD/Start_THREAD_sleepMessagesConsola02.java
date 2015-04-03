package control_3CD;

import java.util.Random;

public class Start_THREAD_sleepMessagesConsola02 extends Thread {
	
	public void run() {
		
		//array de String
		String importantInfo[] = {"Mars eat oats", "Does eat oats", "Little lambs eat ivy", "A kid will ivy too"};
		
		//ciclo (instrucao de repeticao)
		for(int i = 0; i < importantInfo.length; i++) {
			
			//colocar um try catch para apanhar excepcoes
			try {
			
				System.out.println(currentThread() + ": sleep for 4 seconds");
				sleep(4000);
				
			
				//print message
				System.out.println("\t" + importantInfo[i]);
			
			} catch (InterruptedException e) {
				System.out.println(currentThread() + ": OPS! I was interruped");
			}
			
		}
	}
	
	public static void main(String[] args) throws InterruptedException{
		
		Thread t = new Start_THREAD_sleepMessagesConsola02();
		t.start();
		int pausa = (new Random().nextInt(16000));
		System.out.println(currentThread() + ": sleep for " + pausa/1000 + "seconds");
		sleep(pausa);
		t.interrupt();
	}

}
