package control_3CD;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Start_SYNCHRONIZED_LOCK_accountWithSync {

	// atributo
	private static Account account = new Account();

	// main
	public static void main(String[] args) {

		// variavel local (poolThreads)
		ExecutorService executor = Executors.newCachedThreadPool();

		// create and lunch 100 threads with Runnable
		for (int i = 0; i < 100; i++) {
			executor.execute(new AddPennyTask());
		}
		executor.shutdown();

		// wait until all tasks are finished
		while (!executor.isTerminated()) {
		}
		
	}

	// inner class
	public static class AddPennyTask implements Runnable {
		@Override
		public void run() {
			account.deposit(1);
			System.out.println("What is the balance? " + account.getBalance());

		}
	}

	// inner class
	public static class Account {

		// atributos
		private static Lock lock = new ReentrantLock();// create lock
		private int balance = 0;

		// getter
		public int getBalance() {
			return balance;
		}

		// rotina: deposito
		public void deposit(int amount) {
			lock.lock();// aquire lock

			try {
				int newBalance = balance + amount;//localVariable
				Thread.sleep(5);//simulate time to execute operation
				balance = newBalance;

			} catch (InterruptedException ex) {
				ex.printStackTrace();

			} finally {
				lock.unlock();
			}
		}
	}
}
