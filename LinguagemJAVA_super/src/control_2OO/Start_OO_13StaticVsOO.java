package control_2OO;

import pt.progJava.americoLib.control13.Pessoa;

public class Start_OO_13StaticVsOO {

	public static void main(String[] args) {

		/* instantiate */
		Pessoa p1 = new Pessoa();
		Pessoa p2 = new Pessoa();
		Pessoa p3 = new Pessoa();
		Pessoa p4 = new Pessoa();

		p1.setIdade(12);
		p2.setIdade(23);
		p3.setIdade(34);
		p4.setIdade(46);
		System.out.println("[IDADES: " + p1.getIdade() + ", " + p2.getIdade()
				+ ", " + p3.getIdade() + ", " + p4.getIdade() + "];");

		/* objectivo do exercicio */
		System.out.println("[Numero Instancias Criadas: " + Pessoa.getContador() + "];");
	}

}
