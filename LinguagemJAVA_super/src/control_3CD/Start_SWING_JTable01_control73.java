package control_3CD;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class Start_SWING_JTable01_control73 extends JApplet{

	//table column with names
	private String[] columnNames = {"Country", "Capital", "Population in Millions", "Democracy"};
	
	//table with data
	private Object[][] rowData = {
			{"USA", "Washington DC", 280, true}, 
			{"Canada", "Ottawa", 32, true},
			{"United Kingdom", "London", 60, true},
			{"Germany", "Berlin", 83, true},
			{"France", "Paris", 60, true},
			{"Norway", "Oslo", 4.5, true},
			{"India", "New Delhi", 1046, true}
		};

	//create a table
	JTable jTable1 = new JTable(rowData, columnNames);
	
	//create two spinners
	private JSpinner jspiRowHeight = new JSpinner(new SpinnerNumberModel(16,1,50,1));
	private JSpinner jspiRowMargin = new JSpinner(new SpinnerNumberModel(1, 1, 50, 1));
	
	//create a check box
	private JCheckBox jchkShowGrid = new JCheckBox("showGrid", true);
	
	//create a combo box
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private JComboBox jcboAutoResizeMode = new JComboBox(new String[] {
			"AUTO_RESIZE_OFF", "AUTO_RESIZE_LAST_COLUMN", 
			"AUTO_RESIZE_SUBSEQUENT_COLUMNS", "AUTO_RESIZE_NEXT_COLUMN",
			"AUTO_RESIZE_ALL_COLUMNS" });
			
	public Start_SWING_JTable01_control73() {
		JPanel panel1 = new JPanel();
		panel1.add(new JLabel("rowHeight"));
		panel1.add(jspiRowHeight);
		panel1.add(new JLabel("rowMargin"));
		panel1.add(jspiRowMargin);
		panel1.add(jchkShowGrid);
		
		JPanel panel2 = new JPanel();
		panel2.add(new JLabel("autoResizeMode"));
		panel2.add(jcboAutoResizeMode);
		
		add(panel1, BorderLayout.SOUTH);
		add(panel2, BorderLayout.NORTH);
		add(new JScrollPane(jTable1));
		
		//initialize jTable1
		jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jTable1.setGridColor(Color.BLUE);
		jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jTable1.setSelectionBackground(Color.RED);
		jTable1.setSelectionForeground(Color.WHITE);
		
		//register and create a listener for jspiRowHeight
		jspiRowHeight.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent arg0) {
				((Integer)(jspiRowHeight.getValue())).intValue();
			}
		});
		
		//register and create a listener for jspiRowMargin
		jchkShowGrid.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				jTable1.setShowGrid(jchkShowGrid.isSelected());
			}
		});

		//register and create a listener for jcboAutoResizeMode
		jcboAutoResizeMode.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedItem = (String)jcboAutoResizeMode.getSelectedItem();
				
				//algorithm
				if(selectedItem.equals("AUTO_RESIZE_OFF")) jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				else if (selectedItem.equals("AUTO_RESIZE_LAST_COLUMN")) jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
				else if (selectedItem.equals("AUTO_RESIZE_SUBSEQUENT_COLUMNS")) jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
				else if (selectedItem.equals("AUTO_RESIZE_NEXT_COLUMN")) jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
				else if (selectedItem.equals("AUTO_RESIZE_ALL_COLUMNS")) jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

			}
		});
	}
}
