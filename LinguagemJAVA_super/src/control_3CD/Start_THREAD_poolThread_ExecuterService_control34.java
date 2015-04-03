package control_3CD;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor2 implements Runnable {

	private int id;

	public Processor2(int id) {
		this.id = id;
	}

	@Override
	public void run() {

		//
		System.out.println("Starting...." + id);

		//
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		//
		System.out.println("Completed..." + id);
	}
}

public class Start_THREAD_poolThread_ExecuterService_control34 {

	public static void main(String[] args) {

		//
		ExecutorService executer = Executors.newFixedThreadPool(2);

		//
		for (int i = 1; i <= 5; i++) {
			executer.submit(new Processor2(i));
		}

		//
		executer.shutdown();
		System.out.println("All tasks SUBMITTED... \n");

		//
		try {
			executer.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		//
		System.out.println("All tasks COMPLETED...");
	}
}
