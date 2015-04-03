package control_2OO.Start_OO_week01e2.listOfArray_vProf;
import java.util.ArrayList;


public class Test {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		String matricula1 = "M1";
		String matricula2 = "M2";
		String matricula3 = "M3";
		
		String[] v = new String[10];
		v[0] = matricula1;
		v[1] = matricula2;
		v[2] = matricula3;
		
		int t = v.length; // Tamanho do vector
		
		String M5 = v[1];
		
		
		
		ArrayList<String> list = new ArrayList<String>();
		list.add(matricula1);
		list.add(matricula2);
		list.add(matricula3); // Adiciona a lista
		
		list.remove(matricula2); // Remover
		
		int t2 = list.size(); // Devolve o numero de elementos da lista.
		
		String M6 = list.get(1);
		
		for (int i = 0; i < list.size(); i++) {
			
		}
		
		for (String s : list) {
			
		}
		
	}
}
