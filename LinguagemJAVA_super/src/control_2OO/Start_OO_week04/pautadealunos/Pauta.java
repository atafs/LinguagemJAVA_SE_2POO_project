/** 
 * americoLIB concept 
 * @author Americo Tomas (atafs): 05/03/2015 
 */

package control_2OO.Start_OO_week04.pautadealunos;

import java.util.ArrayList;

import control_2OO.Start_OO_week04.tabularinterface.TabularStructure;

public class Pauta implements TabularStructure {

	// ATTRIBUTES
	private ArrayList<Aluno> listAlunos;
	private static final int NUM_MAX_COLUMNS = 3;

	// CONSTRUCTOR
	public Pauta(ArrayList<Aluno> listAlunos) {
		this.listAlunos = listAlunos;
	}

	// GETTERS AND SETTERS
	public ArrayList<Aluno> getListAlunos() {
		return listAlunos;
	}

	// TOSTRING
	@Override
	public String toString() {
//		String text = "";
//		for (Aluno aluno : listAlunos) {
//			text += aluno.toString() + "\n";
//		}

		return super.toString();
	}

	/** Number of students in your list */
	@Override
	public int numberOfLines() {
		return listAlunos.size();
	}

	/** Number of columns with data from Students */
	@Override
	public int numberOfColumns() {
		return NUM_MAX_COLUMNS;
	}

	/** Get a specific Student from the list */
	@Override
	public String getElement(int line, int column) {
		Aluno aluno = listAlunos.get(line);
		String toReturn = "";

		switch (column) {
		case 0:
			toReturn = aluno.getNome() + "";
			break;
		case 1:
			toReturn = aluno.getNumero() + "";
			break;
		case 2:
			toReturn = aluno.getNota() + "";
			break;

		default:
			System.out.println("ERROR: Something went wrong. Possibily Not Enough columns added...");
			break;
		}

		return toReturn;
	}

}
