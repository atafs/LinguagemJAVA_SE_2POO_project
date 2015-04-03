package control_2OO.Start_OO_week03.alunos.mestrado;

import control_2OO.Start_OO_week03.alunos.aluno_abstract.Aluno;

public class AlunoMestrado extends Aluno{

	public AlunoMestrado(int numero, String nome) {
		super(numero, nome);
	}

	@Override
	public String getTipo() {
		return "ALUNO DE MESTRADO: PROJECTOS DE ESTUDO";
	}

}
