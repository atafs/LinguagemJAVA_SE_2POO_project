package control_3CD;

import java.awt.Color;

import javax.swing.JFrame;

import pt.progJava.americoLib.control104.LineGui;
import pt.progJava.americoLib.control104.MouseLISTENER;


public class Start_SWING_RACE04_SNAKE_01_control104 {

	//MAIN
	public static void main(String[] args) {
		
		LineGui line1 = new LineGui("SMOKE", 30, 55, 120, 15);
		line1.addMouseListener(new MouseLISTENER(line1));

		JFrame frame = new JFrame();
		frame.add(line1);

		//BASIC GUI
		frame.setBackground(Color.CYAN);
		frame.setTitle("AmericoLIB SNACK GAME");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(670,400);
		frame.setResizable(false);
		frame.setLocation(30, 30);
		frame.setVisible(true);
		
	}
}
