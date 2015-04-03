package control_3CD;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import pt.progJava.americoLib.control67.StudentAddress;

@SuppressWarnings("serial")
public class Start_SERVER_CLIENTE_09_client_studentAddressGAME_control67 extends JApplet {

	/* ******************* attributes **************************** */
	private JTextField jtfName = new JTextField(32);
	private JTextField jtfStreet = new JTextField(32);
	private JTextField jtfCity = new JTextField(20);
	private JTextField jtfState = new JTextField(2);
	private JTextField jtfZip = new JTextField(5);

	// button fo sending a student to the server
	private JButton jbtRegister = new JButton("REGISTER TO THE SERVER");

	// indicates if it runs as application
	private boolean isStandAlone = false;

	// hostName or IP
	String host = "localHost";
	
	//init(for the Gui)
	public void init() {
		
		//panel1 for holding labels Name, Street and City
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(3,1));
		p1.add(new JLabel("Name"));
		p1.add(new JLabel("Street"));
		p1.add(new JLabel("City"));
		
		//panel for holding State
		JPanel jpState = new JPanel();
		jpState.setLayout(new BorderLayout());
		jpState.add(new JLabel("State"), BorderLayout.WEST);
		jpState.add(jtfState, BorderLayout.CENTER);
		
		//panel for holding Zip
		JPanel jpZip = new JPanel();
		jpZip.setLayout(new BorderLayout());
		jpZip.add(new JLabel("Zip"), BorderLayout.WEST);
		jpZip.add(jtfZip, BorderLayout.CENTER);
		
		//panel2 for holding State and Zip
		JPanel p2 = new JPanel();
		p2.setLayout(new BorderLayout());
		p2.add(jpState, BorderLayout.WEST);
		p2.add(jpZip, BorderLayout.CENTER);
		
		//panel3 for holding jtfCity and p2
		JPanel p3 = new JPanel();
		p3.setLayout(new BorderLayout());
		p3.add(jtfCity, BorderLayout.CENTER);
		p3.add(p2, BorderLayout.EAST);
		
		//panel4 for holding jtfStreet and p3
		JPanel p4 = new JPanel();
		p4.setLayout(new GridLayout(3,1));
		p4.add(jtfName);
		p4.add(jtfStreet);
		p4.add(p3);
		
		//place p1 and p4 into studentPanel
		JPanel studentPanel = new JPanel(new BorderLayout());
		studentPanel.setBorder(new BevelBorder(BevelBorder.RAISED));
		studentPanel.add(p1, BorderLayout.WEST);
		studentPanel.add(p4, BorderLayout.CENTER);
		
		//add the student panel and the button to the applet
		add(studentPanel, BorderLayout.CENTER);
		add(jbtRegister, BorderLayout.SOUTH);
		
		//register listener
		jbtRegister.addActionListener(new ButtonListener());
		
		//find if IP address of the web server
		if(!isStandAlone) {
			host = getCodeBase().getHost();
		}
	}
	
	//listener (sending toServer an outputStream)
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try{
				
				//establish connetion with the server
				@SuppressWarnings("resource")
				Socket socket = new Socket(host, 8000);
				
				//create an outputStream to the server
				ObjectOutputStream toServer = new ObjectOutputStream(socket.getOutputStream());
				
				//get textField
				String name = jtfName.getText().trim();
				String street = jtfStreet.getText().trim();
				String city = jtfCity.getText().trim();
				String state = jtfState.getText().trim();
				String zip = jtfZip.getText().trim();
				
				//create a studentAddressObject to send to the server
				StudentAddress s = new StudentAddress(name, street, city, state, zip);
				toServer.writeObject(s);
				
			} catch(IOException ex) {
				System.err.println(ex);
			}
		}
	}
	
	//main
	public static void main(String[] args) {
		
		//create a frame
		JFrame frame = new JFrame("Register Student Client");
		
		//create an instance of the applet
		Start_SERVER_CLIENTE_09_client_studentAddressGAME_control67 applet = new Start_SERVER_CLIENTE_09_client_studentAddressGAME_control67();
		applet.isStandAlone = true;
		
		//get host
		if(args.length == 1) applet.host = args[0];
		
		//add the applet instance to the frame
		frame.add(applet, BorderLayout.CENTER);
		
		//invoke init and start
		applet.init();
		applet.start();
		
		//display the frame
		frame.pack();
		frame.setVisible(true);
	}
}
