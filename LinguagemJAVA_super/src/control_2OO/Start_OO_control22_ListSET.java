package control_2OO;

import java.util.LinkedHashSet;
import java.util.Set;

import pt.progJava.americoLib.control22.Pessoa;

public class Start_OO_control22_ListSET {

	public static void main(String[] args) {

		Set<Pessoa> pessoas = new LinkedHashSet<Pessoa>();
		
		Pessoa p1 = new Pessoa("Americo", 34, "111111111");
		Pessoa p2 = new Pessoa("Tomas", 14, "111111111");
		Pessoa p3 = new Pessoa("Ana", 18, "111111111");
	
		/*addList*/
		pessoas.add(p1);
		pessoas.add(p2);
		pessoas.add(p3);
		
		/*print*/
		for (Pessoa pessoa : pessoas) {
			System.out.println(pessoa);
		}
		System.out.println();
		
		Pessoa p4 = new Pessoa("Americo", 34, "111111112");
		Pessoa p5 = new Pessoa("Tomas", 14, "222222222");
		Pessoa p6 = new Pessoa("Ana", 18, "333333333");
		Pessoa p7 = new Pessoa("Ana", 18, "333333334");
	
		/*addList*/
		pessoas.add(p4);
		pessoas.add(p5);
		pessoas.add(p6);
		pessoas.add(p7);
		
		/*print*/
		for (Pessoa pessoa : pessoas) {
			System.out.println(pessoa);
		}
		
		

		
	}


}
