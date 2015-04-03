package control_3CD;

import java.util.Random;

public class Start_THREAD_createThread03_writeNames_PROFv00  extends Thread {
		Random r=new Random();
		public void run() {
			for (int i = 0; i < 10; i++) {
				try {
					int sleepTime=r.nextInt(4);
					// Pause 
					System.out.println(currentThread() + ": sleep for "+
							sleepTime+" seconds");
					sleep(sleepTime*1000);
					// isto é irrelevante, nunca vai ser interrompida...
				} catch (InterruptedException e) {
					System.out.println(currentThread()
							+ ": "+e.toString());
				}
			}
			System.out.println(currentThread() + ": DONE");
		}
	
	public static void main(String[] args) {
		Start_THREAD_createThread03_writeNames_PROFv00 t=new Start_THREAD_createThread03_writeNames_PROFv00();
		t.start();
		t=new Start_THREAD_createThread03_writeNames_PROFv00();
		t.start();
	}

}
