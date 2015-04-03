package control_3CD;

import pt.progJava.americoLib.control33.Worker1;
import pt.progJava.americoLib.control33.Worker2;
import pt.progJava.americoLib.control33.Worker3;
import pt.progJava.americoLib.control33.Worker4;

public class Start_THREAD_poolThread01_SYNC_NotSYNC_control33 {

	public static void main(String[] args) {
		
		new Worker1().main();
		new Worker2().main();	
		new Worker3().main();
		new Worker4().main();

	}

}
