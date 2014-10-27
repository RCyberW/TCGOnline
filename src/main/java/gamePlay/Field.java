package gamePlay;

import java.util.ArrayList;
import java.util.HashMap;

import playerProfile.Player;

import deckComponents.Deck;

/**
 * @author Frank Chen
 * @version 0.1
 * @since 2014-01-01
 */

public class Field {
	private Player redPlayer;
	private Player bluePlayer;
	private Deck redDeck;
	private Deck blueDeck;
	private String playMatURL;
	private HashMap<String, Keyword> keywordDict;
	private HashMap<Keyword, Zone> redZones;
	private ArrayList<Zone> allZones;

	public Field() {
		setKeywordDict(new HashMap<String, Keyword>());
		setRedZones(new HashMap<Keyword, Zone>());
	}

	/**
	 * @return the redPlayer
	 */
	public Player getRedPlayer() {
		return redPlayer;
	}

	/**
	 * @param redPlayer the redPlayer to set
	 */
	public void setRedPlayer(Player redPlayer) {
		this.redPlayer = redPlayer;
	}

	/**
	 * @return the bluePlayer
	 */
	public Player getBluePlayer() {
		return bluePlayer;
	}

	/**
	 * @param bluePlayer the bluePlayer to set
	 */
	public void setBluePlayer(Player bluePlayer) {
		this.bluePlayer = bluePlayer;
	}

	/**
	 * @return the redDeck
	 */
	public Deck getRedDeck() {
		return redDeck;
	}

	/**
	 * @param redDeck the redDeck to set
	 */
	public void setRedDeck(Deck redDeck) {
		this.redDeck = redDeck;
	}

	/**
	 * @return the blueDeck
	 */
	public Deck getBlueDeck() {
		return blueDeck;
	}

	/**
	 * @param blueDeck the blueDeck to set
	 */
	public void setBlueDeck(Deck blueDeck) {
		this.blueDeck = blueDeck;
	}

	/**
	 * @return the playMatURL
	 */
	public String getPlayMatURL() {
		return playMatURL;
	}

	/**
	 * @param playMatURL the playMatURL to set
	 */
	public void setPlayMatURL(String playMatURL) {
		this.playMatURL = playMatURL;
	}

	/**
	 * @return the keywordDict
	 */
	public HashMap<String, Keyword> getKeywordDict() {
		return keywordDict;
	}

	/**
	 * @param keywordDict the keywordDict to set
	 */
	public void setKeywordDict(HashMap<String, Keyword> keywordDict) {
		this.keywordDict = keywordDict;
	}

	/**
	 * @return the zoneNames
	 */
	public HashMap<Keyword, Zone> getRedZones() {
		return redZones;
	}

	/**
	 * @param zoneNames the zoneNames to set
	 */
	public void setRedZones(HashMap<Keyword, Zone> redZones) {
		this.redZones = redZones;
	}

	/**
	 * @return the allZones
	 */
	public ArrayList<Zone> getAllZones() {
		return allZones;
	}

	/**
	 * @param allZones the allZones to set
	 */
	public void setAllZones(ArrayList<Zone> allZones) {
		this.allZones = allZones;
	}

}
