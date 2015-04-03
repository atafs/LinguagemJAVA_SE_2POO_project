package control_3CD;

import pt.progJava.americoLib.control64.Consumidor;
import pt.progJava.americoLib.control64.Ponte;
import pt.progJava.americoLib.control64.PonteNaoSynchronized;
import pt.progJava.americoLib.control64.Produtor;

public class Start_CONSUMER_PRODUCER_NOTsynchronized_control64 {

	public static void main(String[] args) {

		//criar uma ponte: partilhada pelo produtor e consumidor
		Ponte ponte = new PonteNaoSynchronized();
		
		//criar Threads
		new Thread(new Produtor(ponte)).start();//produz
		new Thread(new Consumidor(ponte)).start();//consome
		
	}
}


