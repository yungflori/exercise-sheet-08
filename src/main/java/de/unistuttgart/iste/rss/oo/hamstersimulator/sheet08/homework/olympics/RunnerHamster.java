package de.unistuttgart.iste.rss.oo.hamstersimulator.sheet08.homework.olympics;

import de.unistuttgart.iste.rss.oo.hamstersimulator.datatypes.Direction;
import de.unistuttgart.iste.rss.oo.hamstersimulator.datatypes.Location;
import de.unistuttgart.iste.rss.oo.hamstersimulator.external.model.Hamster;
import de.unistuttgart.iste.rss.oo.hamstersimulator.external.model.Territory;

/**
 * This class represents a hamster that can take part in running events. It
 * provides all the necessary methods to navigate through a race course and
 * handles the energy management. Each hamster starts out with 20 energy points,
 * every move at more than slow speed costs some of these.
 */
public class RunnerHamster extends Hamster {
	// the strategies this runner follows during the race
	protected IRacePlan runningTactics;
	protected IFeedingStrategy feedingTactics;

	private int energyRemaining;
	private int stepsTaken;

	public RunnerHamster(final Territory territory, final Location location, final Direction direction) {
		super(territory, location, direction, 0);
		
		this.energyRemaining = 20;
		this.stepsTaken = 0;
		this.feedingTactics = new FeedNeverStrategy();
		this.runningTactics = new RunSlowlyRacePlan();
	}

	/**
	 * moves the hamster toward the finish line thrice at a cost of three energy
	 * points
	 */
	public void runHard() {
		energyRemaining -= 3;
		for (int i = 0; i < 3; i++) {
			moveForward();
		}
	}

	/*
	 * moves the hamster toward the finish line twice at a cost of a single energy
	 * point
	 */
	public void runSteadily() {
		energyRemaining -= 1;
		for (int i = 0; i < 2; i++) {
			moveForward();
		}
	}

	/*
	 * moves the hamster toward the finish line at no cost of energy
	 */
	public void runSlowly() {
		moveForward();
	}

	/*
	 * causes the hamster to make use of the food and trink at a feeding zone
	 * regenerating five energy points
	 */
	public void useFeedZone() {
		pickGrain();
		energyRemaining += 5;
	}

	/*
	 * returns the amount of energy points this hamster has
	 */
	public int getEnergyRemaining() {
		return this.energyRemaining;
	}

	/*
	 * returns whether or not this hamster has finished the race and finds himself
	 * in the finishers zone
	 */
	public boolean hasFinished() {
		return (getLocation().getRow() >= 10 && getLocation().getColumn() > 5 && getLocation().getColumn() < 10);
	}

	/*
	 * returns whether or not this hamster finds himself at a feeding zone
	 */
	public boolean isAtFeedZone() {
		return grainAvailable();
	}

	/*
	 * executes the next step in this hamster's race, according to his racing
	 * strategies
	 */
	public void executeStep() {
		if (isAtFeedZone() && feedingTactics.isFeedingRequired()) {
			useFeedZone();
		} else {
			runningTactics.nextStep(this);
		}
		this.stepsTaken++;
	}

	/*
	 * moves the hamster toward the finish line once
	 */
	private void moveForward() {
		if (!frontIsClear()) {
			turnLeft();
		}
		if (!frontIsClear()) {
			turnLeft();
			turnLeft();
		}
		move();
	}

	public void setRacePlan(IRacePlan tactics) {
		this.runningTactics = tactics;
	}

	public void setFeedingTactics(IFeedingStrategy tactics) {
		this.feedingTactics = tactics;
	}
	
	public int getStepsTaken() {
		return this.stepsTaken;
	}
}
