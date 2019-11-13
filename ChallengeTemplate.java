package ethos.model.content.dailytasks;

import ethos.model.players.Player;

public abstract class ChallengeTemplate {
	abstract void generateChallenge(Player p);
	abstract void challengeUpdater(Player p);
	abstract void challengeComplete(Player p); 
	
	abstract void generateChallenge(Player players[]);
	abstract void challengeUpdater(Player players[]);
	abstract void challengeComplete(Player players[]);
}
