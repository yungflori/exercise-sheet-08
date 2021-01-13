package de.unistuttgart.iste.rss.oo.hamstersimulator.sheet08.presence.hamster;

import de.unistuttgart.iste.rss.oo.hamstersimulator.datatypes.Direction;
import de.unistuttgart.iste.rss.oo.hamstersimulator.datatypes.Location;
import de.unistuttgart.iste.rss.oo.hamstersimulator.external.model.SimpleHamsterGame;


/**
 * A SimpleHamsterGame with GreatPaule
 */
public class MyGreatHamsterGame extends SimpleHamsterGame {
	
	public MyGreatHamsterGame() {
		this.loadTerritoryFromResourceFile("/territories/territory.ter");
		this.displayInNewGameWindow();
		game.startGame();
	}
	
	@Override
	protected void run() {
		Location greatPauleLocation = new Location(2, 1);
		MyGreatHamster greatPaule = new MyGreatHamster(game.getTerritory(), greatPauleLocation, Direction.EAST, 0);
		
		greatPaule.multiMove(5);
		greatPaule.turnRight();
		greatPaule.multiMove(4);
		greatPaule.pickAllGrains();
		greatPaule.turnRight();
		greatPaule.multiMove(3);
		greatPaule.turnRight();
		greatPaule.multiMove(1);
		greatPaule.pickAllGrains();
		greatPaule.multiMove(2);
		greatPaule.turnRight();
		greatPaule.multiMove(1);
		greatPaule.pickAllGrains();
		greatPaule.turnRight();
	}
}
