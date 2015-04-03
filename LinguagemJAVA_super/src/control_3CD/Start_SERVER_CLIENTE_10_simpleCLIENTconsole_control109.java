package control_3CD;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Start_SERVER_CLIENTE_10_simpleCLIENTconsole_control109 {
	
	//ATTRIBUTES
	private BufferedReader in;
	private PrintWriter out;
	private Socket socket;
	
	//MAIN
	public static void main(String[] args) {
		new Start_SERVER_CLIENTE_10_simpleCLIENTconsole_control109().runClient();
	}
	
	//OTHER METHODS
	public void runClient() {
		
		try {
			connectToServer();
			sendMessages();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			System.out.println("a FECHAR...");
			try {
				socket.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	private void connectToServer() throws IOException {
		
		InetAddress endereco = InetAddress.getByName(null);
		System.out.println("Endereco: " + endereco);
		socket = new Socket(endereco, Start_SERVER_CLIENTE_10_simpleSERVERconsole_control109.PORT);
		
		System.out.println("Socket = " + socket);
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);

	}
	
	private void sendMessages() throws IOException {
		
		for (int i = 0; i < 10; i++) {
			
			out.println("FROM CLIENT: Ola -> " + i);
			String str = in.readLine();
			//aqui esta o ERRO... in é BufferedReader...
			System.out.println(str);
		}
		out.println("FIM");
	}

}
