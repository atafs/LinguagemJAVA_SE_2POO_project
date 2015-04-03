package control_3CD;

public class Start_THREAD_threadClass01 extends Thread{
	
	//a thread vai fazer...
	public void run() {
		System.out.println("O meu thread!!");
	}
	
	//main
	public static void main(String[] args) {
		Thread t = new Start_THREAD_threadClass01();
		t.start();
	}
	
	

}
