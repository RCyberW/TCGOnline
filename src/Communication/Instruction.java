package Communication;

import BuildDeck.Card;
import BuildDeck.Keyword;
import Profile.Player;

public class Instruction extends Message {

	private Keyword keyword;
	private Card card;

	public Instruction(Player player) {
		super(player);
		// TODO Auto-generated constructor stub
	}

	public void insertKeyword(Keyword keyword, Card card) {
		setKeyword(keyword);
		setCard(card);
		super.setChatMessage(chatMessage + keyword.toString());
	}

	public void processInstruction() {
		// process the instruction on how the card is to be placed
		switch (keyword) {
		case DRAW:
			break;
		default:
			break;

		}

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

}
