package ethos.model.content.dailytasks;

import java.util.List;

import ethos.model.players.Player;

public abstract class Challenge {
	protected ChallengeDictonary.CHALLENGE_MODE mode;
	public Challenge(ChallengeDictonary.CHALLENGE_MODE mode) {
		this.mode = mode;
	}
	//return a string representation of what the Challenge is
	public abstract String toString();
}
