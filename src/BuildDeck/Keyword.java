package BuildDeck;

import java.util.ArrayList;

public enum Keyword {
	/** Field essentials */
	LIBRARY("library", "deck"),
	TRASH("trash", "grave", "waiting_room"),
	MEMORY("out_of_game", "memory", "backyard"),
	LIFE("life"),
	
	LAND("land"), // Z/X and magic
	CHARGE("charge"), // Z/X
	CLIMAX("climax"), // W/S
	
	FRONT_ROW_1("front_1"),
	FRONT_ROW_2("front_2"),
	FRONT_ROW_3("front_3"),
	FRONT_ROW_4("front_4"),
	FRONT_ROW_5("front_5"),
	
	BACK_ROW_1("back_1"),
	BACK_ROW_2("back_2"),
	BACK_ROW_3("back_3"),
	BACK_ROW_4("back_4"),
	BACK_ROW_5("back_5"),
	
	/** Game phases */
	DRAW("draw"),
	MAIN("main"),
	ATTACK("attack"),
	DONE("done"),
	
	UNTAP("untap", "reboot", "stand"),
	RESOURCE("resource"), // Z/X
	IGNITION("ignition"), // Z/X
	COUNTER("counter")
	
	/** Game specific terms*/
	;
	
	private ArrayList<String> commonTerms;
	private String selectedTerm;
	
	/**
	 * @param keys the possible terms used across different card games
	 */
	Keyword(String ...keys ) {
		commonTerms = new ArrayList<String>();
		for (String key : keys) {
			commonTerms.add(key);
		}
	}

	/**
	 * @param term the selected term this game uses
	 */
	public void setTerm(String term) {
		if (commonTerms.contains(term)) {
			selectedTerm = term;
		}
	}
	
	/**
	 * @return the String representation of the keyword
	 */
	public String toString() {
		return selectedTerm;
	}
	
}
