package control_3CD;

import pt.progJava.americoLib.control58.Consumer;
import pt.progJava.americoLib.control58.Producer;
import pt.progJava.americoLib.control58.SharedResourse;

public class Start_CONSUMER_PRODUCER_cp01_control58 {
	
	//ATTRIBUTES
	@SuppressWarnings("unused")
	private SharedResourse container = new SharedResourse();

	public static void main(String[] args) {
	
		//INSTANTIATE
		SharedResourse container = new SharedResourse();
		
		for (int i = 0; i < container.getMax(); i++) {
			container.getConsumers()[i] = new Consumer(container, i);
			container.getProducers()[i] = new Producer(container, i);
			
			container.getConsumers()[i].start();
			container.getProducers()[i].start();
						
		}
	}

}
