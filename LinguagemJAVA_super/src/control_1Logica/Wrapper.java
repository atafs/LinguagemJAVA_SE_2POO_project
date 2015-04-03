package control_1Logica;


/** Apresentar conceitos de Variaveis
    @autor Americo Tomas	

*/

public class Wrapper {
	
	public static void main (String[] args) {
		
		
		
		//char sexo = '甲';

		//criar um objecto, usamos a palavra chave new... 
		//int idade = 33; 		
		//Integer idade = new Integer(31);

		//double preco = 54.12;
		//Double preco = new Double ("12.45");
		
		//faz a conversao (cast) destes valores para double, int, byte, etc...		
		//double d = preco.doubleValue();
		//int i = preco.intValue();
		//byte b = preco.byteValue();

		//boolean casado = true;
		//Boolean casado = new Boolean("true");

		//realizar uma conversao static sem criar um novo objecto
		//util para o situacoes em que o utilizador escreve uma String, e eu a quero converter num int, etc...
		//double b1 = Double.parseDouble("123.45");		
		//int i1 = Integer.parseInt("123");
		//float f1 = Float.parseFloat("3.14F");

		int i2 = Integer.valueOf("0000010", 2);

		System.out.println(i2);
	}

}
		
/*
Classes Wrapper: 
Integer, Byte, Double, Void, Boolean




*/
