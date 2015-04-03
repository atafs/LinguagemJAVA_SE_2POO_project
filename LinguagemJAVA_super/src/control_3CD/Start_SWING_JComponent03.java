package control_3CD;

import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Start_SWING_JComponent03 extends JComponent {

	// definir algo
	protected void paintComponent(Graphics g) {
		super.paintComponents(g);
		g.drawString("Ola a Todos", getWidth() / 2, getHeight() / 2);
		g.drawLine(0, 0, getWidth(), getHeight());
	}

	public void repaint() {
	}

	public void revalidate() {
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.add(new Start_SWING_JComponent03());
		frame.setSize(200, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	/*
	 * For more information: Swing
	 * http://docs.oracle.com/javase/tutorial/uiswing/index.html
	 */

}
