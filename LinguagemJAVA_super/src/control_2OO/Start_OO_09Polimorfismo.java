package control_2OO;

import control.Calculadora;
import interfaceCalculadora.Calculador;
import interfaceCalculadora.Dividir;
import interfaceCalculadora.Multiplicar;
import interfaceCalculadora.Somar;
import interfaceCalculadora.Subtracao;

public class Start_OO_09Polimorfismo {

	public static void main(String[] args) {

		Calculadora c0 = new Calculadora();
		System.out.println("\n "+c0.calcular(2.3, 6.1, '*'));
		
		Calculador c1 = new Somar();
		Calculador c2 = new Subtracao();
		Calculador c3 = new Multiplicar();
		Calculador c4 = new Dividir();
		
		System.out.println("\n "+c1.calcular(2.2, 3.3));
		System.out.println("\n "+c2.calcular(2.2, 3.3));
		System.out.println("\n "+c3.calcular(2.2, 3.3));
		System.out.println("\n "+c4.calcular(2.2, 3.3));
	}

}
