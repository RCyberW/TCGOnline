package Communication;

import Profile.Player;

/**
 * @author Frank Chen
 * @version 0.1
 * @since 2014-01-01
 */
public class Message {

	protected Player associatedPlayer;
	protected String chatMessage;

	public Message(Player player) {
		setAssociatedPlayer(player);
	}

	/**
	 * @return the chatMessage
	 */
	public String getChatMessage() {
		return chatMessage;
	}

	/**
	 * @param chatMessage
	 *            the chatMessage to set
	 */
	public void setChatMessage(String chatMessage) {
		this.chatMessage = chatMessage;
	}

	/**
	 * @return the associatedPlayer
	 */
	public Player getAssociatedPlayer() {
		return associatedPlayer;
	}

	/**
	 * @param associatedPlayer
	 *            the associatedPlayer to set
	 */
	public void setAssociatedPlayer(Player associatedPlayer) {
		this.associatedPlayer = associatedPlayer;
	}

}
