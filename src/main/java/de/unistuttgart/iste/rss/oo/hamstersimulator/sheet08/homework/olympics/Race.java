package de.unistuttgart.iste.rss.oo.hamstersimulator.sheet08.homework.olympics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * this class represents a race of RunnerHamsters
 * call executeRace() to run the race from start to finish
 *
 */
public class Race {

	private final List<RunnerHamster> runners;
	private final List<RunnerHamster> finishers;
	
	public Race(List<RunnerHamster> competitors) {
		this.runners = competitors;
		finishers = new ArrayList<RunnerHamster>();
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
			currentRunner.executeStep();
			
			if(currentRunner.hasFinished()) {
				it.remove();
				finishers.add(currentRunner);
				currentRunner.write("Ich habe " + currentRunner.getStepsTaken() + " Aktionen gebraucht!");
			}
			
		}
	}
}
