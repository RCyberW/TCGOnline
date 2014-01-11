package Communication;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author Frank Chen
 * ChatClient sends instructions or chat message to the opposing player's Connector.
 */
public class ChatClient extends Thread {
	private Socket clientSocket;
	private int port;
	private String serverName;
	public ChatClient(String serverName, int port) {
		this.port = port;
		this.serverName = serverName;
		try {
			System.out.println("Connecting to " + serverName + " on port " + port);
			clientSocket = new Socket(serverName, port);
			System.out.println(clientSocket.getPort());
			System.out.println("Just connected to "
				+ clientSocket.getRemoteSocketAddress());

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		serverName = "Cyber";
		// String serverName = "174.77.36.43";
		try {
			System.out.println("Connecting to " + serverName + " on port "
					+ port);
			
			// establishing connection
			Socket client = new Socket(serverName, port);
			System.out.println(client.getPort());
			System.out.println("Just connected to "
					+ client.getRemoteSocketAddress());
			
			// sending request
			OutputStream outToServer = client.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);
			out.writeUTF("Hello from " + client.getLocalSocketAddress());
			
			// receiving reply
			InputStream inFromServer = client.getInputStream();
			DataInputStream in = new DataInputStream(inFromServer);
			System.out.println("Server says " + in.readUTF());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		int port = 9090;
		Thread t = new ChatClient("Blade", port);
		t.start();
	}
}
