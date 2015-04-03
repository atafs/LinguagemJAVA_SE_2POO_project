package control_1Logica;

import javax.swing.JOptionPane;

/** Apresentar conceitos de Variaveis
    @autor Americo Tomas	

*/

public class EntradaJOptionPane {
	
	public static void main (String[] args) {

	String nome = JOptionPane.showInputDialog("Qual o seu nome: ");
	JOptionPane.showMessageDialog(null, "BemVindo " + nome + "!!");	//recebe dois parametros. O segundo a mensagem a indicar ao utilizador

	JOptionPane.showConfirmDialog(null, "Está pronto para começar a Jogar?");
	JOptionPane.showMessageDialog(null, "Já só tem UMA criatura disponivel!!", "Exército de " + nome, 2);
	
	//em vez de imprimir no ecra
	//System.out.println(nome);

	}
}

/*
janela de dialogo

operador: +; -; *; /; ... 
operadores e operandos
denominar os operadores
utilizar operadores para conversão de dados
precedência de cada operador e tipos de precedencia de operadores



*/
