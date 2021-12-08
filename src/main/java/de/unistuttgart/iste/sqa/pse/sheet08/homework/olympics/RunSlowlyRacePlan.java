package de.unistuttgart.iste.sqa.pse.sheet08.homework.olympics;

public final class RunSlowlyRacePlan implements RacePlan {

	@Override
	public void nextStep(final RunnerHamster hamster) {
		hamster.runSlowly();
	}

}
