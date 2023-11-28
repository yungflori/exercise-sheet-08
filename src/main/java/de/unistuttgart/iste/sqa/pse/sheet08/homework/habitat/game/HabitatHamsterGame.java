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


		// TODO Implement exercise 2 (c) here


		
		
		game.initialize(territoryBuilder);
		game.startGame();

		this.displayInNewGameWindow();
	}

	@Override
	protected void run() {
		
	}
}
