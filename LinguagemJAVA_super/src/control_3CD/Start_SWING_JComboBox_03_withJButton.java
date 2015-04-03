package control_3CD;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Start_SWING_JComboBox_03_withJButton extends JFrame {

	//ATTRIBUTES
	private String[] list = {"INNER CLASS ", "ANNONYMOUS CLASS "};
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private JComboBox comboBox = new JComboBox(list);
	
	private JButton button = new JButton("add BUTTONS");
	private JButton button1 = new JButton("new BUTTONS");
	
	public Start_SWING_JComboBox_03_withJButton() throws HeadlessException {

		super("A minha janela com Container!!!");
		
		// 1- INICIALIZO O CONTAINER
		Container c = getContentPane();
		c.setLayout(new BorderLayout());// borderLayout
		
		Container c1 = new JPanel();
		c1.setLayout(new FlowLayout());
		c1.setBackground(Color.YELLOW);
		c1.add(comboBox);
		c1.add(button);

		Container c2 = new JPanel();
		c2.setLayout(new GridLayout(5,1));
		c2.setBackground(Color.BLUE);
		
		c.add(BorderLayout.NORTH, c1);
		c.add(BorderLayout.CENTER, c2);
		
		//LISTENNERS
		//comboBox.addActionListener(new ListenerForButtons());
		
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("I am working!!!");	
				
			}
		});
	}

	//BASIC GUI
	public void setup() {
		pack();
		setSize(400,400);
		setLocation(400, 100);		
	}
	
	public void init() {
		/*final instruction*/
		setVisible(true);	
	}
	
	public static void main(String[] args) {
		Start_SWING_JComboBox_03_withJButton start = new Start_SWING_JComboBox_03_withJButton();
		start.setup();
		start.init();
		
	}
	
	class ListenerForButtons implements ActionListener{

		//attributes
		private JButton addButton = new JButton();
		@SuppressWarnings("unused")
		private JButton newButton = new JButton();
		private Start_SWING_JComboBox_03_withJButton window;

		//constructor
		public ListenerForButtons(JButton addButton, JButton newButton, Start_SWING_JComboBox_03_withJButton window) {
			this.window = window;
			this.addButton = addButton;
			this.newButton = newButton;
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {

			if(arg0.getSource() == addButton) {
				System.out.println("Carreguei no AddButton");
				window.addButton();
				}
			
//			else if(arg0.getSource() == window.getNewButton()) {
//				System.out.println("Carreguei no botao newButton!");
//				window.deleteButton(window.getNewButton());
//			}
			
		}
	}
	
	public void addButton() {
		button1 = new JButton("Button");
		button1.setBackground(Color.BLACK);
		button1.setForeground(Color.GREEN);
		add(button1);
		
		validate(); 	
		repaint();
		
	}
}

