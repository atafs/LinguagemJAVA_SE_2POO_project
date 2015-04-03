package control_3CD;

public class Start_THREAD_threadRunnable01 implements Runnable{

	
	
	@Override
	public void run() {
		System.out.println("O meu Thread");
	}

	//main
	public static void main(String[] args) {
		Runnable omt = new Start_THREAD_threadClass01();
		Thread t = new Thread(omt);
		
		t.start();
	}
}
