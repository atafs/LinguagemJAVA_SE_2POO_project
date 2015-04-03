package control_3CD;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Start_SERVER_CLIENTE_08_client_multiThreadGAME_calcRadius extends JFrame {
	
	//attributes for Gui
	private JTextField jtf = new JTextField();
	private JTextArea jta = new JTextArea();
	
	//IO streams
	private DataOutputStream toServer;
	private DataInputStream fromServer;
	
	//main
	public static void main(String[] args) {
		new Start_SERVER_CLIENTE_08_client_multiThreadGAME_calcRadius();
	}
	
	//constructor
	public Start_SERVER_CLIENTE_08_client_multiThreadGAME_calcRadius() {
			
		//panel to hold label, textField and add to main container
		guiWindow();
		
		//listener
		jtf.addActionListener(new TextFieldListener());
		
		//last instructions for Gui
		guiWindowFinalInstructions();
		
		try {
			//create socket to connect to server
			@SuppressWarnings("resource")
			Socket socket = new Socket("localHost", 8000);
			
			//create an input/output stream to receive/send data from/to server
			fromServer = new DataInputStream(socket.getInputStream());
			toServer = new DataOutputStream(socket.getOutputStream());
				
		} catch(IOException ex) {
			jta.append(ex.toString() + '\n');
		}
	}

	//panel to hold label, textField and add to main container
	private void guiWindow() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(new JLabel("Enter Radius: "), BorderLayout.WEST);
		panel.add(jtf, BorderLayout.CENTER);
		jtf.setHorizontalAlignment(JTextField.RIGHT);
		
		setLayout(new BorderLayout());
		add(panel, BorderLayout.NORTH);
		add(new JScrollPane(jta), BorderLayout.CENTER);
	}
	
	//last instructions for Gui
	private void guiWindowFinalInstructions() {
		setTitle("Client");
		setSize(380,200);
		setLocation(100, 100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	//innerClass: listener
	private class TextFieldListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				
				//get the radius
				double radius = Double.parseDouble(jtf.getText().trim());
				
				//send the radius to server
				toServer.writeDouble(radius);
				toServer.flush();
				
				//get area from server
				double area = fromServer.readDouble();
				
				//display to the text area
				jta.append("Radius is " + radius + "\n");
				jta.append("Area received from the server is " + area + '\n');
				
			} catch(IOException ex) {
				System.err.println(ex);
			}
		}
	}
}
