package de.unistuttgart.iste.rss.oo.hamstersimulator.sheet08.homework.olympics;

public interface RacePlan {
	
	/**
	 * executes the next movement of the given hamster according to this race plan
	 * @param hamster the hamster that executed this race plan
	 */
	public void nextStep(RunnerHamster hamster);
}
