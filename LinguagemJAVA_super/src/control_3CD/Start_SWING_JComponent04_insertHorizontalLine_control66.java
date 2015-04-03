package control_3CD;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

import pt.progJava.americoLib.control66.Line_JComponent;

public class Start_SWING_JComponent04_insertHorizontalLine_control66 {
	private Line_JComponent canvas1 = new Line_JComponent();
	private JFrame frame = new JFrame("My paint");

	public Start_SWING_JComponent04_insertHorizontalLine_control66() {
		createGUI();
	}

	private void createGUI() {
		frame.add(canvas1);

		canvas1.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				canvas1.setDist(e.getPoint().x, e.getPoint().y);		
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				canvas1.setPoint(e.getPoint().x, e.getPoint().y);			
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		canvas1.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				canvas1.setDist(e.getPoint().x, e.getPoint().y);				
			}
		});
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void init() {
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new Start_SWING_JComponent04_insertHorizontalLine_control66().init();
	}
}
