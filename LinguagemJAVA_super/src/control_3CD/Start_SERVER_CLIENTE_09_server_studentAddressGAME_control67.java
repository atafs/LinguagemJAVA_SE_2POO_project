package control_3CD;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Start_SERVER_CLIENTE_09_server_studentAddressGAME_control67 {

	// attributes
	private ObjectOutputStream outputToFile;
	private ObjectInputStream inputFromCliente;

	// main
	public static void main(String[] args) {
		new Start_SERVER_CLIENTE_09_server_studentAddressGAME_control67();
	}

	// constructor
	public Start_SERVER_CLIENTE_09_server_studentAddressGAME_control67() {
		try {

			// create a serverSocket
			@SuppressWarnings("resource")
			ServerSocket serverSocket = new ServerSocket(8000);
			System.out.println("Server Started");

			// create an objectOutputStream
			outputToFile = new ObjectOutputStream(new FileOutputStream(
					"student.dat", true));

			while (true) {

				// listen for a new connection request
				Socket socket = serverSocket.accept();

				// create an inputStream from the socket
				inputFromCliente = new ObjectInputStream(
						socket.getInputStream());

				// read from input
				Object object = inputFromCliente.readObject();

				// write to the file
				outputToFile.writeObject(object);
				System.out.println("A new student object is stored");
			}

		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				inputFromCliente.close();
				outputToFile.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}
