package de.unistuttgart.iste.sqa.pse.sheet08.homework.habitat.game;

import de.hamstersimulator.objectsfirst.external.model.TerritoryBuilder;
import de.hamstersimulator.objectsfirst.external.simple.game.SimpleHamsterGame;
import de.unistuttgart.iste.sqa.pse.sheet08.homework.habitat.house.House;

/**
 * The habitat hamster game.
 */
public final class HabitatHamsterGame extends SimpleHamsterGame {

	private House house;

	public HabitatHamsterGame() {
		this.loadTerritoryFromResourceFile("/territories/habitatTerritory.ter");

		TerritoryBuilder territoryBuilder = game.getNewTerritoryBuilder();

		// TODO Implement exercise 2 (d) between here...

		// ...and here. Do NOT put any code after here.

		game.initialize(territoryBuilder);
		game.startGame();

		this.displayInNewGameWindow();
	}

	@Override
	protected void run() {
		turnRight();
		multiMove(7);
		paule.turnLeft();
		multiMove(11);
		paule.turnLeft();
		multiMove(3);
		checkDoor();

		multiMove(3);
		paule.turnLeft();
		multiMove(3);
		turnRight();
		paule.move();
		paule.turnLeft();
		multiMove(5);
		checkDoor();
		multiMove(3);

		paule.write("Wuhu, i ran around my house!");
	}

	/**
	 * Paule turns to the right.
	 */
	private void turnRight() {
		paule.turnLeft();
		paule.turnLeft();
		paule.turnLeft();
	}

	/**
	 * Paule checks whether he's standing next to a door.
	 *
	 * Ensure, that paule looks into the initial direction.
	 */
	private void checkDoor() {
		paule.turnLeft();
		if (!paule.frontIsClear()) {
			throw new IllegalStateException("Door is blocked!!");
		}
		turnRight();
	}

	/**
	 * Paule move the given number of steps.
	 *
	 * Requires, that {@code numberOfSteps} in front of paule are clear.
	 *
	 * @param numberOfSteps number of steps to move
	 */
	private void multiMove(int numberOfSteps) {
		/*@
		@ loop_invariant paule moved i steps
		@ decreasing numberOfSteps - i
		@*/
		for (int i = 0; i < numberOfSteps; i++) {
			paule.move();
		}
	}
}
