package control_1Logica;

import javax.swing.JOptionPane;


/** Calcular o indice de massa corporal (IMC), 
	IMC = pesoEmQuilogramas / (alturaEmMetros * alturaEmMetros)
    
	@autor Americo Tomas	
*/

public class IMCTernario {
	
	//método main:	
	public static void main (String[] args) {
		
		//dar mais interactividade ao programa:	
	
		String peso = JOptionPane.showInputDialog("Qual o seu Peso em Kg: ");
		String altura = JOptionPane.showInputDialog("Qual a sua Altura em metros: ");

		//double pesoEmQuilogramas = 70;
		double pesoEmQuilogramas = Double.parseDouble(peso);
		double alturaEmMetros = Double.parseDouble(altura);
		double imc = pesoEmQuilogramas / (alturaEmMetros * alturaEmMetros);
		
		//operador ternario - avaliacao ? valor : valor
		String msg = (imc >= 20 && imc <= 25) ? "Tem o Peso Ideial" : "Esta fora do Peso Ideial";
		msg = "IMC = " + imc + "\n" + msg;

		JOptionPane.showMessageDialog(null, msg);

		System.out.println("IMC = " + imc);
		System.out.println(msg + "\n");

	}
}
