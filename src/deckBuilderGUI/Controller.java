package deckBuilderGUI;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.Box;
import javax.swing.JScrollPane;

import deckComponents.Card;

/**
 * The master controller at telling the UI what components to display on each
 * individual field
 * 
 * @author Frank Chen
 * @version 0.1
 * @since 2014-10-12
 */

public class Controller {

	private HashMap<String, Integer> gameFieldProperties;
	private ArrayList<Card> resultList;
	private int searchRowCount;
	
	/**
	 * Do not override
	 */
	
	public Controller() {
		gameFieldProperties = new HashMap<String, Integer>();
		resultList = new ArrayList<Card>();
		searchRowCount = 0;
		
		deserialize();
	}
	
	/**
	 * @return the total number of rows that the search field would have
	 */
	public int getSearchRowCount() {
		return searchRowCount;
	}

	/**
	 * @param searchRowCount the number of rows that the search field would have
	 */
	public void setSearchRowCount(int searchRowCount) {
		this.searchRowCount = searchRowCount;
	}

	/**
	 * @return a map of properties that is associated with the game to the row in
	 *         which would be used to search
	 */
	public HashMap<String, Integer> getProperties() {
		return gameFieldProperties;
	}

	/**
	 * @param gameFieldProperties the name of the card properties for the game to
	 *          the row in which the search input would be displayed on
	 */
	public void setProperties(HashMap<String, Integer> gameFieldProperties) {
		this.gameFieldProperties = gameFieldProperties;
	}
	
	/**
	 * @return the resultList
	 */
	public ArrayList<Card> getResultList() {
		return resultList;
	}

	/**
	 * @param resultList the resultList to set
	 */
	public void setResultList(ArrayList<Card> resultList) {
		this.resultList = resultList;
	}

	/**
	 * Subclasses to override
	 */
	
	private void deserialize() {
		// TODO Auto-generated method stub
	}
	
	public Box getDetailedView(Card referenceCard) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public JScrollPane getQueryListView(String query) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Box getDeckListView(Card referenceCard) {
		// TODO Auto-generated method stub
		return null;
	}
}
