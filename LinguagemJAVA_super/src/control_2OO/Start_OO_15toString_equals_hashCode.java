package control_2OO;

import pt.progJava.americoLib.control15.Pessoa;

public class Start_OO_15toString_equals_hashCode {

	public static void main(String[] args) {

		Pessoa p1 = new Pessoa("Americo", 34);
		System.out.println(p1);

		String a = "carro";
		String b = "bola";
		System.out.println("Equals: " + a == b);
		System.out.println("Equals: " + a.equals(b) + "\n");

		Pessoa p2 = new Pessoa("Tomas", 14);
		System.out.println("Equals p1: " + p1.equals(p2));
		System.out.println("HashCode p1: " + p1.hashCode());
		System.out.println("HashCode p2: " + p2.hashCode() + "\n");

		Pessoa p3 = new Pessoa("Tomas", 14);
		System.out.println("Equals p1: " + p3.equals(p2));
		System.out.println("HashCode p2: " + p2.hashCode());
		System.out.println("HashCode p3: " + p3.hashCode() + "\n");

	}

}
