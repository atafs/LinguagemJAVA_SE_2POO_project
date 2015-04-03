package control_2OO.Start_OO_week03.alunos.doutoramento;

import control_2OO.Start_OO_week03.alunos.aluno_abstract.Aluno;

public class AlunoDoutoramento extends Aluno {

	public AlunoDoutoramento(int numero, String nome) {
		super(numero, nome);
	}

	@Override
	public String getTipo() {
		return "ALUNO DE DOUTORAMENTO: INVESTIGACAO DE ESTUDO";
	}

}
