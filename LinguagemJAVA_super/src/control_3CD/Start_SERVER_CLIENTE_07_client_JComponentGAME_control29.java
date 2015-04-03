package control_3CD;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import pt.progJava.americoLib.control29.DataPackage;


@SuppressWarnings("serial")
public class Start_SERVER_CLIENTE_07_client_JComponentGAME_control29 extends JComponent{
	
	/*attributes*/
	private static JFrame frame = new JFrame();
	
	public int x = 0;
	public int y = 0;
	
	public String username = "Americo Tomas";
	
	public ArrayList<DataPackage> others = new ArrayList<DataPackage>();
	
	public String ip;
	
	public static Socket socket;
	public static int port = 2406;
	public static String io = "";
	
	public static String expectedResponse = "Your name is taken";
	
	public int state = 0;
	public boolean connected = true;
	
	Runnable send = new Runnable() {
		
		@Override
		public void run() {
			ObjectOutputStream oos;
			
			while(connected) {
				if(socket != null) {
					try {
						DataPackage dp = new DataPackage();
						dp.x = x;
						dp.y = y;
						dp.username = username;
						
						oos = new ObjectOutputStream(socket.getOutputStream());
						oos.writeObject(state);
						
						oos = new ObjectOutputStream(socket.getOutputStream());
						oos.writeObject(dp);
						
						if(state == 1) {//client disconnected
							connected = false;
							socket = null;
							
							JOptionPane.showMessageDialog(null, "Cliente DISCONNECTED", "Info", JOptionPane.INFORMATION_MESSAGE);
						}
						
						;
					} catch (Exception e) {
					}
				} else {
					break;
				}
			}
			
			
		}
	};
	
	Runnable receive = new Runnable() {
		
		@Override
		public void run() {
			
			ObjectInputStream ois;
			while(connected) {
				try {
					ois = new ObjectInputStream(socket.getInputStream());
					int receive_state = (Integer) ois.readObject();
					
					if(receive_state == 1) {//kicked, disconnected by server

						connected = false;
						socket = null;
						
						JOptionPane.showMessageDialog(null, "Disconnected by SERVER", "Info", JOptionPane.INFORMATION_MESSAGE);
						System.exit(0);
					}
					else if(receive_state == 2) {//went down the server
						connected = false;
						socket = null;
						
						JOptionPane.showMessageDialog(null, "Disconnected by SERVER", "Info", JOptionPane.INFORMATION_MESSAGE);
						System.exit(0);
					}
					
					ois = new ObjectInputStream(socket.getInputStream());
					@SuppressWarnings("unchecked")
					ArrayList<DataPackage> list_data = (ArrayList<DataPackage>) ois.readObject();
					
					for (int i = 0; i < list_data.size(); i++) {
						DataPackage dp = list_data.get(i);
						
						if(list_data.size() != others.size()) {
							if(list_data.size() > others.size()) {
								others.add(dp);
							} 
							if (list_data.size() < others.size()){
								others.remove(0);
							}
							
						} else {
							others.set(i, dp);
						}
					}
					
				} catch (Exception e) {
				}
			}
		}
	};
	
	/*constructor*/
	public Start_SERVER_CLIENTE_07_client_JComponentGAME_control29() {
		
		this.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent arg0) {
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				x = e.getX();
				y = e.getY();
			}
		});
		
		try {
			String local;
			
			try {
				local = InetAddress.getLocalHost().getHostAddress() + ":" + port;
				
			} catch (UnknownHostException e) {
				local = "NETWORK ERROR";
			}
			
			ip = (String) JOptionPane.showInputDialog(null, "IP: ", "Info", JOptionPane.INFORMATION_MESSAGE, null, null, local);
			port = Integer.parseInt(ip.substring(ip.indexOf(":") + 1));
			ip = ip.substring(0, ip.indexOf(":"));
			
			socket = new Socket(ip, port);
			
			String set_username = System.getProperty("user.name");
			set_username = (String) JOptionPane.showInputDialog(null, "Username: ", "Info", JOptionPane.INFORMATION_MESSAGE, null, null, set_username);
			username = set_username;
			
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(username);
			
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			String response = (String) ois.readObject();
			
			JOptionPane.showMessageDialog(null, response, "MESSAGE", JOptionPane.INFORMATION_MESSAGE);
			
			if(response.equals(expectedResponse)) {
				System.exit(0);
			}
			
			new Thread(send).start();
			new Thread(receive).start();
			
			
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage(), "Alert", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
	}
	
	/*main*/
	public static void main(String[] args) {
		
		setupFrame();
			
	}
	
	public void paint(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		
		/*backGround color*/
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, getWidth(), getHeight());
		

		for (int i = 0; i < others.size(); i++) {
			try {
				DataPackage dp = others.get(i);
				
				if(!dp.username.toLowerCase().equals(username.toLowerCase())) {
					/*oval color and dimensions*/
					g2d.setColor(Color.RED);
					g2d.fillOval((int)dp.x-50, (int)dp.y-50, 100, 100);
					
					/*print name of user*/
					g2d.setColor(Color.BLACK);
					g2d.drawString(dp.username, dp.x-50, dp.y-70);
					
				}
				
			} catch (Exception e) {
			}
		}
		
		/*oval color and dimensions*/
		g2d.setColor(Color.BLUE);
		g2d.fillOval(x-50, y-50, 100, 100);
		
		/*print name of user*/
		g2d.setColor(Color.CYAN);
		g2d.drawString(username, x-50, y-70);
		
		try {
			Thread.sleep(1);
		} catch (Exception e) {
			
		}
		
		repaint();
		
	}
	
	/*method that defines the window*/
	public static void setupFrame() {
		
		frame.setTitle("CLIENT");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(new Start_SERVER_CLIENTE_07_client_JComponentGAME_control29());
		
		frame.pack();
		frame.setSize(650,500);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
