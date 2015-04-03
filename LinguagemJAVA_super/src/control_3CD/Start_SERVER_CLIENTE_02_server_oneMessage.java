package control_3CD;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Start_SERVER_CLIENTE_02_server_oneMessage {

	public Start_SERVER_CLIENTE_02_server_oneMessage() {
		ServerSocket server;
		Scanner leitor;
		try {
			server = new ServerSocket(6000);
			while(true) {
				Socket s = server.accept();
				leitor = new Scanner(s.getInputStream());
				System.out.println(leitor.nextLine());
			}
		} catch (IOException e) {}
	}
	
	public static void main(String[] args) {
		new Start_SERVER_CLIENTE_02_server_oneMessage();
	}
}

/* sysout usados para testes especificos */
//System.out.println("VERIFICACAO: construtor de server chamado");
//System.out.println("VERIFICACAO: entrou no TryCatch");
//System.out.println("VERIFICACAO: inicializou o server");
//System.out.println("VERIFICACAO: estou dentro do while");
//System.out.println("VERIFICACAO: estou no servidor");


