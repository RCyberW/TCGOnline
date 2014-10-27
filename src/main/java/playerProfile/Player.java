package playerProfile;

import java.io.Serializable;
import java.util.ArrayList;
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
  private ArrayList<Deck> playerDeckList;
  private Deck currentDeck;

  public Player(String playerName) {
    setPlayerDeckList(new ArrayList<Deck>());

    setPlayerID(UUID.randomUUID());
    setPlayerName(playerName);
  }

  /**
   * @return the deck that the player is currently using
   */
  public Deck getCurrentDeck() {
    return currentDeck;
  }

  /**
   * @return the playerID
   */
  public UUID getPlayerID() {
    return playerID;
  }

  /**
   * @param playerID the playerID to set
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
   * @param playerName the playerName to set
   */
  public void setPlayerName(String playerName) {
    this.playerName = playerName;
  }

  public String toString() {
    return getPlayerName() + "(" + getPlayerID() + ")";
  }

  /**
   * @return the playerDeckList
   */
  public ArrayList<Deck> getPlayerDeckList() {
    return playerDeckList;
  }

  /**
   * Add new a new deck to the player's trunk
   * 
   * @param deck the deck to be added
   */
  public void addNewDeck(Deck deck) {
    playerDeckList.add(deck);
  }

  /**
   * @param playerDeckList the playerDeckList to set
   */
  public void setPlayerDeckList(ArrayList<Deck> playerDeckList) {
    this.playerDeckList = playerDeckList;
  }

}
