package control_2OO.Start_OO_week03.alunos.licenciatura;

import control_2OO.Start_OO_week03.alunos.aluno_abstract.Aluno;

public class AlunoLicenciatura extends Aluno {

	public AlunoLicenciatura(int numero, String nome) {
		super(numero, nome);
	}

	@Override
	public String getTipo() {
		return "ALUNO DE LICENCIATURA: BASE DE ESTUDO";
	}

}
