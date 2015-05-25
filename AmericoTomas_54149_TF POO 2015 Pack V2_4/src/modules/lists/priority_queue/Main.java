package modules.lists.priority_queue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) {
        
		//LIST PriorityQUEUE and COMPARATOR
		Comparator<String> comparator = new StringLengthComparator();
        PriorityQueue<String> queue =  new PriorityQueue<String>(10, comparator);
        queue.add("short");
        queue.add("very long INDEED");
        queue.add("medium");
        
        //CICLE
        while (queue.size() != 0) {
        	System.out.println(queue.remove());
        }
    }
}
