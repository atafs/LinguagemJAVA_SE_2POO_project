/** 
 * americoLIB concept 
 * @author Americo Tomas (atafs): 05/03/2015 
*/

package control_2OO.Start_OO_week04.jogodogalo;

import control_2OO.Start_OO_week04.tabularinterface.TableToTextConverter;
import control_2OO.Start_OO_week04.tabularinterface.TabularStructure;



public class Tester {

	public static void main(String[] args) {

		
		char[][] m = {{'X', 'X', 'X'}, {'X', 'X', 'X'}, {'X', 'X', 'X'}};
		TabularStructure jogoDoGalo = new JogoDoGalo(m);
		String text = TableToTextConverter.toText(jogoDoGalo, " | ", true);
		System.out.println(text);
		
		
	}

}
