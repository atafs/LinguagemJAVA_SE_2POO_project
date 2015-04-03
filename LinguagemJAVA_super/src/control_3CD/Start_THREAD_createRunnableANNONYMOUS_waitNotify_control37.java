package control_3CD;

import pt.progJava.americoLib.control37.Processor37;

public class Start_THREAD_createRunnableANNONYMOUS_waitNotify_control37 {
	
	public static void main(String[] args) throws InterruptedException {
		
		//
		final Processor37 processor = new Processor37();
		
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					processor.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}				
			}
			
		});
		
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					processor.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}				
			}
			
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
	}

}
