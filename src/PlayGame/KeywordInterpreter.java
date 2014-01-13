package PlayGame;

import Communication.Instruction;
import Profile.Player;

/**
 * @author Frank Chen
 * @version 0.1
 * @since 2014-01-01
 */
public class KeywordInterpreter {

	private static Player player;
	
	public static void processInstruction(Instruction instruction) {
		// process the instruction on how the card is to be placed
		switch (instruction.getKeyword()) {
		case DECK_DRAW:
			draw();
			break;
		default:
			break;

		}
	}

	public static void drawPhase() {
		
	}

	public static void mainPhase() {

	}

	public static void attackPhase() {

	}

	public static void endPhase() {

	}

	public static void draw() {
		player.getCurrentDeck().draw();
	}

	/**
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * @param player the player to set
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

}
