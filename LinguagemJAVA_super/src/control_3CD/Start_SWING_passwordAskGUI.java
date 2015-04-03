package control_3CD;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Start_SWING_passwordAskGUI extends JFrame implements
		ActionListener {

	/* atributos */
	JButton ok, cancel;
	JTextField login;

	/* construtor */
	public Start_SWING_passwordAskGUI() {
		super("Textos");

		/* inicializar os objectos */
		ok = new JButton("Ok");
		cancel = new JButton("Clear");
		login = new JTextField();

		/* vincular botoes (eventos) */
		ok.addActionListener(new BotaoOkListener());
		cancel.addActionListener(new BotaoCancelListener());

		// cancel.addActionListener(this);
		// ok.addActionListener(this);

		Container c = getContentPane();

		/* formulario: botoes e senha */
		c.setLayout(new GridLayout(2, 2));
		c.add(new JLabel("Login: "));
		c.add(login);

		c.add(ok);
		c.add(cancel);

		/* definicoes base */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 200);
		setResizable(false);
		setVisible(true);

	}

	public static void main(String[] args) {
		new Start_SWING_passwordAskGUI();
	}

	/* criar outra class: trata dos eventos do botao ok */
	class BotaoOkListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			/* imprime uma String com os atributos */
			String s = "login: " + login.getText();
			JOptionPane.showMessageDialog(null, s);
		}
	}

	/* criar outra class: trata dos eventos do botao cancel */
	class BotaoCancelListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			/* definir novo texto em branco */
			login.setText("");
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//... em construcao
	}
}
