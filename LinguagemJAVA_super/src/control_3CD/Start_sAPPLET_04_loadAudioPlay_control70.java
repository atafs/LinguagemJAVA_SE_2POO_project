package control_3CD;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class Start_sAPPLET_04_loadAudioPlay_control70 extends JApplet{
	
	//ATTRIBUTES
	private AudioClip sound0, sound1, sound2, sound3, currentSound;
	private JButton playButton, loopButton, stopButton;
	@SuppressWarnings("rawtypes")
	private JComboBox soundJComboBox;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void init() {
		setLayout(new FlowLayout());
		
		String[] choices = { "Welcome", "Hi", "Yes", "IUL"};
		soundJComboBox = new JComboBox(choices);
		
		//ANONYMOUS INNER CLASS
		soundJComboBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				currentSound.stop();
				//currentSound = soundJComboBox.getSelectedIndex() == 0 ? sound1 : sound2;
				
				int index = soundJComboBox.getSelectedIndex();
				switch(index){								
					case 0 :
						currentSound = sound0;
						break;
					case 1 : 
						currentSound = sound1;
						break;
					case 2 : 
						currentSound = sound2;
						break;
					case 3 : 
						currentSound = sound3;
						break;
					default :
						System.out.println("\nPor definir...\n");
				}
			}
		});
		
		add(soundJComboBox); //add to applet
		
		ButtonHandler handler = new ButtonHandler();
		
		//create play button
		playButton = new JButton("Play");
		playButton.addActionListener(handler);
		add(playButton);
		
		//create loop button
		loopButton = new JButton("Loop");
		loopButton.addActionListener(handler);
		add(loopButton);
		
		//create stop button
		stopButton = new JButton("Stop");
		stopButton.addActionListener(handler);
		add(stopButton);
		
		//load sounds and set currentSound
		sound0 = Applet.newAudioClip(this.getClass().getResource("sound/sound00.wav"));
		sound1 = Applet.newAudioClip(this.getClass().getResource("sound/sound01.wav"));
		sound2 = Applet.newAudioClip(this.getClass().getResource("sound/sound02.wav"));
		sound3 = Applet.newAudioClip(this.getClass().getResource("sound/sound03.wav"));
		currentSound = sound1;
	}
	
	//stop sound
	public void stop() {
		currentSound.stop();
	}
	
	//INNER CLASS
	private class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == playButton) {
				currentSound.play();
			}
			else if(e.getSource() == loopButton) {
				currentSound.loop();

			}
			else if(e.getSource() == stopButton) {
				currentSound.stop();

			}
		}
		
	}

}
