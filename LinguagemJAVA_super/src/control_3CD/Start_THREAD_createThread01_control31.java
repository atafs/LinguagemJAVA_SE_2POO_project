package control_3CD;


class Runner1 extends Thread {
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Hello " + i);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}


public class Start_THREAD_createThread01_control31 {

	public static void main(String[] args) {
		Runner1 runner1 = new Runner1();
		runner1.start();
		
		Runner1 runner2 = new Runner1();
		runner2.start();
	}
}
