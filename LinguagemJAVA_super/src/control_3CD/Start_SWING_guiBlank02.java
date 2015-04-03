package control_3CD;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Start_SWING_guiBlank02 extends JFrame {

	// construtor
	public Start_SWING_guiBlank02() {

		// instanciar a janela, com tamanho e localizacao
		super("A minha janela com Heranca");

		// *******************************************************************

		// ...acrescentar coisas a janela

		// *******************************************************************

		// instrucoes basicas
		JPanel content = new JPanel();	
		content.setBackground(Color.GREEN);
		this.add(content);
		
		setSize(400, 300);
		setLocation(100, 100);
		setResizable(false);// pode ou nao ser resizable
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// dar para fechar
		setVisible(true);// visivel
	}

	// main
	public static void main(String[] args) {
		new Start_SWING_guiBlank02(); // instanciar a classe
	}
}
