package control_3CD;

public class Start_THREAD_createThread02_ExecutorSemPool {

	public static void main(String[] args) {

		// create tasks
		Runnable printA = new PrintChar('a', 100);
		Runnable printB = new PrintChar('b', 100);
		Runnable print100 = new PrintNum(100);

		// create threads
		Thread thread1 = new Thread(printA); 
		Thread thread2 = new Thread(printB); 
		Thread thread3 = new Thread(print100); 
	
		// start threads
		thread1.start();
		thread2.start();
		thread3.start();
	}
}

	class PrintChar implements Runnable {

		// atributos
		private char charToPrint;
		private int times;

		// construtor
		public PrintChar(char charToPrint, int times) {
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
	
	class PrintNum implements Runnable {

		//atributos
		private int lastNum;
		
		//construtor
		public PrintNum(int lastNum) {
			this.lastNum = lastNum;
		}
		
		@Override
		public void run() {
			for (int i = 0; i <= lastNum; i++) {
				System.out.println("[ " + i + " ]");
			}
		}	
	}

