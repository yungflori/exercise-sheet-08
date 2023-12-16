package de.unistuttgart.iste.sqa.pse.sheet08.homework.olympics;

/**
 * Implements a Race Plan in which the the RunnerHamster runs hard.
 *
 * @author AmoreSchneyinck
 */
public final class SprinterRacePlan implements RacePlan {
	@Override
	public void nextStep(final RunnerHamster hamster) {
		FeedingStrategy feedingStrategy = new FeedTwiceStrategy();
		if (feedingStrategy.isFeedingRequired()&&(hamster.isAtFeedZone()&&(hamster.getEnergyRemaining()<20))){
			hamster.useFeedZone();
		}
		else if (hamster.getEnergyRemaining()>=3) {
			hamster.runHard();
		}
	}
}
