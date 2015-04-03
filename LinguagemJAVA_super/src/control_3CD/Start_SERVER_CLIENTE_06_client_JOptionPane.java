package control_3CD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Start_SERVER_CLIENTE_06_client_JOptionPane {
	
	public static void main(String[] args) {
		
		Start_SERVER_CLIENTE_06_client_JOptionPane client = new Start_SERVER_CLIENTE_06_client_JOptionPane();
		client.run();
	}
	
	public void run() {
		

		
		try {
			
			/*socket*/
			@SuppressWarnings("resource")
			Socket socket = new Socket("localhost", 444);
			PrintStream printOutput = new PrintStream(socket.getOutputStream());
			printOutput.println("CLIENT: HELLO to SERVER from CLIENT");
			
			/*reader*/
			InputStreamReader readInput = new InputStreamReader(socket.getInputStream());
			BufferedReader bufferInput = new BufferedReader(readInput);
			
			/*print*/
			String message = bufferInput.readLine();
			//System.out.println(message);
			JOptionPane.showMessageDialog(null, message, "SERVER", JOptionPane.INFORMATION_MESSAGE);

			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
