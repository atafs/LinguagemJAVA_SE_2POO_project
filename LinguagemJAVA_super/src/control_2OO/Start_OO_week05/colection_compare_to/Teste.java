package control_2OO.Start_OO_week05.colection_compare_to;

import java.util.ArrayList;
import java.util.Collections;

import control_2OO.Start_OO_week05.colection_compareble.Data;

public class Teste {

	public static void main(String[] args) {
		ArrayList<Contact> lista = new ArrayList<Contact>();
		
		lista.add(new Contact("Ana", 91, new Data(10, 3, 2015)));
		lista.add(new Contact("Maria", 96, new Data(12, 3, 2015)));
		lista.add(new Contact("Jo�o", 93, new Data(12, 3, 2015)));
		
		System.out.println(lista);
		
		Collections.sort(lista, new ComparadorPorDataIgual());
		
		System.out.println(lista);
	}
	
}
