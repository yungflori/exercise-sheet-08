package de.unistuttgart.iste.rss.oo.hamstersimulator.sheet08.homework.olympics;

public interface IFeedingStrategy {

	/**
	 * returns whether or not the current feeding zone a hamster is situated on should be used.
	 * only call this method while the hamster is on a feeding zone!
	 * @return boolean, true if the hamster should use the feeding zone, false if not
	 */
	public boolean isFeedingRequired();
}
