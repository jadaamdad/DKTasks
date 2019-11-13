package ethos.model.content.dailytasks;

import java.util.List;

import ethos.model.content.dailytasks.ChallengeDictonary.CHALLENGE_TYPES;
import ethos.model.players.Player;

public class PVMChallenge extends Challenge {
	private int[] challengeInfo = new int[2];
	private int monstersLeft = 0;
	public PVMChallenge(ChallengeDictonary.CHALLENGE_MODE mode, int monsterId, int amount) {
		super(mode);
		challengeInfo[0] = monsterId;
		challengeInfo[1] = amount;
		monstersLeft = challengeInfo[1];
	}
	/*
	 * Update the monster count 1 kill at a time
	 */
	protected void update() {
		monstersLeft-=1;
		System.out.println("Monsters left " + monstersLeft);
	}
	/*
	 * return a string representation of what the Challenge is
	 */
	@Override
	public String toString() {
		System.out.println("Your PVM challenge is to kill " + challengeInfo[1] + " " +challengeInfo[0]);
		return null;
	}
	
}
