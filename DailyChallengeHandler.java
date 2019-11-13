package ethos.model.content.dailytasks;

import java.util.HashMap;

import ethos.model.players.Player;
import ethos.util.Misc;
/*
 * This class handles 
 */
public class DailyChallengeHandler extends ChallengeTemplate {
	HashMap<Player, Challenge> playerChallenges = new HashMap<>();
	@Override
	public void generateChallenge(Player p) {
		// TODO Auto-generated method stub
		if(Misc.random(1, 10) >=5) {
			playerChallenges.put(p, new PVMChallenge(ChallengeDictonary.CHALLENGE_MODE.EASY, 1028, 100));
			((PVMChallenge) playerChallenges.get(p)).update();
			((PVMChallenge) playerChallenges.get(p)).toString();
		}
	}

	@Override
	void challengeUpdater(Player p) {
		// TODO Auto-generated method stub

	}

	@Override
	void challengeComplete(Player p) {
		// TODO Auto-generated method stub

	}

	@Override
	void generateChallenge(Player[] players) {
		// TODO Auto-generated method stub
		for(Player p : players) {
			if(Misc.random(1, 10) >=5) {
				playerChallenges.put(p, new PVMChallenge(ChallengeDictonary.CHALLENGE_MODE.EASY, 1028, 100));
				((PVMChallenge) playerChallenges.get(p)).update();
				((PVMChallenge) playerChallenges.get(p)).toString();
			}
		}
	}

	@Override
	void challengeUpdater(Player[] players) {
		// TODO Auto-generated method stub
		
	}

	@Override
	void challengeComplete(Player[] players) {
		// TODO Auto-generated method stub
		
	}

}
