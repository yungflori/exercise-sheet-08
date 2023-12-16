package de.unistuttgart.iste.sqa.pse.sheet08.homework.olympics;

/**
 * Implements a strategy where the Hamster eats once
 *
 * @author AmoresSchneyinck
 */
public final class FeedOnceStrategy implements FeedingStrategy {
	int timesFed = 0;
	// if required, put attributes for task (d) here
	@Override
	public boolean isFeedingRequired() {
		// put code for task (d) here
        if ((timesFed<1)) {
			while (timesFed<1){
			timesFed++;}
			return true;
        }
		else {
			return false;
		}
    }
}
