package control_0Pattern.observer.week9_poo;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;


public class Observador implements Observer {

	@Override
	public void update(Observable observado, Object object) {
		if(object instanceof String) {
			String palavra = (String) object;
			
			JOptionPane.showMessageDialog(null, "Palavra: " + palavra, 
					"Titulo", JOptionPane.INFORMATION_MESSAGE);
			
		}
	}

}
