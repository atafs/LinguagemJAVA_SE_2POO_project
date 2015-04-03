package control_3CD;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Start_SWING_RACE01_horse_control53 extends JFrame implements ActionListener {

	//atributos 
	JButton horse1 = new JButton("1");
	JButton horse2 = new JButton("2");
	JButton horse3 = new JButton("3");
	JTextField result1 = new JTextField("text1...");
	JTextField result2 = new JTextField("text2...");
	JTextField result3 = new JTextField("text3...");
	
	
	//construtor
	public Start_SWING_RACE01_horse_control53() throws HeadlessException {
		super("Race");
		
		/* 4 - criar o meu FlowLayout */
		Container c = getContentPane();
		
		/* 5 - criar o meu FlowLayout */
		FlowLayout flow = new FlowLayout();
		c.setLayout(flow);
		
		/* 6 - adicionar botoes */
		c.add(horse1);
		c.add(horse2);
		c.add(horse3);
		c.add(result1);
		c.add(result2);
		c.add(result3);
	
	
		/* definicoes base */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 200);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Start_SWING_RACE01_horse_control53();
	}
	
	
	

	
	
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	/* criar outra class: trata dos eventos do botao ok */
	class HorseListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			/* imprime uma String com os atributos */
		
		}
	}

	/* criar outra class: trata dos eventos do botao cancel */
	class resultListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			/* definir novo texto em branco */
		
		}

	}
	

	

}
