package de.unistuttgart.iste.sqa.pse.sheet08.homework.olympics;

/**
 * Implements a strategy where the Hamster eats twice
 *
 * @author AmoresSchneyick
 */
public final class FeedTwiceStrategy implements FeedingStrategy {
	// if required, put attributes for task (d) here
	int timesFed = 0;
	@Override
	public boolean isFeedingRequired() {
		// put code for task (d) here
		if ((timesFed<2)) {
			while (timesFed<2){
				timesFed++;}
			return true;
		}
		else {
			return false;
		}
	}
}
