package control_3CD;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Start_SWING_myButtonINNER01_Listenner extends JFrame implements
		ActionListener {

	// atributos
	private JButton botao;

	// construtor
	public Start_SWING_myButtonINNER01_Listenner() {

		// instanciar a janela, com tamanho e localizacao
		super("A minha janela com Heranca e Sentinela");

		// **************************** NOVO ******************

		botao = new JButton("Clique aqui...");// otao esta nos atributos
		getContentPane().add(botao);// colocar na Janela

		// REGISTAR SENTINELAS:
		botao.addActionListener(this);// escutar as accoes dele proprio

		// ****************************************************

		// instrucoes basicas
		setSize(300, 200);
		setLocation(100, 100);
		setResizable(false);// pode ou nao ser resizable

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// dar para fechar
		setVisible(true);// visivel
	}

	// main
	public static void main(String[] args) {
		new Start_SWING_myButtonINNER01_Listenner(); // instanciar a classe
	}

	// **************************** NOVO ******************

	@Override
	public void actionPerformed(ActionEvent e) {
		botao.setText("Assim esta muito Melhor!!!");
		System.out.println("Envio para a consola esta mensagem!!!");

	}

	// ****************************************************

}

