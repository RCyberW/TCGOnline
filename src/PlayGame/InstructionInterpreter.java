package PlayGame;

import Communication.Instruction;
import Profile.Player;

/**
 * @author Frank Chen
 * @version 0.1
 * @since 2014-01-01
 */
public class InstructionInterpreter {

	private Player player;
	
	public void processInstruction(Instruction instruction) {
		// process the instruction on how the card is to be placed
		switch (instruction.getKeyword()) {
		case DECK_DRAW:
			draw();
			break;
		case DRAW_PHASE:
			drawPhase(instruction);
			break;
		case MAIN_PHASE:
			mainPhase(instruction);
			break;
		case ATTACK_PHASE:
			attackPhase(instruction);
			break;
		case END_PHASE:
			endPhase(instruction);
			break;
		default:
			System.out.println(instruction.getKeyword());
			break;
		}
	}

	public void drawPhase(Instruction instruction) {
		player.getCurrentDeck().draw(instruction.getCard());
	}

	public void mainPhase(Instruction instruction) {

	}

	public void attackPhase(Instruction instruction) {

	}

	public void endPhase(Instruction instruction) {

	}

	public void draw() {
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
