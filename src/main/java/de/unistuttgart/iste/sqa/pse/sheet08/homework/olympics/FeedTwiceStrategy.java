package de.unistuttgart.iste.sqa.pse.sheet08.homework.olympics;

/**
 * Implements a strategy where the Hamster eats twice
 *
 * @author AmoresSchneyick
 */
public final class FeedTwiceStrategy implements FeedingStrategy {
	// if required, put attributes for task (d) here
	RunnerHamster hamster;
	// if required, put attributes for task (d) here
	@Override
	public boolean isFeedingRequired() {
		// put code for task (d) here
		if (hamster.isAtFeedZone() && (hamster.getEnergyRemaining() <= 20)) {
			hamster.useFeedZone();
			hamster.useFeedZone();
			return true;
		} else if (!hamster.isAtFeedZone() || !(hamster.getEnergyRemaining() <= 20)) {
			return false;
		} else {
			return false;
		}
	}
}
