package control_3CD;
import javax.swing.JApplet;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Start_sAPPLET_01_flashingText extends JApplet implements Runnable {

	// JLabel com uma mensagem
	private JLabel jlblText = new JLabel("Welcome", JLabel.CENTER);

	// acrescentar JLabel a janela e inicializar a Thread
	public Start_sAPPLET_01_flashingText() {
		add(jlblText);
		new Thread(this).start();
	}

	//correr varias mensagens alternadamente
	@Override
	public void run() {
		try {
			while (true) {
				if (jlblText.getText() == "EXTREME NIGHT PACK!!!")
					jlblText.setText("WELCOME");
				else if (jlblText.getText() == "WELCOME")
					jlblText.setText("ISCTE PROGRAMMING!!!");
				else
					jlblText.setText("EXTREME NIGHT PACK!!!");

				Thread.sleep(1000);
		}

		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}
}
