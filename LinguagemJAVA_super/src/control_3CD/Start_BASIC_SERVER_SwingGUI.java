package control_3CD;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.net.InetAddress;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Start_BASIC_SERVER_SwingGUI {

	/* attributes */
	public static int port = 2406;
	public static String ip = "";

	public static JFrame frame;
	public static JPanel content;
	public static JPanel panel1;
	public static JPanel panel2;
	public static JPanel panel3;

	public static JButton btn_disconnect;
	@SuppressWarnings("rawtypes")
	public static JList list_client;
	@SuppressWarnings("rawtypes")
	public static DefaultListModel list_clients_model;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
//		/*if using windows: windowsGUI look*/
//		try {
//			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());			
//		} catch (Exception e) {
//		}
		try {
			ip = InetAddress.getLocalHost().getHostAddress() + ":" + port;

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage(),
					", ALERT", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}

		btn_disconnect = new JButton();
		btn_disconnect.setText("Disconnect");
		btn_disconnect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int selected = list_client.getSelectedIndex();

				if (selected != -1) {
					// ...
				}
			}
		});

		list_clients_model = new DefaultListModel<>();
		list_client = new JList<>(list_clients_model);
		list_client.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {

				if (e.getValueIsAdjusting()) {
					System.out.println(list_client.getSelectedIndex());
				}
			}
		});

		frame = new JFrame();
		frame.setTitle("SERVER - " + ip);
		frame.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent arg0) {

			}

			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}

			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		
		panel1 = new JPanel();
		panel1.setLayout(new GridLayout(1, 1, 1, 1));
		panel1.add(btn_disconnect);
		
		panel2 = new JPanel();
		panel2.add(new JLabel(ip));
		
		panel3 = new JPanel();
		panel3.setLayout(new BorderLayout(1,1));
		panel3.add(panel1, BorderLayout.NORTH);
		panel3.add(new JScrollPane(list_client), BorderLayout.CENTER);
		panel3.add(panel2, BorderLayout.SOUTH);
		
		content = new JPanel();
		content.setLayout(new GridLayout(1,1,1,1));
		content.add(panel3);
		
		content.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		
		frame.setContentPane(content);
		frame.pack();
		frame.setSize(350,400);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

}
