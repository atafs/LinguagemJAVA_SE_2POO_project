package control_3CD;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Start_BASIC_SWING_2JButtonWithListener extends JFrame implements ActionListener {

	//atributos 
	JButton botao1 = new JButton("Botao1");
	JButton botao2 = new JButton("Botao2");
	
	// construtor
	public Start_BASIC_SWING_2JButtonWithListener() {

		// instanciar a janela, com tamanho e localizacao
		super("PrintOnConsole_GUI");

		// *******************************************************************

		// 1- INICIALIZO O CONTAINER
		Container c = getContentPane();// instrucao para a criacao do container
		c.setBackground(Color.YELLOW);

		// 2- ESCOLHO QUAL A DISPOSICAO GERAL DO CONTAINER (grid,...)
		FlowLayout border = new FlowLayout();
		c.setLayout(border);
		c.add(botao1);
		c.add(botao2);
		
		// REGISTAR SENTINELAS:
		botao1.addActionListener(this);
		botao2.addActionListener(this);

		// *******************************************************************

	}

	// execute
	public void execute() {

		// instrucoes basicas
		setSize(300, 200);
		setLocation(500, 100);
		setResizable(false);// pode ou nao ser resizable

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// poder fechar
		setVisible(true);// visivel
	}

	// main
	public static void main(String[] args) {
		Start_BASIC_SWING_2JButtonWithListener janela = new Start_BASIC_SWING_2JButtonWithListener();
		janela.execute();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//teste
		botao1.setText("Assim esta muito Melhor!!!");
		System.out.println("Envio para a consola esta mensagem!!!");
						
		
	}

}
