package control_3CD;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Start_SERVER_CLIENTE_03_server_multipleMessages {

	//construtor
	public Start_SERVER_CLIENTE_03_server_multipleMessages() {
		ServerSocket server;
		try {
			server = new ServerSocket(6001);
			while(true) {
				Socket socket = server.accept();
				new Thread(new EscutaCliente(socket)).start();
			}
		} catch (IOException e) {}
	}
	
	//escutar requisicoes dos clientes
	private class EscutaCliente implements Runnable {

		Scanner leitor;
		public EscutaCliente(Socket socket) throws IOException {
			leitor = new Scanner(socket.getInputStream());
		}
		
		@Override
		public void run() {
			try {//capturar exceptions
				String texto;
				while((texto = leitor.nextLine()) != null) {
					System.out.println(texto);
				}
			} catch(Exception e) {}
		}
	}
	
	//main
	public static void main(String[] args) {
		new Start_SERVER_CLIENTE_03_server_multipleMessages();
	}
}

/* sysout usados para testes especificos */
//System.out.println("VERIFICACAO: construtor de server chamado");
//System.out.println("VERIFICACAO: entrou no TryCatch");
//System.out.println("VERIFICACAO: inicializou o server");
//System.out.println("VERIFICACAO: estou dentro do while");
//System.out.println("VERIFICACAO: estou no servidor");


