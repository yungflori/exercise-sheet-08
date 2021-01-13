package de.unistuttgart.iste.rss.oo.hamstersimulator.sheet08.homework.olympics;

public class RunSlowlyRacePlan implements RacePlan {

	@Override
	public void nextStep(RunnerHamster hamster) {
		hamster.runSlowly();
	}

}
