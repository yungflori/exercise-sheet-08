package de.unistuttgart.iste.sqa.pse.sheet08.homework.olympics;

/**
 * Implements a Race Plan in which the the RunnerHamster runs steadily.
 *
 * @author AmoresSchneiynck
 */
public final class RunSteadilyRacePlan implements RacePlan {
	@Override
	public void nextStep(final RunnerHamster hamster) {
		FeedingStrategy feedingStrategy = new FeedOnceStrategy();
		if (feedingStrategy.isFeedingRequired()&&(hamster.isAtFeedZone())&&(hamster.getEnergyRemaining()<20)){
			hamster.useFeedZone();
		}
		else if (hamster.getEnergyRemaining()>=1) {
			hamster.runSteadily();
		}
	}
}
