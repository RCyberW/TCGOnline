package deckBuilderGUI;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.Box;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import deckComponents.Card;

/**
 * The master controller at telling the UI what components to display on each
 * individual field
 * 
 * @author Frank Chen
 * @version 0.1
 * @since 2014-10-12
 */

public abstract class Controller {

	private ArrayList<UIComponentInfo> gameFieldProperties;
	private ArrayList<Card> resultList;
	private int searchRowCount;
	
	/**
	 * Do not override
	 */
	
	public Controller() {
		gameFieldProperties = new ArrayList<UIComponentInfo>();
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
	public ArrayList<UIComponentInfo> getProperties() {
		return gameFieldProperties;
	}

	/**
	 * @param gameFieldProperties the name of the card properties for the game to
	 *          the row in which the search input would be displayed on
	 */
	public void setProperties(ArrayList<UIComponentInfo> gameFieldProperties) {
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
	
	public abstract void deserialize();
	
	public abstract Box getDetailedView(Card referenceCard);
	
	public abstract JTable getQueryListView(HashMap<String, String> query);
	
	public abstract JTable getDeckListView();
	
	public abstract Box getDeckInfoPane();
}
