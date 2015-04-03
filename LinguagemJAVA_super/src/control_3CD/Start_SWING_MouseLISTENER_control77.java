package control_3CD;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

import pt.progJava.americoLib.control77.MouseLISTENER;

@SuppressWarnings("serial")
public class Start_SWING_MouseLISTENER_control77 extends JComponent{
	
	private int count = 1;



	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		
		
		for (int i = 0; i < 2400; i+=20) {		
			g.drawLine(getWidth()/20 + i,0, getWidth()/20 + i, getHeight()); //horizontal
			g.drawLine(0, getHeight()/20 + i, getWidth(), getHeight()/20 + i);//vertical
			
			g.drawString("" + count, getWidth()/20 + i, getHeight()/20 + i);//texto ao centro
			count++;
	
		}
		
	}
	
	public static void main(String[] args) {
		
		Start_SWING_MouseLISTENER_control77 jCom = new Start_SWING_MouseLISTENER_control77();
		jCom.addMouseListener(new MouseLISTENER(jCom));
		
		
		JFrame frame = new JFrame();
		frame.add(jCom);
		frame.setSize(1000,522);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.repaint();
		frame.setVisible(true);
		
	}
	
	
}
