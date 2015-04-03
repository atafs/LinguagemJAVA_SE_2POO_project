package control_3CD;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Start_CONSUMER_PRODUCER_usingBlockingQueue02_control42 {

	//ATTRIBUTES
	private static ArrayBlockingQueue<Integer> buffer = new ArrayBlockingQueue<>(2);
	
	//MAIN
	public static void main(String[] args) {
	
		/*create a poolThread with two threads*/
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(new ProducerTask());
		executor.execute(new ConsumerTask());
		executor.shutdown();
	}
	
	//INNER CLASS
	private static class ProducerTask implements Runnable {

		@Override
		public void run() {
			
			try {
				int i = 1;
				while(true) {
					System.out.println("Producer WRITES " + i);
					buffer.put(i++); //adds value to the buffer
					
					Thread.sleep((int)(Math.random() * 2000));
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	//INNER CLASS
	private static class ConsumerTask implements Runnable {

		@Override
		public void run() {
			
			try {
				while(true) {
					System.out.println("\t\t\t\tConsumer READS " + buffer.take());
					
					Thread.sleep((int)(Math.random() * 2000));

				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
