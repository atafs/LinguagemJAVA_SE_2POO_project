/** 
 * americoLIB concept 
 * @author Americo Tomas (atafs): 05/03/2015 
*/

package control_2OO.Start_OO_week04.tabularinterface;

public class Tester {

	public static void main(String[] args) {

		
		int[][] m = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		TabularStructure matrix = new Matrix(m);
		String text = TableToTextConverter.toText(matrix, " | ", true);
		System.out.println(text);
		
	}

}
