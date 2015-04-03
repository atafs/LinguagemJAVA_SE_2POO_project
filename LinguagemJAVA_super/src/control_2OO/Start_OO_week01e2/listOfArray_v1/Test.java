package control_2OO.Start_OO_week01e2.listOfArray_v1;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		
		String matricula1 = "M1";
		String matricula2 = "M2";
		String matricula3 = "M3";
		String matricula4 = "M4";
		
		//ARRAY
		String[] list1 = new String[10];
		list1[0] = matricula1;
		list1[1] = matricula2;
		list1[2] = matricula3;
		list1[3] = matricula4;
		
	
		//ARRAYLIST
		ArrayList<String> list2 = new ArrayList<>();
		list2.add(matricula1);		
		list2.add(matricula2);	
		list2.add(matricula3);	
		list2.add(matricula4);	
		
		//METHOD: size()
		list2.size();
		
		//METHOD: get()
		@SuppressWarnings("unused")
		String m = list2.get(3);
		System.out.println("ELEMENT of index3: " + list2.get(3) + "\n");
		
		for (String string : list2) {
			System.out.println(string);
		}
		System.out.println("\n");
		
		System.out.println("ELEMENT DELETED: " + list2.get(1));
		list2.remove(matricula2);
		for (String string : list2) {
			System.out.println(string);
		}	
	}
}
