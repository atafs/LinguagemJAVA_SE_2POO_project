package control_2OO;

import Control.Cliente;
import controle.Funcionario;

public class Start_OO_06ClassAbstract {

	public static void main(String[] args) {
		
		/*instantiate*/
		Funcionario f = new Funcionario();
		/*insert attributes*/
		f.cpf 			= "123456789120";
		f.idade 		= 34;
		f.matricula 	= "54149";
		f.peso			= "67";
		/*methods*/
		f.andar();
		f.trabalhar();
		
		/*instantiate*/
		Cliente c = new Cliente();
		/*insert attributes*/
		c.cpf = "11111111111";
		c.idade = 36;
		c.nome = "Guida";
		c.numeroCliente = 2345;
		/*methods*/
		c.comprar();
		
		/*nao quero instanciar uma classe; apenas quer definir atributos e rotinas*/
		/*por uma questao de organizacao e limpeza na organizacao do codigo*/
		//PessoaAbstrata p = new PessoaAbstrata();
		
	}

	

}
