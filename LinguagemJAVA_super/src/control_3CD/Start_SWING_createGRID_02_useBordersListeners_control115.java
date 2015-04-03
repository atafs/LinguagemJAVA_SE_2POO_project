package control_3CD;

//LINK READING/VIEWING
//http://docs.oracle.com/javase/tutorial/uiswing/components/border.html
//https://www.youtube.com/watch?v=Db3cC5iPrOM
//https://www.youtube.com/watch?v=N6L1sT6bCN8

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import pt.progJava.americoLib.control115.MouseListener_control115;



@SuppressWarnings("serial")
public class Start_SWING_createGRID_02_useBordersListeners_control115 extends JFrame{

	/*ATRIBUTES	*/
	//CHANGE INPUT DATA ---------------------------------------------
	private static final int SIZE_OF_WINDOWS_SIDE = 10;				//
	private int counter_changeBorderFactory = 3;					//
	//---------------------------------------------------------------
	//VARIABLES
	private static final int SIZE_OF_WINDOWS = SIZE_OF_WINDOWS_SIDE * SIZE_OF_WINDOWS_SIDE; //square = L x L;
	//PANELS
	JPanel mainWindows = new JPanel();
	JPanel square[] = new JPanel[SIZE_OF_WINDOWS];
	
	/*CONSTRUCTOR*/
	public Start_SWING_createGRID_02_useBordersListeners_control115() {
		super("GRID: Adapting and Resizeble");
		
		//INSTRUCTIONS
		setSize(600,600);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(100,100);
		setForeground(Color.GREEN);
		setBackground(Color.BLACK);
		
		//CREATE LAYOUT
		mainWindows.setLayout(new GridLayout(SIZE_OF_WINDOWS_SIDE,SIZE_OF_WINDOWS_SIDE));
		
		for (int i = 0; i < SIZE_OF_WINDOWS; i++) {
			square[i] = new JPanel();
			square[i].addMouseListener(new MouseListener_control115(i, square[i]));
			addBorderFactory(i);
			mainWindows.add(square[i]);
		}
		add(mainWindows);
		addMouseListener(new MouseListener_control115(mainWindows));
		
		//TESTS
		changeBorderFactory(2);
		
		//FINAL INSTRUCTION
		setVisible(true);
	}
	
	/*OTHER METHODS*/
	private JPanel addBorderFactory(int i) {
		square[i].setBorder(BorderFactory.createLineBorder(Color.BLUE));
		return square[i];
	}
	
	public void changeBorderFactory(int i) {
		
		// CHANGE COLOR
		switch (counter_changeBorderFactory) {
		case 0:
			square[i].setBorder(BorderFactory.createLineBorder(Color.BLUE));
			break;
		case 1:
			square[i].setBorder(BorderFactory.createLoweredBevelBorder());
			break;
		case 2:
			square[i].setBorder(BorderFactory.createRaisedBevelBorder());
			break;
		case 3:
			square[i].setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "" + i));
			break;
		case 4:
			ImageIcon icon = new ImageIcon(getClass().getResource("images/wave.png"));
			square[i].setBorder(BorderFactory.createMatteBorder(-1, -1, -1, -1, icon));
			break;
		case 5:
			square[i].setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));
			break;
		case 6:
			Border raisedbevel = BorderFactory.createRaisedBevelBorder();
			Border loweredbevel = BorderFactory.createLoweredBevelBorder();
			Border compound = BorderFactory.createCompoundBorder(raisedbevel, loweredbevel);
			Border redline = BorderFactory.createLineBorder(Color.red);
			//PUT TOGETHER
			square[i].setBorder(BorderFactory.createCompoundBorder(redline, compound));
			break;
		default:
			square[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
			break;
		}
	}
	
	public static void main(String[] args) {
		new Start_SWING_createGRID_02_useBordersListeners_control115();
	}
}
