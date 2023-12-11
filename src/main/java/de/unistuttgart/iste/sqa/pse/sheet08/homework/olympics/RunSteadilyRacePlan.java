package de.unistuttgart.iste.sqa.pse.sheet08.homework.olympics;

/**
 * Implements a Race Plan in which the the RunnerHamster runs steadily.
 *
 * @author AmoresSchneiynck
 */
public final class RunSteadilyRacePlan implements RacePlan {
	@Override
	public void nextStep(final RunnerHamster hamster) {
		hamster.runSteadily(); }
}
