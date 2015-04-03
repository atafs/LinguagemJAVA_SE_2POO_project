package control_3CD;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class Start_SWING_JComboBox_04_withJButton extends JFrame {

	// ATTRIBUTES
	private String[] list = { "INNER CLASS ", "ANNONYMOUS CLASS " };
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private JComboBox comboBox = new JComboBox(list);
	private JButton buttonMain = new JButton("MAIN BUTTONS");
	private ListenerForButtons listener = new ListenerForButtons();

	public Start_SWING_JComboBox_04_withJButton() throws HeadlessException {

		super("A minha janela com Container!!!");

		// LISTENNERS
		buttonMain.addActionListener(listener);
		buttonMain.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				if (comboBox.getSelectedIndex() == 1) {
					JButton buttonSecondary = new JButton("I have an ANONYMOUS Class");
					buttonSecondary.setBackground(Color.WHITE);
					buttonSecondary.setForeground(Color.RED);
					add(buttonSecondary);
					validate(); // lay out its sub-components after each adding
					repaint();

					buttonSecondary.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent arg0) {
							JOptionPane.showMessageDialog(null, "I am an ANNONYMOUS Class window");
						}
					});
				}
			}
		});
	}

	// BASIC GUI
	public void setup() {
		
		// 1- INICIALIZO O CONTAINER
		Container c = getContentPane();
		c.setLayout(new FlowLayout());// borderLayout
		c.setBackground(Color.GREEN);
		c.add(BorderLayout.SOUTH, comboBox);
		c.add(BorderLayout.NORTH, buttonMain);
		
		pack();
		setSize(400, 400);
		setLocation(400, 100);
	}

	public void init() {
		/* final instruction */
		setVisible(true);
	}

	public static void main(String[] args) {
		Start_SWING_JComboBox_04_withJButton start = new Start_SWING_JComboBox_04_withJButton();
		start.setup();
		start.init();

	}

	class ListenerForButtons implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (comboBox.getSelectedIndex() == 0) {
				JButton buttonSecondary = new JButton("I have an INNER Class");
				buttonSecondary.setBackground(Color.BLACK);
				buttonSecondary.setForeground(Color.GREEN);
				add(buttonSecondary);
				validate(); // lay out its sub-components after each adding
				repaint();

				buttonSecondary.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						JOptionPane.showMessageDialog(null,
								"I am an INNER Class window");
					}
				});
			}

		}

	}

}
