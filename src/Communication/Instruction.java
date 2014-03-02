package Communication;

import java.util.HashMap;

import BuildDeck.Card;
import PlayGame.Keyword;
import Profile.Player;

/**
 * @author Frank Chen
 * @version 0.1
 * @since 2014-01-01
 */
public class Instruction extends Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2509094028695992976L;
	private Keyword keyword;
	private Card card;
	private HashMap<String, String> instructionProperties;

	public Instruction(Player sourcePlayer, Player targetPlayer) {
		super(sourcePlayer, targetPlayer);
		// TODO Auto-generated constructor stub
		setInstructionProperties(new HashMap<String, String>());
	}

	public void insertKeyword(Keyword keyword, Card card) {
		setKeyword(keyword);
		setCard(card);
		super.setChatMessage(chatMessage + keyword.toString());
	}

	/**
	 * @return the keyword
	 */
	public Keyword getKeyword() {
		return keyword;
	}

	/**
	 * @param keyword
	 *            the keyword to set
	 */
	public void setKeyword(Keyword keyword) {
		this.keyword = keyword;
	}

	/**
	 * @return the card
	 */
	public Card getCard() {
		return card;
	}

	/**
	 * @param card
	 *            the card to set
	 */
	public void setCard(Card card) {
		this.card = card;
	}

	/**
	 * @return the instructionProperties
	 */
	public HashMap<String, String> getInstructionProperties() {
		return instructionProperties;
	}

	/**
	 * @param instructionProperties
	 *            the instructionProperties to set
	 */
	public void setInstructionProperties(
			HashMap<String, String> instructionProperties) {
		this.instructionProperties = instructionProperties;
	}

	/**
	 * @param key
	 *            the type of the property
	 * @param detail
	 *            the specific value of the property
	 */
	public String addProperty(String key, String detail) {
		return instructionProperties.put(key, detail);
	}

	public String getType() {
		return "Instruction";
	}
	
}
