package de.unistuttgart.iste.sqa.pse.sheet08.homework.olympics;

/**
 * Implements a Race Plan in which the the RunnerHamster runs hard.
 *
 * @author AmoreSchneyinck
 */
public final class SprinterRacePlan implements RacePlan {

	@Override
	public void nextStep(final RunnerHamster hamster) {
		hamster.runHard(); }
}
