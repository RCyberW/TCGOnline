package deckComponents;

import gamePlay.Zone;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;

import javax.swing.JLabel;

import playerProfile.Player;

/**
 * @author Frank Chen
 * @version 0.1
 * @since 2014-01-01
 */
public class Card implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4807348862386578995L;
	private HashMap<String, String> properties;
	private ArrayList<Card> cloneCards;
	private Zone associatedZone;
	private String imageURL;
	private Player associatedPlayer;
	private UUID cardID;

	public Card() {
		setProperties(new HashMap<String, String>());
		setCloneCards(new ArrayList<Card>());
		setCardID(UUID.randomUUID());
	}

	public Card(String name) {
		HashMap<String, String> thisProp = new HashMap<String, String>();
		thisProp.put("card_name", name);
		setProperties(thisProp);
		setCloneCards(new ArrayList<Card>());
		setCardID(UUID.randomUUID());
	}

	/**
	 * @param searchProperties the properties to match this card with
	 * @return if this card matches specified properties
	 */
	public boolean isMatch(HashMap<String, String> searchProperties) {
		boolean isMatching = true;
		Iterator<String> searchKeys = searchProperties.keySet().iterator();

		while (searchKeys.hasNext() && isMatching) {
			String key = searchKeys.next();
			String expectedValue = searchProperties.get(key);
			String originalValue = properties.get(key);
			isMatching = isMatching && expectedValue.equalsIgnoreCase(originalValue);
		}

		return isMatching;
	}

	/**
	 * @return the properties
	 */
	public HashMap<String, String> getProperties() {
		return properties;
	}

	/**
	 * @param properties the properties to set
	 */
	public void setProperties(HashMap<String, String> properties) {
		this.properties = properties;
	}

	/**
	 * @return the cloneCards
	 */
	public ArrayList<Card> getCloneCards() {
		return cloneCards;
	}

	/**
	 * @param cloneCards the cloneCards to set
	 */
	public void setCloneCards(ArrayList<Card> cloneCards) {
		this.cloneCards = cloneCards;
	}

	/**
	 * @return the imageURL
	 */
	public String getImageURL() {
		return imageURL;
	}

	/**
	 * @param imageURL the imageURL to set
	 */
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	/**
	 * @return the associatedPlayer
	 */
	public Player getAssociatedPlayer() {
		return associatedPlayer;
	}

	/**
	 * @param associatedPlayer the associatedPlayer to set
	 */
	public void setAssociatedPlayer(Player associatedPlayer) {
		this.associatedPlayer = associatedPlayer;
	}

	/**
	 * @return the cardID
	 */
	public UUID getCardID() {
		return cardID;
	}

	/**
	 * @param cardID the cardID to set
	 */
	public void setCardID(UUID cardID) {
		this.cardID = cardID;
	}

	/**
	 * @return the associatedZone
	 */
	public Zone getAssociatedZone() {
		return associatedZone;
	}

	/**
	 * @param associatedZone the associatedZone to set
	 */
	public void setAssociatedZone(Zone associatedZone) {
		this.associatedZone = associatedZone;
	}

	/**
	 * @param key the field of the card
	 * @param detail the specific text to the field
	 */
	public String addProperty(String key, String detail) {
		return properties.put(key, detail);
	}

	public String toString() {
		return getCardID().toString();
	}

	public JLabel grabImage() {
		// TODO Auto-generated method stub
		return null;
	}
}
