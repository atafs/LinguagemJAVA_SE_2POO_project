package control_3CD;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

@SuppressWarnings("serial")
public class Start_sAPPLET_03_textEditor_control68 extends JApplet{
	
	/* attributes */
	//declare and create imageIcons
	private ImageIcon openImageIcon = new ImageIcon(getClass().getResource("/pt/progJava/americoLib/control68/images/open.png"));
	private ImageIcon saveImageIcon = new ImageIcon(getClass().getResource("/pt/progJava/americoLib/control68/images/save.png"));
	private ImageIcon clearImageIcon = new ImageIcon(getClass().getResource("/pt/progJava/americoLib/control68/images/clear.png"));
	private ImageIcon exitImageIcon = new ImageIcon(getClass().getResource("/pt/progJava/americoLib/control68/images/exit.png"));
	
	//create menu itens
	private JMenuItem jmiOpen = new JMenuItem("Open", openImageIcon);
	private JMenuItem jmiSave = new JMenuItem("Save", saveImageIcon);
	private JMenuItem jmiClear = new JMenuItem("Clear", clearImageIcon);
	private JMenuItem jmiExit = new JMenuItem("Exit", exitImageIcon);
	private JMenuItem jmiForeground = new JMenuItem("Foreground");
	private JMenuItem jmiBackground = new JMenuItem("Background");
	
	//create buttons to be placed in a toolbar
	private JButton jbtOpen = new JButton(openImageIcon);
	private JButton jbtSave = new JButton(saveImageIcon);
	private JButton jbtClear = new JButton(clearImageIcon);
	private JButton jbtExit = new JButton(exitImageIcon);
	private JLabel jlblStatus = new JLabel();
	
	//create a JFileChooser with the current directory
	private JFileChooser jFileChooser1 = new JFileChooser(new File("."));
	
	//create a textArea
	private JTextArea jta = new JTextArea();
	
	//constructor
	public Start_sAPPLET_03_textEditor_control68() {
		
		//add menu items to the menu
		JMenu jMenu1 = new JMenu("File");
		jMenu1.add(jmiOpen);
		jMenu1.add(jmiSave);
		jMenu1.add(jmiClear);
		jMenu1.addSeparator();
		jMenu1.add(jmiExit);
		
		//add menu items to the menu
		JMenu jMenu2 = new JMenu("Edit");
		jMenu2.add(jmiForeground);
		jMenu2.add(jmiBackground);
		
		//add menus to the menu bar
		JMenuBar jMenuBar1 = new JMenuBar();
		jMenuBar1.add(jMenu1);
		jMenuBar1.add(jMenu2);
		
		//set the menu bar
		setJMenuBar(jMenuBar1);
		
		//create toolbar
		JToolBar jToolBar1 = new JToolBar();
		jToolBar1.add(jbtOpen);
		jToolBar1.add(jbtSave);
		jToolBar1.add(jbtClear);
		jToolBar1.add(jbtExit);
		
		//anonymous listeners
		jmiOpen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				open();
			}
		});
		
		jmiSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		
		jmiClear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jta.setText(null);
			}
		});
		
		jmiExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		jmiForeground.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Color selectedColor = JColorChooser.showDialog(null, "Choose Foreground Color", jta.getForeground());
				
				if(selectedColor != null) jta.setForeground(selectedColor);
			}
		});
		
		jmiBackground.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Color selectColor = JColorChooser.showDialog(null, "Choose Background color", jta.getBackground());
				
				if(selectColor != null) jta.setBackground(selectColor);
			}
		});
		
		jbtOpen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				open();
			}
		});
		
		jbtSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		
		jbtClear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jta.setText(null);
			}
		});
		
		jbtExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		
		
		add(jToolBar1, BorderLayout.NORTH);
		add(jlblStatus, BorderLayout.SOUTH);
		add(new JScrollPane(jta), BorderLayout.CENTER);
		
		
	}
	
	/** open file */
	private void open() {
		if(jFileChooser1.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
			open(jFileChooser1.getSelectedFile());
	}
	
	/** open a file with a specific File instance */
	private void open(File file) {
		try{
			
			//read from a specific file and store it in jta
			BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
			byte[] b = new byte[in.available()];
			in.read(b, 0, b.length);
			jta.append(new String(b, 0, b.length));
			in.close();
			
			jlblStatus.setText(file.getName() + " Opened!");
			
		} catch(IOException ex) {
			jlblStatus.setText("Error opening " + file.getName());
		}
	}
	
	/** save file */
	private void save() {
		if(jFileChooser1.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
				save(jFileChooser1.getSelectedFile());
			
		}
	}
	
	/** save file with specified File instance */
	private void save(File file) {
		try{
			
			//write the text in jta to the specified file
			BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file));
			byte[] b = (jta.getText()).getBytes();
			out.write(b, 0, b.length);
			out.close();
			
			//display the status of the save file operation in jlblStatus
			jlblStatus.setText(file.getName() + " Saved " );
			
		} catch(IOException ex) {
			jlblStatus.setText("Error saving " + file.getName());
		}
	}
	
} 
