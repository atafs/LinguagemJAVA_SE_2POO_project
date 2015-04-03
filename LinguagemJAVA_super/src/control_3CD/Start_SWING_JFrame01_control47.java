package control_3CD;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import pt.progJava.americoLib.control47.MyLabelJComponent;

public class Start_SWING_JFrame01_control47 {
	private JFrame frame;

	public Start_SWING_JFrame01_control47() {
		
		//JFrame
		frame = new JFrame("A minha primeira janela");
		frame.setSize(300, 200);
		frame.setLocation(100, 200);
		frame.add(new JButton("Done"), BorderLayout.WEST);
		
		//JTextField
		JTextField screen = new JTextField();
		frame.add(screen, BorderLayout.NORTH);
		
		frame.add(new MyLabelJComponent());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new Start_SWING_JFrame01_control47();
	}
}
