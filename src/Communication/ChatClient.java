package Communication;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author Frank Chen
 * ChatClient sends instructions or chat message to the opposing player's Connector.
 */
public class ChatClient {
	private Socket clientSocket;
	
	public ChatClient(String serverName, int port) {
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
}
