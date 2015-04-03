package control_3CD;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Start_SWING_layoutFlowLayout extends JFrame {

	// atributos
	@SuppressWarnings("unused")
	private JFrame frame;

	// construtor
	public Start_SWING_layoutFlowLayout() {

		// instanciar a janela, com tamanho e localizacao
		super("A minha janela com Container!!!");

		// ***************************** NOVO **********************************

		// 1- INICIALIZO O CONTAINER
		Container c = getContentPane();// instrucao para a criacao do container
		c.setBackground(Color.YELLOW);

		// 2- ESCOLHO QUAL A DISPOSICAO GERAL DO CONTAINER (grid,...)
		FlowLayout border = new FlowLayout();
		c.setLayout(border);

		// 3- COLOCO BOTOES E LOCALIZACOES DOS MESMOS
		c.add(new JButton("Americo"));
		c.add(new JButton("Tomas"));
		c.add(new JButton("de"));
		c.add(new JButton("Agrela"));
		c.add(new JButton("Fernandes"));

		// *********************************************************************

		// instrucoes basicas
		setSize(400, 200);
		setLocation(100, 100);
		setResizable(false);// pode ou nao ser resizable

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// dar para fechar
		setVisible(true);// visivel
	}

	// main
	public static void main(String[] args) {
		new Start_SWING_layoutFlowLayout(); // instanciar a classe
	}

}
