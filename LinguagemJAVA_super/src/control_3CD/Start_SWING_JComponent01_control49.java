package control_3CD;

import javax.swing.JFrame;

import pt.progJava.americoLib.control49.CriarComponente;

public class Start_SWING_JComponent01_control49 {

	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		frame.add(new CriarComponente());
		
		
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

}
