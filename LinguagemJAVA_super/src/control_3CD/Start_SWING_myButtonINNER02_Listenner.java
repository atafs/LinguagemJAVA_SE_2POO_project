package control_3CD;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Start_SWING_myButtonINNER02_Listenner extends JFrame {

	// atributos
	JButton botao;

	// construtor
	public Start_SWING_myButtonINNER02_Listenner() {
		super("nestedClasses");

		botao = new JButton("OK");
		botao.addActionListener(new ListenerAninhado());

		getContentPane().add(botao);
		
		// instrucoes basicas
		setSize(300, 200);
		setLocation(100, 100);
		setResizable(false);// pode ou nao ser resizable

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// dar para fechar
		setVisible(true);// visivel
	}

	//INNER CLASS
	public class ListenerAninhado implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("NestedClass executa: " + botao.getText());
		}
	}
	

	// main
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		Start_SWING_myButtonINNER02_Listenner janela = new Start_SWING_myButtonINNER02_Listenner(); // instanciar a classe
	}

}
