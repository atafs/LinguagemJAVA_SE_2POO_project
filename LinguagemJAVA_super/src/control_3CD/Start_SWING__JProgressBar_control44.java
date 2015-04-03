package control_3CD;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

@SuppressWarnings("serial")
public class Start_SWING__JProgressBar_control44 extends JApplet {

	// ATTRIBUTES
	private JProgressBar jpb = new JProgressBar();
	private JTextArea jtaResult = new JTextArea();
	private JTextField jtfPrimeCount = new JTextField(8);
	private JButton jbtDisplayPrime = new JButton("Display Prime");

	public Start_SWING__JProgressBar_control44() {

		// JProgressBar
		jpb.setStringPainted(true); // paint a percent in a string
		jpb.setValue(0);
		jpb.setMaximum(100);

		// JTextArea
		jtaResult.setWrapStyleWord(true);
		jtaResult.setLineWrap(true);

		// JPanel
		JPanel panel = new JPanel();
		panel.add(new JLabel("Enter the prime number count"));
		panel.add(jtfPrimeCount);
		panel.add(jbtDisplayPrime);

		// JApplet
		add(jpb, BorderLayout.NORTH);
		add(new JScrollPane(jtaResult), BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);

		// ADD BUTTON LISTENER
		jbtDisplayPrime.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				//CREATE TASK
				ComputePrime task = new ComputePrime(Integer.parseInt(jtfPrimeCount.getText()), jtaResult);
				
				//ADD PROPERTY LISTENER
				task.addPropertyChangeListener(new PropertyChangeListener() {
					
					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if("progress".equals(evt.getPropertyName())) {
							jpb.setValue((Integer)evt.getNewValue());
						}
					}
				});
				
				task.execute(); //EXECUTE SwingWorker
			}
		});
	}
	
	//TASK CLASS for SwingWorker
	static class ComputePrime extends SwingWorker<Integer, Integer> {

		
		//ATTRIBUTES
		private int count;
		private JTextArea result;
		
		//CONSTRUCT A RUNNABLE TASK
		public ComputePrime(int count, JTextArea result) {
			this.count = count;
			this.result = result;
		}
		
		//CODE RUN ON A BACKGROUND THREAD
		@Override
		protected Integer doInBackground() throws Exception {
			publishPrimeNumbers(count);
			return null;
		}
		
		//OVERRIDE PROCERSS TO DISPLAY PUBLISHED PRIME VALUES
		protected void process(List<Integer> list) {
			for (int i = 0; i < list.size(); i++) {
				result.append(list.get(i) + " ");
			}
		}
		
		//PUBLISH THE FIRST N PRIME NUMBERS
		private void publishPrimeNumbers(int n) {
			int count = 0;  //count the number of prime numbers
			int number = 2; //a number to be tested for primeness
			
			//REPEATEDLY FIND PRIME NUMBERS
			while(count <= n) {
				
				//PRINT THE PRIME NUMBER ABD INCREASE COUNT
				if(isPrime(number)) {
					count++;
					setProgress( (100 * count) / n); //update progress
					publish(number);
				}
				
				//CHECK IF THE NUMBER IS PRIME
				number++;
			}
		}
		
		//CHECK WETHER NUMBER IS PRIME
		private static boolean isPrime(int number) {
			
			for (int divisor = 2; divisor <= number/2; divisor++) {
				if(number % divisor == 0) {
					return false;
				}
			}
			
			return true;
		}
	}
}
