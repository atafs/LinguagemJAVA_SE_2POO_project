package control_2OO.Start_OO_week03.alunos.aluno_abstract;

import control_2OO.Start_OO_week03.alunos.doutoramento.AlunoDoutoramento;
import control_2OO.Start_OO_week03.alunos.licenciatura.AlunoLicenciatura;
import control_2OO.Start_OO_week03.alunos.mestrado.AlunoMestrado;

public class Main {

	public static void main(String[] args) {

		// INSTANTIATE
		Aluno aluno1 = new AlunoLicenciatura(1, "Americo");
		Aluno aluno2 = new AlunoMestrado(2, "Tomas");
		Aluno aluno3 = new AlunoDoutoramento(3, "Ana");

		// PRINT
		System.out.println();
		System.out.println("------------PRINT1------------");
		System.out.println(aluno1);
		System.out.println(aluno2);
		System.out.println(aluno3);

		System.out.println();
		System.out.println("------------PRINT2------------");
		System.out.println(aluno1.getTipo());
		System.out.println(aluno2.getTipo());
		System.out.println(aluno3.getTipo());

	}

}
