package de.unistuttgart.iste.sqa.pse.sheet08.homework.olympics;

/**
 * Implements a strategy where the Hamster eats once
 *
 * @author AmoresSchneyinck
 */
public final class FeedOnceStrategy implements FeedingStrategy {
	RunnerHamster hamster;
	// if required, put attributes for task (d) here
	@Override
	public boolean isFeedingRequired() {
		// put code for task (d) here
        if (hamster.isAtFeedZone() && (hamster.getEnergyRemaining() <= 20)) {
            hamster.useFeedZone();
			return true;
        } else if (!hamster.isAtFeedZone() || !(hamster.getEnergyRemaining() <= 20)) {
			return false;
		} else {
			return false;
		}
    }
}
