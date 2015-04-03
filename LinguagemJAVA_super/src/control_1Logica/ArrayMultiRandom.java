package control_1Logica;

import java.util.Random;

/** @autor Americo Tomas
    	
*/

public class ArrayMultiRandom {

	public static void main(String[] args) {
	
		String[] uma = {"Ricardo", "Sandra"};
		System.out.println(uma[1]);
		System.out.println(uma.length);

		//1º [] Indica qual a matriz; 2º [] indica dentro da matriz, qual o indice
		String[][] duas = { {"Ricardo", "M", "DF"},{"Sandra", "F", "Maria"} };
		System.out.println(duas[1][0]);				//aceder ao Sandra
		System.out.println(duas[0][2]);				//aceder à Ms
		System.out.println("\n" + duas.length);			//total de Arrays	
		System.out.println(duas[0].length + "\n");		//na Array[0], o seu comprimento


		String[] faces = {"As","2","3","4","5","6","7","8","9","10","Valete","Dama","Rei",};
		String[] nipes = {"Espadas","Paus","Copas","ouros"};

		//escolher uma carta de forma aleatória, usando a class Random:
		Random r = new Random();
		
		String face = faces[r.nextInt(faces.length)];
		//int indiceFace = r.nextInt(faces.length);			//mais devagar 
		//String face = faces[indiceFace];

		String nipe = nipes[r.nextInt(nipes.length)];		
		//int indiceNipe = r.nextInt(nipes.length);
		//String nipe = nipes[indiceNipe];

		String carta = face + " de " + nipe;
		System.out.println(carta);

		//System.out.println(r.nextInt(10));
		//System.out.println(face[0] + " de " +  nipes[0]);		//escolhodo por mim (não é tão interessante)
		
	}
}

