package control_3CD;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Start_SWING_guiBlank01 {

	// atributos
	private JFrame frame;

	// construtor
	public Start_SWING_guiBlank01() {

		// instanciar a janela, com tamanho e localizacao
		frame = new JFrame("A minha janela basica!!!");


		// instrucoes basicas
		JPanel content = new JPanel();	
		content.setBackground(Color.RED);
		frame.add(content);
		
		frame.setSize(400, 300);
		frame.setLocation(100, 100);
		frame.setBackground(Color.RED);
		frame.setResizable(false);// pode ou nao ser resizable

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// dar para fechar
		frame.setVisible(true);// visivel
	}

	// main
	public static void main(String[] args) {
		new Start_SWING_guiBlank01(); // instanciar a classe
	}
}
