package playerProfile;

import java.io.Serializable;
import java.util.UUID;

import deckComponents.Deck;


/**
 * @author Frank Chen
 * @version 0.1
 * @since 2014-01-01
 */
public class Player implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8592534492562689005L;
	private UUID playerID;
	private String playerName;

	public Player(String playerName) {
		setPlayerID(UUID.randomUUID());
		setPlayerName(playerName);
	}

	public Deck getCurrentDeck() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return the playerID
	 */
	public UUID getPlayerID() {
		return playerID;
	}

	/**
	 * @param playerID
	 *            the playerID to set
	 */
	public void setPlayerID(UUID playerID) {
		this.playerID = playerID;
	}

	/**
	 * @return the playerName
	 */
	public String getPlayerName() {
		return playerName;
	}

	/**
	 * @param playerName
	 *            the playerName to set
	 */
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String toString() {
		return getPlayerName() + "(" + getPlayerID() + ")";
	}

}
