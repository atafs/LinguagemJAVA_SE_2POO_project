package control_2OO.Start_OO_week05.colection_compareble;

import java.util.ArrayList;
import java.util.Collections;

public class Teste {

	public static void main(String[] args) {
		ArrayList<Data> lista = new ArrayList<Data>();
		
		lista.add(new Data(10, 3, 2015));
		lista.add(new Data(12, 3, 2015));
		lista.add(new Data(11, 3, 2015));
		
		System.out.println(lista);
		
		Collections.sort(lista);
		
		System.out.println(lista);
	}
	
}
