package control_2OO;

import controle.Funcionario;

public class Start_OO_05RelacaoE_Um {

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
	}

}
