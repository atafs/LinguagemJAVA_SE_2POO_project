package control_3CD;

import pt.progJava.americoLib.control63.ContaConjuntaNotSYNC;

public class Start_SYNCHRONIZED_accountConsoleNotSYNC_control63 implements Runnable {//rodar em varias Threads

	//compras em familia em comum (?)
	ContaConjuntaNotSYNC conta = new ContaConjuntaNotSYNC();
	
	public static void main(String[] args) {
		
		//abrir varias Threads ao mesmo tempo
		Start_SYNCHRONIZED_accountConsoleNotSYNC_control63 irAsCompras = new Start_SYNCHRONIZED_accountConsoleNotSYNC_control63();
		
		new Thread(irAsCompras, "Pai").start();//varios processos de compras, dar mome a Thread
		new Thread(irAsCompras, "Mae").start();
		new Thread(irAsCompras, "Filha").start();
		new Thread(irAsCompras, "Nany").start();
	}
	
	@Override
	public void run() {
		
		//sem o metodo run(), as Threads sao criadas e mortas logo...
		
		//cliente actual, busco o nome e guardo numa String
		String cliente = Thread.currentThread().getName();
		
		//pelo menos 5 compras por cliente
		for(int i=0; i<5; i++) {
			conta.sacar(20, cliente);
			//conta sem saldo (excepcao)
			if(conta.getSaldo() < 0) {
				System.out.println("Estourou...");
			}
		}
	}
	
	

}
