package control_3CD;

//INNER CLASS
class Runner2 implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			
			System.out.println("Hello " + i);
			
			try {
				Thread.sleep((int)(Math.random() * 1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}


public class Start_THREAD_createRunnable01_control31 {

	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Runner2());
		Thread t2 = new Thread(new Runner2());
		
		t1.start();
		t2.start();
		
	}
}
