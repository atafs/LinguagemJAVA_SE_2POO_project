package control_3CD;

import pt.progJava.americoLib.control60.Interface_Distribuidor;
import pt.progJava.americoLib.control60.Runnable_Fornecedor;
import pt.progJava.americoLib.control60.Runnable_Retalhista;
import pt.progJava.americoLib.control60.SharedResourseSynchronized;

public class Start_SYNCHRONIZED_FornecedorDistribuidorSYNC_control60 {
	
	public static void main(String[] args) {
		
		//criar uma ponte: partilhada pelo produtor e consumidor
		Interface_Distribuidor ponte = new SharedResourseSynchronized();
//		Ponte ponte = new PonteNaoSynchronized();
		
		//criar Threads
		new Thread(new Runnable_Fornecedor(ponte)).start();//produz
		new Thread(new Runnable_Retalhista(ponte)).start();//consome
		
	}

}
