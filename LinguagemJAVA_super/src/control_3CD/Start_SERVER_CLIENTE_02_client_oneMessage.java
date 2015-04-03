package control_3CD;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Start_SERVER_CLIENTE_02_client_oneMessage extends JFrame{
	
	JTextField textoParaEnviar;
	Socket socket;
	PrintWriter escritor;
	
	//interface grafica GUI
	public Start_SERVER_CLIENTE_02_client_oneMessage() throws Exception {
		super("Chat");
		//fonte e botoes/texto
		Font fonte = new Font("Serif", Font.PLAIN, 26);
		textoParaEnviar = new JTextField();
		textoParaEnviar.setFont(fonte);
		JButton botao = new JButton("Enviar");
		botao.setFont(fonte);
		botao.addActionListener(new EnviarListener());
		
		//Container principal e JPanel
		Container envio = new JPanel();
		envio.setLayout(new BorderLayout());
		envio.add(BorderLayout.CENTER, textoParaEnviar);
		envio.add(BorderLayout.EAST, botao);
		getContentPane().add(BorderLayout.SOUTH, envio);
		
		//configuracao de rede
		configurarRede();
		
		//instrucoes finais da janela
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,120);
		setLocationRelativeTo(null); 
		setVisible(true);
		
		//System.out.println("Executei todas as instrucoes");
	}
	
	//listener
	private class EnviarListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			escritor.println(textoParaEnviar.getText());
			escritor.flush();//garantir que foi enviado
			textoParaEnviar.setText("");//limpar campo de texto
			textoParaEnviar.requestFocus();//colocar cursor dentro do campo
		}
	}

	//ligacao com o servidor
	private void configurarRede() throws Exception {
	
		try {
			socket = new Socket("127.0.0.1", 6000);
			escritor = new PrintWriter(socket.getOutputStream());
		} catch (Exception e) {}
	}
		
	//main
	public static void main(String[] args) throws Exception {
		new Start_SERVER_CLIENTE_02_client_oneMessage();
	}
}
