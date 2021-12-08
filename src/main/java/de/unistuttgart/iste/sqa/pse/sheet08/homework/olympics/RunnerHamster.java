package de.unistuttgart.iste.sqa.pse.sheet08.homework.olympics;

import de.hamstersimulator.objectsfirst.datatypes.Direction;
import de.hamstersimulator.objectsfirst.datatypes.Location;
import de.hamstersimulator.objectsfirst.external.model.Hamster;
import de.hamstersimulator.objectsfirst.external.model.Territory;

/**
 * This class represents a hamster that can take part in running events. It
 * provides all the necessary methods to navigate through a race course and
 * handles the energy management. Each hamster starts out with 20 energy points,
 * every move at more than slow speed costs some of these.
 */
public final class RunnerHamster extends Hamster {
	// the strategies this runner follows during the race
	protected RacePlan runningTactic;
	protected FeedingStrategy feedingTactic;

	private int energyRemaining;
	private int actionsTaken;

	public RunnerHamster(final Territory territory, final Location location, final Direction direction) {
		super(territory, location, direction, 0);
		
		this.energyRemaining = 20;
		this.actionsTaken = 0;
		this.feedingTactic = new FeedNeverStrategy();
		this.runningTactic = new RunSlowlyRacePlan();
	}

	/**
	 * Moves the hamster toward the finish line thrice at a cost of three energy
	 * points
	 * This method requires the hamster to still have at least three energy points.
	 * It ensures that the hamster moves and turns in such a way that after execution it is three tiles 
	 * closer to the finish line on any given valid race course.
	 * The hamster also gets deducted three energy points.
	 */
	public void runHard() {
		if(energyRemaining < 3)
			throw new IllegalStateException("There are not enough energy points left to do this.");
		energyRemaining -= 3;
		/*@
		@  loop_invariant moves forward i times
		@  @decreasing 3 - i
		@*/
		for (int i = 0; i < 3; i++) {
			moveForward();
		}
	}

	/**
	 * Moves the hamster toward the finish line twice at a cost of a single energy
	 * point.
	 * This method requires the hamster to still have at least one energy point.
	 * It ensures that the hamster moves and turns in such a way that after execution it is two tiles 
	 * closer to the finish line on any given valid race course.
	 * The hamster also gets deducted an energy point.
	 */
	public void runSteadily() {
		if(energyRemaining < 1) {
			throw new IllegalStateException("There are not enough energy points left to do this.");
		}
		energyRemaining -= 1;
		/*@
		@  loop_invariant moves forward i times
		@  @decreasing 2 - i
		@*/
		for (int i = 0; i < 2; i++) {
			moveForward();
		}
	}

	/**
	 * Moves the hamster toward the finish line at no cost of energy
	 * This method ensures that the hamster moves and turns in such a way that after execution  it is one tile 
	 * closer to the finish line on any given valid race course.
	 */
	public void runSlowly() {
		moveForward();
	}

	/**
	 * Causes the hamster to make use of the food and drink at a feeding zone
	 * regenerating five energy points
	 * This method requires the hamster to be situated on a feeding zone (check by calling isAtFeedingZone()
	 * beforehand).
	 * It ensures that the hamster picks up a grain and has an additional five energy points afer execution.
	 */
	public void useFeedZone() {
		if(!grainAvailable()) {
			throw new IllegalStateException("You are not standing at a feed zone!");
		}
		pickGrain();
		energyRemaining += 5;
	}


	/**
	 * Returns the amount of energy points this hamster has left at the moment.
	 */
	public int getEnergyRemaining() {
		return this.energyRemaining;
	}

	/**
	 * Returns whether or not this hamster has finished the race and finds himself
	 * in the finishers zone
	 */
	public boolean hasFinished() {
		return (getLocation().getRow() >= 10 && getLocation().getColumn() > 5 && getLocation().getColumn() < 10);
	}

	/**
	 * Returns whether or not this hamster is situated on a feeding zone
	 */
	public boolean isAtFeedZone() {
		return grainAvailable();
	}
	
	/**
	 * Executes the next action in this hamster's race, according to his racing
	 * strategies, either using a feed zone or running on
	 * This method requires both feedingTactic and runningTactic to be initialized.
	 * It ensures that the hamster executes the next Step of either feedingTactic
	 * or runningTactic and increments the actionsTaken counter.
	 */
	public void executeNextAction() {
		if (isAtFeedZone() && feedingTactic.isFeedingRequired()) {
			useFeedZone();
		} else {
			runningTactic.nextStep(this);
		}
		this.actionsTaken++;
	}

	/**
	 * Moves the hamster toward the finish line once
	 * This method ensures that the hamster turns and moves in such a way that the hamster
	 * is exactly one tile closer to the finish line after execution.
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

	/**
	 * Sets this hamsters RacePlan to tactics
	 * @param tactics the new RacePlan
	 */
	public void setRacePlan(final RacePlan tactics) {
		this.runningTactic = tactics;
	}


	/**
	 * Sets this hamsters FeedingStrategy to tactics
	 * @param tactics the new FeedingStrategy
	 */
	public void setFeedingTactics(final FeedingStrategy tactics) {
		this.feedingTactic = tactics;
	}
	
	/**
	 * Returns the amount of times executeNextAction() has been called on this hamster
	 */
	public int getActionsTaken() {
		return this.actionsTaken;
	}
}
