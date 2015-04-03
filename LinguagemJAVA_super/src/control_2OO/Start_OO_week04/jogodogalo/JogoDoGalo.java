/** 
 * americoLIB concept 
 * @author Americo Tomas (atafs): 05/03/2015 
 */

package control_2OO.Start_OO_week04.jogodogalo;

import control_2OO.Start_OO_week04.tabularinterface.TabularStructure;

public class JogoDoGalo implements TabularStructure {

	// ATTRIBUTES
	private char[][] matrix;

	// CONSTRUCTOR
	public JogoDoGalo(char[][] matrix) {
		this.matrix = matrix;
	}

	// INTERFACE METHODS
	@Override
	public int numberOfLines() {
		return matrix.length;

	}

	@Override
	public int numberOfColumns() {
		return matrix[0].length;
	}

	@Override
	public String getElement(int line, int column) {
		return matrix[line][column] + "";
	}
}
