package control_2OO;

import static java.lang.System.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pt.progJava.americoLib.control21.Pessoa;

public class Start_OO_control21_ListArray_Collection {

	public static void main(String[] args) {

		/* array */
		String[] frutas = new String[4];
		frutas[0] = "Laranja";
		frutas[1] = "Maca";
		frutas[2] = "Morango";
		frutas[3] = "Banana";
		// frutas[4] = "ERRO: out of bound exception";

		/*print*/
		for (String string : frutas) {
			out.println(string + ", ");
		}
		out.println("\n");
		
		/*arrayList*/
		ArrayList<String> list = new ArrayList<>();
		list.add("Laranja");
		list.add("Morango");
		list.add("Cereja");
		list.add("Pera");
		list.add("Abacate");
		
		for (String string : list) {
			out.println(string + ",");;
		}
		out.println("\n");
		
		/*ordenar*/
		Collections.sort(list);
		
		for (String string : list) {
			out.println(string + ",");;
		}
		out.println("\n");
		
		/*arrayList*/
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		Pessoa pessoa1 = new Pessoa("Americo", 34);
		Pessoa pessoa2 = new Pessoa("Tomas", 14);
		Pessoa pessoa3 = new Pessoa("Ana", 28);
		Pessoa pessoa4 = new Pessoa("Guida", 19);
		
		/*place people in List*/
		pessoas.add(pessoa1);
		pessoas.add(pessoa2);
		pessoas.add(pessoa3);
		pessoas.add(pessoa4);
		
		Collections.sort(pessoas);
		
		/*print*/
		for (Pessoa pessoa : pessoas) {
			out.println(pessoa + ", ");
		}
		out.println("\n");
		
		
		
	}

}
