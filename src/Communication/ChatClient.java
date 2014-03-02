package Communication;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import PlayGame.InstructionInterpreter;

/**
 * @author Frank Chen
 * @version 0.1
 * @since 2014-01-01
 */
public class ChatClient extends Thread {
	private Socket clientSocket;
	private int port;
	private String serverName;
	private Message messageToServer;
	private InstructionInterpreter interpreter;

	public ChatClient(String serverName, int port) {
		this.port = port;
		this.serverName = serverName;
		try {
			System.out.println("Connecting to " + serverName + " on port "
					+ port);
			clientSocket = new Socket(serverName, port);

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		interpreter = new InstructionInterpreter();
	}

	public void writeMessage(Message message) {
		messageToServer = message;

	}

	public void run() {
		// String serverName = "174.77.36.43";
		try {

			// establishing connection
			System.out.println(clientSocket.getPort());
			System.out.println("Just connected to "
					+ clientSocket.getRemoteSocketAddress());

			// sending request
			OutputStream outToServer = clientSocket.getOutputStream();
			ObjectOutputStream out = new ObjectOutputStream(outToServer);
			out.writeObject(messageToServer);

			// receiving reply
			InputStream inFromServer = clientSocket.getInputStream();
			ObjectInputStream in = new ObjectInputStream(inFromServer);
			Message messageFromServer = (Message) in.readObject();
			System.out.println("Server says " + messageFromServer.toString());
			
			// read the message
			if (messageFromServer.getType().equals("Message")) {
			} else {
				interpreter.processInstruction((Instruction) messageFromServer);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		int port = 7777;
		Thread t = new ChatClient("10.0.0.14", port);
		t.start();
	}
}
