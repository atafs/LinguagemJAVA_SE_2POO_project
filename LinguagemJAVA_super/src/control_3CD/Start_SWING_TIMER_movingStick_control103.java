package control_3CD;

import java.awt.Color;

import javax.swing.JFrame;

import pt.progJava.americoLib.control103.LineGui;


//import pt.progJava.americoLib.control98.view.MouseLISTENER;

public class Start_SWING_TIMER_movingStick_control103 {

	//MAIN
	public static void main(String[] args) {
		
		LineGui line = new LineGui("SMOKE");
		JFrame frame = new JFrame();
		frame.add(line);
	
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
