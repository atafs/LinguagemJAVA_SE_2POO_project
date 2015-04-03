package control_2OO;

import Control.Pessoa;

public class Start_OO_03Pessoa {

	public static void main(String[] args) {

		Pessoa p1 = new Pessoa();
		System.out.println(p1 + "\n");
		
		p1.nome = "Americo";
		p1.idade = 34;
		p1.peso = 75.2;
		
		Pessoa p2 = new Pessoa("Tomas", 22, 66.3);
		
		/* prints */
		System.out.println(p1.nome + "\n");
		System.out.println(p2.peso + "\n");
		System.out.println(p1 + "\n");
		System.out.println(p2 + "\n");
		p1.andar();
		p2.verificarIdade();
	}

}
