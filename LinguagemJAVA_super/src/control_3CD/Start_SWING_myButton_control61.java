package control_3CD;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import pt.progJava.americoLib.control61.Sentinela;

public class Start_SWING_myButton_control61 {

	// atributos
	private JFrame frame = new JFrame("Eventos");
	private JButton okButton = new JButton("OK");
	private JButton cancelButton = new JButton("Cancel");
	private Sentinela listener = new Sentinela(
			okButton, cancelButton);

	// execute()
	public void execute() {
		frame.setSize(200, 200);
		frame.setLocation(200, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setVisible(true);
	}

	// main
	public static void main(String[] args) {
		Start_SWING_myButton_control61 b = new Start_SWING_myButton_control61();
		b.execute();
	}

	// construtor
	public Start_SWING_myButton_control61() {

		frame.setLayout(new FlowLayout());// DEFINI LAYOUT DA JANELA
		frame.add(okButton);// ADICIONAR BOTOES
		frame.add(cancelButton);

		// REGISTAR SENTINELAS:
		okButton.addActionListener(listener);
		cancelButton.addActionListener(listener);
	}

}
