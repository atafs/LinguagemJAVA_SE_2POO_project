package control_3CD;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Start_SERVER_CLIENTE_10_simpleSERVERconsole_control109 {
	
	//ATTRIBUTES
	public static final int PORT = 8080;
	private BufferedReader in;
	private PrintWriter out;
	
	//MAIN
	public static void main(String[] args) {
		
		try {
			new Start_SERVER_CLIENTE_10_simpleSERVERconsole_control109().startServing();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//OTHER METHODS
	public void startServing() throws IOException {
		
		ServerSocket serverSocket = new ServerSocket(PORT);
		System.out.println("Lancou ServerSocket: " + serverSocket + "\n");
		
		try {
			
			Socket socket = serverSocket.accept();
			
			try {
				
				System.out.println("Conexao ACEITE: " + socket + "\n");
				doConnections(socket);
				serve();
				
			} finally {
				System.out.println("a FECHAR..\n");
				socket.close();
			}
			
		} finally {
			serverSocket.close();
		}
	}
	
	private void doConnections(Socket socket) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
	}
	
	private void serve() throws IOException {
		
		while (true) {
			
			String str = in.readLine();
			if (str.equals("FIM")) {
				break;
			}
			
			System.out.println("ECO in SERVER: " + str);
			out.println(str);
			
		}
	}
	

}
