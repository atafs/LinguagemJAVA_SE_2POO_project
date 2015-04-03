/** 
 * americoLIB concept 
 * @author Americo Tomas (atafs): 05/03/2015 
 */

package control_2OO.Start_OO_week04.pautadealunos;

import java.util.ArrayList;

import control_2OO.Start_OO_week04.tabularinterface.TableToTextConverter;
import control_2OO.Start_OO_week04.tabularinterface.TabularStructure;

public class Main {

	public static void main(String[] args) {

		// INSTANTIATE
		Aluno aluno1 = new Aluno("Americo", 54149, 10);
		Aluno aluno2 = new Aluno("Tomas", 54148, 12);
		Aluno aluno3 = new Aluno("Agrela", 54147, 16);
		Aluno aluno4 = new Aluno("Fernandes", 54146, 19);

		ArrayList<Aluno> listAluno = new ArrayList<>();
		listAluno.add(aluno1);
		listAluno.add(aluno2);
		listAluno.add(aluno3);
		listAluno.add(aluno4);

		Pauta pauta = new Pauta(listAluno);

		// PRINTS
		System.out.println("------------PAUTA0-----------------\n");
		System.out.println(listAluno.size());

		System.out.println("------------PAUTA1-----------------\n");
		System.out.println(pauta.toString());

		System.out.println("------------PAUTA2-----------------\n");

		TabularStructure pauta1 = new Pauta(listAluno);
		String text = TableToTextConverter.toText(pauta1, " | ", true);
		System.out.println(text);

	}

}
