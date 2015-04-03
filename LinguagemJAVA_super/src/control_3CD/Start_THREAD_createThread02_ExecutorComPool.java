package control_3CD;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Start_THREAD_createThread02_ExecutorComPool {

	public static void main(String[] args) {

		// create a fixed thread pool with max
		ExecutorService executor = Executors.newFixedThreadPool(3);

		// submite runnable tasks to the executer
		executor.execute(new PrintChar1('a', 100));
		executor.execute(new PrintChar1('b', 100));
		executor.execute(new PrintNum1(100));

		executor.shutdown();
	}
}

	class PrintChar1 implements Runnable {

		// atributos
		private char charToPrint;
		private int times;

		// construtor
		public PrintChar1(char charToPrint, int times) {
			this.charToPrint = charToPrint;
			this.times = times;
		}

		@Override
		public void run() {
			for (int i = 0; i < times; i++) {
				System.out.println(charToPrint);
			}
		}
	}
	
	class PrintNum1 implements Runnable {

		//atributos
		private int lastNum;
		
		//construtor
		public PrintNum1(int lastNum) {
			this.lastNum = lastNum;
		}
		
		@Override
		public void run() {
			for (int i = 0; i <= lastNum; i++) {
				System.out.println("[ " + i + " ]");
			}
		}	
	}

