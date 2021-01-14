package de.unistuttgart.iste.rss.oo.hamstersimulator.sheet08.homework.olympics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import de.unistuttgart.iste.rss.oo.hamstersimulator.datatypes.Location;

/**
 * this class represents a race of RunnerHamsters
 * call executeRace() to run the race from start to finish
 *
 */
public class Race {

	private final List<RunnerHamster> runners;
	private final List<RunnerHamster> finishers;
	private final List<RunnerHamster> didNotFinishRunners;
	
	private final Location startLocation = new Location(1,1);
	
	public Race(List<RunnerHamster> competitors) {
		this.runners = competitors;
		finishers = new ArrayList<RunnerHamster>();
		didNotFinishRunners = new ArrayList<RunnerHamster>();
	}
	
	/**
	 * runs the entire race. Each competitor gets to take a single action one ofter the other until
	 * everyone has crossed the finish line
	 */
	public void executeRace() {
		while(!runners.isEmpty()) {
			executeStep();
		}
	}
	
	/*
	 * runs a single time step of the race, consisting of one round of steps from each of the competitors
	 * that are still on the course
	 */
	private void executeStep() {
		Iterator<RunnerHamster> it = runners.iterator();
		while(it.hasNext()) {
			RunnerHamster currentRunner = it.next();
			currentRunner.executeNextAction();
			
			if(currentRunner.hasFinished()) {
				it.remove();
				finishers.add(currentRunner);
				currentRunner.write("Ich habe " + currentRunner.getActionsTaken() + " Aktionen gebraucht!");
			}
			if(currentRunner.getLocation().equals(startLocation)) {
				it.remove();
				didNotFinishRunners.add(currentRunner);
				currentRunner.write("Ich habe es leider nicht bis ins Ziel geschafft.");
			}
			
		}
	}
}
