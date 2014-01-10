package Communication;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.SocketAddress;

/**
 * @author Frank Chen
 * Connector receives instructions/chat messages from opposing player's ChatClient
 */
public class Connector {
	private ServerSocket serverSocket;
	
	public Connector() {
		try {
			InetAddress addr = InetAddress.getLocalHost();
			SocketAddress endpoint = new InetSocketAddress(addr, 5000);
			serverSocket = new ServerSocket();
			serverSocket.bind(endpoint);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
