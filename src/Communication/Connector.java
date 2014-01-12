package Communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

/**
 * @author Frank Chen Connector receives instructions/chat messages from
 *         opposing player's ChatClient
 */
public class Connector extends Thread {
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

			boolean stillConnected = true;
			while (stillConnected) {
				// establishing connection
				Socket server = serverSocket.accept();
				System.out.println("Just connected to "
						+ server.getRemoteSocketAddress());
				// receiving request
				ObjectInputStream in = new ObjectInputStream(
						server.getInputStream());
				if (in != null) {
					System.out.println(in.readUTF());

					String reply = "";
					// sending reply
					ObjectOutputStream out = new ObjectOutputStream(
							server.getOutputStream());
					out.writeUTF("Thank you for connecting to "
							+ server.getLocalSocketAddress() + "\n" + reply);
				}
				server.close();
			}

		} catch (SocketTimeoutException s) {
			System.out.println("Socket timed out!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		int port = 7777;
		Thread t = new Connector(port);
		t.start();
	}
}
