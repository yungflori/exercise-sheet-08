package de.unistuttgart.iste.sqa.pse.sheet08.homework.olympics;

public interface FeedingStrategy {

	/**
	 * returns whether or not the current feeding zone a hamster is situated on should be used.
	 * Only call this method while the hamster is on a feeding zone!
	 * @return true if the hamster should use the feeding zone
	 */
	boolean isFeedingRequired();
}
