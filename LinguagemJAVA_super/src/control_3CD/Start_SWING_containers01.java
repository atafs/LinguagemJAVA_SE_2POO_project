package control_3CD;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Start_SWING_containers01 extends JFrame {

	// atributos
	@SuppressWarnings("unused")
	private JFrame frame;

	// construtor
	public Start_SWING_containers01() {

		// instanciar a janela, com tamanho e localizacao
		super("A minha janela com Container!!!");

		// 1 e 2- INICIALIZO O CONTAINER PRINCIPAL E SEU TIPO DE LAYOUT
		Container c = getContentPane();
		c.setLayout(new BorderLayout());// borderLayout

		// ***************************** NOVO **********************************

		// 3- INICIALIZO CONTAINER SECUNDARIO E SEU TIPO
		Container c1 = new JPanel();
		c1.setLayout(new GridLayout(5, 1));// gridLayout
		c1.setBackground(Color.RED);
		c1.add(new JButton("Americo"));
		c1.add(new JButton("Tomas"));
		c1.add(new JButton("de"));
		c1.add(new JButton("Agrela"));

		// 3- INICIALIZO CONTAINER SECUNDARIO E SEU TIPO
		Container c2 = new JPanel();
		c2.setLayout(new GridLayout(5, 1));// gridLayout
		c2.setBackground(Color.BLUE);
		c2.add(new JButton("Ana"));
		c2.add(new JButton("Margarida"));
		c2.add(new JButton("Marques"));
		c2.add(new JButton("Batalha"));

		// 4- DEFINO EM QUE POSICAO DO CONTAINER PRINCIPAL COLOCAR SECUNDARIO
		c.add(BorderLayout.EAST, c1);
		c.add(BorderLayout.WEST, c2);
		c.add(BorderLayout.CENTER, new JButton("button"));

		// *********************************************************************

		// instrucoes basicas
		setSize(400, 200);
		setLocation(100, 100);
		setResizable(true);// pode ou nao ser resizable

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// dar para fechar
		setVisible(true);// visivel
	}

	// main
	public static void main(String[] args) {
		new Start_SWING_containers01(); // instanciar a classe
	}
}

