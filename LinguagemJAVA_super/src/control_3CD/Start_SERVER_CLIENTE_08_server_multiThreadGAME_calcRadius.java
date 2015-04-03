package control_3CD;

import java.awt.BorderLayout;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class Start_SERVER_CLIENTE_08_server_multiThreadGAME_calcRadius extends JFrame {

	//atributos
	private JTextArea jta = new JTextArea();
	private int clientNum = 1;//localVariable: number of client
	private double radius;
	private double area;
	
	//main
	public static void main(String[] args) {
		new Start_SERVER_CLIENTE_08_server_multiThreadGAME_calcRadius();
	}
	
	//construtor
	public Start_SERVER_CLIENTE_08_server_multiThreadGAME_calcRadius() {
		
		//place text area on the frame
		textAreaOnFrame();
		
		try{
			//create a server socket
			@SuppressWarnings("resource")
			ServerSocket serverSocket = new ServerSocket(8000);
			jta.append("MultiTreadServer started at " + new Date() + "\n");//informacaoAdicional
			
			while(true) {
				//listen for a new connection request
				Socket socket = serverSocket.accept();
				
				//find the clients number, host name and IP address
				clientHostNameAndIPAddress(socket);
				
				//innerClass: create a new thread for the connection
				HandleAClient task = new HandleAClient(socket, clientNum);
				
				//start the new thread
				new Thread(task).start();
				clientNum++;//increment clientNumber for nextClient
			}
		} catch(IOException ex) {
			System.err.println(ex);
		}
	}

	//find the clients number, host name and IP address
	private void clientHostNameAndIPAddress(Socket socket) {
		jta.append("Starting thread for [Client " + clientNum + "] at " + new Date() + '\n');//informacaoAdicional

		InetAddress inetAddress = socket.getInetAddress();
		jta.append("[Client " + clientNum + "]: host name is " + inetAddress.getHostName() + "\n");
		jta.append("[Client " + clientNum + "]: IP address is " + inetAddress.getHostAddress() + "\n");
	}

	//rotina: place text area on the frame
	private void textAreaOnFrame() {
		setLayout(new BorderLayout());
		add(new JScrollPane(jta), BorderLayout.CENTER);
		
		setTitle("MultiThreadServer");
		setSize(500,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);//always last instrution
	}
	
	//innerClass: create a new thread for the connection
	class HandleAClient implements Runnable {

		//atributos
		private Socket socket;
		private int clientNum;
		
		//construtor
		public HandleAClient(Socket socket, int clientNum) {
			this.socket = socket;
			this.clientNum = clientNum;
		}
		
		//run the thread
		@Override
		public void run() {
			try {
				//create data input and output stream
				DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
				DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());
				
				while(true) {
					
					//receive from client
					radius = inputFromClient.readDouble();
					//compute area
					area = radius * radius * Math.PI;
					
					//send back to the client
					outputToClient.writeDouble(area);
					
					//radius received from client and area computed
					radiusFromClientAndAreaComputed();
				}
			} catch(IOException ex) {
				System.err.println(ex);
			}
		}

		//radius received from client and area computed
		private void radiusFromClientAndAreaComputed() {
			jta.append("Radius received from [Client" + clientNum + "]: " + radius + '\n');
			jta.append("Area found: " + area + '\n');
		}
		
	}
	
}
