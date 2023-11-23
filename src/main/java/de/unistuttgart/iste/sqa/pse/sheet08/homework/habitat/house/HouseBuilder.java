package de.unistuttgart.iste.sqa.pse.sheet08.homework.habitat.house;

import de.hamstersimulator.objectsfirst.datatypes.Location;
import de.hamstersimulator.objectsfirst.external.model.Territory;
import de.hamstersimulator.objectsfirst.external.model.TerritoryBuilder;

import java.util.HashSet;
import java.util.Set;

/**
 * This class is like the building company that builds the house. At first, all
 * the parts of the house are specified and the house is built by placing walls
 * on the territory's tiles. This class uses the {@link TerritoryBuilder} to
 * place the walls on the territory.
 */
public final class HouseBuilder {

	private final Set<HouseWall> walls;

	private final TerritoryBuilder territoryBuilder;
	private final Territory territory;

	/**
	 * Creates a new HouseBuilder.
	 *
	 * @param territoryBuilder Builder of the territory, required to place the
	 *                         walls.
	 * @param territory        The territory itself, required to check it the house
	 *                         to be build is valid.
	 */
	public HouseBuilder(final TerritoryBuilder territoryBuilder, final Territory territory) {
		this.territoryBuilder = territoryBuilder;
		this.territory = territory;

		this.walls = new HashSet<>();
	}

	/**
	 * Adds a new wall to the house that will be built.
	 *
	 * @param housewall the new wall.
	 * @return The builder for chaining.
	 */
	public HouseBuilder withWall(final HouseWall housewall) {
		if (this.wallsOverlap(housewall)) {
			throw new IllegalArgumentException("New wall overlaps with existing wall.");
		}
		this.walls.add(housewall);
		return this;
	}

	/**
	 * Creates the house with the specified walls by placing walls on the
	 * territory's tiles. There must be at least one wall specified.
	 *
	 * @return The house, that is now also visible on the territory.
	 */
	public House build() {
		if (walls.isEmpty()) {
			throw new IllegalStateException("No walls specified.");
		}
        for (HouseWall wall: walls) {
            if (this.wallIsBlockedOnTerritory(wall)) {
            	throw new IllegalStateException("Location on Territory is blocked, cannot build house.");
            }
        }
		for (HouseWall wall : walls) {
			buildWall(wall);
		}
		return new House(walls);
	}

	/**
	 * Create a single housewall by placing walls on the territory's tiles.
	 *
	 * @param housewall the wall to be put on the territory.
	 */
	private void buildWall(final HouseWall housewall) {
		// TODO implement exercise 2 (d) here.
	}

	/**
	 * Check whether the new housewall overlaps with any of the already planned
	 * housewalls or with anything that is already placed on the territory.
	 *
	 * @param newWall the new housewall.
	 * @return true if the new housewall overlaps with anything.
	 */
	private boolean wallsOverlap(final HouseWall newWall) {
		for (HouseWall wall : walls) {
			if (wall.overlapsWith(wall)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks whether any of the tiles that the housewall would cover are already blocked
	 * on the territory, e.g. by a grain, a hamster or another wall.
	 *
	 * @param wall the new wall.
	 * @return true if the wall would cover a blocked tile, false otherwise.
	 */
	private boolean wallIsBlockedOnTerritory(final HouseWall wall) {
		if (wall.isVertical()) {
			for (int i = wall.getStart().getRow(); i < wall.getEnd().getRow(); i++) {
				if (!territory.isFree(Location.from(i, wall.getStart().getColumn()))) {
					return true;
				}
			}
		} else {
			for (int i = wall.getStart().getColumn(); i < wall.getEnd().getColumn(); i++) {
				if (!territory.isFree(Location.from(wall.getStart().getRow(), i))) {
					return true;
				}
			}
		}
		return false;
	}
}
