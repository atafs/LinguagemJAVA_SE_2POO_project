package control_3CD;

import pt.progJava.americoLib.control57.PilhaComSynchronized;
import pt.progJava.americoLib.control57.PilhaSemSynchronized;
import pt.progJava.americoLib.control57.SynchronizedBlocksMultiCounter;

public class Start_SYNCHRONIZED_stackWithAndNotSYNC_control57 {
	private static final int MAX_VALUE_ADD = 5;

	public static void main(String[] args) {

		//INSTANTIATE
		PilhaSemSynchronized stack1 = new PilhaSemSynchronized();
		PilhaComSynchronized stack2 = new PilhaComSynchronized();
		SynchronizedBlocksMultiCounter counter = new SynchronizedBlocksMultiCounter();
		
		//ADD
		for (int i = 0; i < MAX_VALUE_ADD; i++) {
			stack1.push( (int)( Math.random() * 1000) );
			counter.incrementConter1();
			stack2.push( (int)( Math.random() * 1000) );
			counter.incrementConter1();
		}
		
		//PRINT
		stack1.printStack();
		stack1.pop();
		stack1.pop();
	
		stack1.printStack();
		stack2.printStack();
		
	
	}

}
