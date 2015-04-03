package control_3CD;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import pt.progJava.americoLib.control48.ButtonsListener;



public class Start_SWING_JFrame02_control48 {
	
	/* atributos */
	private JFrame frame = new JFrame("Eventos");//criar a frame					
	private JButton criarBotoes1 = new JButton("Criar Botoes1");//criar os botoes
	private JButton criarBotoes2 = new JButton("Criar Botoes2");//criar os botoes
	private ButtonsListener listener = new ButtonsListener(criarBotoes1, criarBotoes2);
	
	/* procedimento: executar a janela (significa colocá-la visível) */
	public void execute() {
		frame.setVisible(true);
	}
	
	/* main */
	public static void main(String[] args) {
		Start_SWING_JFrame02_control48 b = new Start_SWING_JFrame02_control48();
		b.execute();
	}
	
	/* construtor */
	public Start_SWING_JFrame02_control48() {
		
		/* flow layout */
		frame.setLayout(new FlowLayout());
		
		frame.add(criarBotoes1);
		frame.add(criarBotoes2);
		
		//registar sentinelas
		criarBotoes1.addActionListener(listener);
		criarBotoes2.addActionListener(listener);

		frame.setSize(200,200);
		frame.setLocation(200,100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
