package control_2OO;

import OO_04PessoaTemCarro.Carro;
import OO_04PessoaTemCarro.PessoaComCarro;

public class Start_OO_04PessoaComCarro {

	public static void main(String[] args) {

		/* instantiate classes */
		PessoaComCarro p = new PessoaComCarro();
		p.setNome("Americo");
		p.setIdade(34);
		
		Carro c = new Carro();
		c.setAno(1976);
		c.setNome("Mustang");
		
		/* place the object Carro in attribute Pessoa */
		p.setCarro(c);
		
		p.getCarro().andar("60 Kmh\n");
		p.verificarIdade();

		
		
	}

}
