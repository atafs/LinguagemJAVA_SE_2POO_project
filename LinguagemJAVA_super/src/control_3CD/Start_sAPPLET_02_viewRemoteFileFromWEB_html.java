package control_3CD;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Start_sAPPLET_02_viewRemoteFileFromWEB_html extends Applet {
	
	/* attributes */
	// button to view the file
	private JButton jbtView = new JButton("View");
	
	//text field to receive file name
	private JTextField jtfURL = new JTextField(12);

	//text area to store file
	private JTextArea jtaFile = new JTextArea();
	
	// label to display status
	private JLabel jlblStatus = new JLabel();
	
	/* initialize the applet */
	public void init() {
		
		//create panel to hold label
		JPanel p1 = new JPanel();
		p1.setLayout(new BorderLayout());
		p1.add(new JLabel("FileName"), BorderLayout.WEST);
		p1.add(jtfURL, BorderLayout.CENTER);
		p1.add(jbtView, BorderLayout.EAST);
		
		//place text area and panel p1 to the applet
		setLayout(new BorderLayout());
		add(new JScrollPane(jtaFile), BorderLayout.CENTER);
		add(p1, BorderLayout.NORTH);
		add(jlblStatus, BorderLayout.SOUTH);
		
		//register listener to handle the view button
		jbtView.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				showFile();
			}
		});
	}
	
	//
	private void showFile() {
		//use scanner for the next input (localVariables)
		Scanner input = null;
		URL url = null;
		
		try{
			//obtain URL from the text field
			url = new URL(jtfURL.getText().trim());
			
			//create a scanner for inputStream
			input = new Scanner(url.openStream());
			
			//read a line and append the line to the next area
			while(input.hasNext()) {
				jtaFile.append(input.nextLine() + "\n");
			}
			jlblStatus.setText("File Loaded Successfully");
			
		} catch(MalformedURLException ex) {
			jlblStatus.setText("URL " + url + " not found.");
			
		} catch(IOException ex) {
			jlblStatus.setText(ex.getMessage());
			
		} finally {
			if(input != null) input.close();
		}
	}
}
