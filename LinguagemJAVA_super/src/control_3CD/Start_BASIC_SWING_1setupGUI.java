package control_3CD;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Start_BASIC_SWING_1setupGUI extends JFrame{

	//ATTRIBUTES
	//...
	
	//CONSTRUCTOR
	public Start_BASIC_SWING_1setupGUI() {
		super("MY GUI BASIC WINDOW ;-)");
	}
	
	//MAIN
	public static void main(String[] args) {
		
		Start_BASIC_SWING_1setupGUI addSetup = new Start_BASIC_SWING_1setupGUI();
		addSetup.setup();		
	}
	
	//BASIC GUI
	public void setup() {
		
		JPanel content = new JPanel();	
		content.setBackground(Color.CYAN);
		setContentPane(content);
		pack();
		setSize(400,400);
		setLocation(400, 100);
		
		//OTHER INSTRUCTIONS
		//setLocationRelativeTo(null);
		
		/*final instruction*/
		setVisible(true);
		
	}
}
