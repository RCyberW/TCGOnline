package Communication;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;

/**
 * @author Frank Chen Connector receives instructions/chat messages from
 *         opposing player's ChatClient
 */
public class Connector {
	private ServerSocket serverSocket;

	public Connector(int port) {
		InetAddress addr;
		try {
			addr = InetAddress.getLocalHost();
			SocketAddress endpoint = new InetSocketAddress(addr, port);
			serverSocket = new ServerSocket();
			serverSocket.bind(endpoint);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() {
		try {
			System.out.println("Waiting for client on port "
					+ serverSocket.getLocalSocketAddress().toString() + "...");
			// establishing connection
			Socket server = serverSocket.accept();
			System.out.println("Just connected to "
					+ server.getRemoteSocketAddress());

			// receiving request
			DataInputStream in = new DataInputStream(server.getInputStream());
			System.out.println(in.readUTF());

			String reply = "";

			// sending reply
			DataOutputStream out = new DataOutputStream(
					server.getOutputStream());
			out.writeUTF("Thank you for connecting to "
					+ server.getLocalSocketAddress() + "\n" + reply);

		} catch (SocketTimeoutException s) {
			System.out.println("Socket timed out!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
