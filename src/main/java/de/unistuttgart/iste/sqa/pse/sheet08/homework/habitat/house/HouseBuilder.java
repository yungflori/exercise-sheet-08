package de.unistuttgart.iste.sqa.pse.sheet08.homework.habitat.house;

import de.hamstersimulator.objectsfirst.datatypes.Location;
import de.hamstersimulator.objectsfirst.external.model.Territory;
import de.hamstersimulator.objectsfirst.external.model.TerritoryBuilder;

import java.util.HashSet;
import java.util.Set;

/**
 * This class is like the building company that builds the house.
 * At first, all the parts of the house are specified and the house is built by placing walls on the territory's tiles.
 * <p>
 * Invariants for this class are, that none of the attributes are null and that the set of walls does not contain any null elements.
 */
public final class HouseBuilder {

    private final Set<HouseWall> walls;

    private final TerritoryBuilder territoryBuilder;
    private final Territory territory;

    /**
     * Creates a new HouseBuilder.
     * <p>
     * Requires that neither of the parameters is null.
     *
     * @param territoryBuilder Builder of the territory, required to place the walls.
     * @param territory        The territory itself, required to check it the house to be build is valid.
     */
    public HouseBuilder(final TerritoryBuilder territoryBuilder, final Territory territory) {
        if (territoryBuilder == null || territory == null) {
            throw new IllegalArgumentException("Neither Territory nor Builder may be null, but one of them is.");
        }
        this.territoryBuilder = territoryBuilder;
        this.territory = territory;

        this.walls = new HashSet<>();
    }

    /**
     * Adds a new wall to the house that will be built.
     * <p>
     * Requires, that the new wall is not null and that it does not overlap with any of the already planned walls.
     *
     * @param wall the new wall.
     * @return The builder for chaining.
     */
    public HouseBuilder withWall(final HouseWall wall) {
        if (wall == null) {
            throw new IllegalArgumentException("New house wall must not be null.");
        }
        if (this.wallsOverlap(wall)) {
            throw new IllegalArgumentException("New house wall overlaps with existing house wall.");
        }
        this.walls.add(wall);
        return this;
    }


    /**
     * Creates the house with the specified walls by placing walls on the territory's tiles.
     * There must be at least one wall specified.
     *
     * @return The house, that is now also visible on the territory.
     */
    public House build() {
        if (walls.isEmpty()) {
            throw new IllegalStateException("No walls specified.");
        }
        for (HouseWall wall : walls) {
            if (this.isTileOfWallBlockedOnTerritory(wall)) {
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
     * <p>
     * Requires that the housewall is not null.
     *
     * @param wall the housewall to be put on the territory.
     */
    private void buildWall(final HouseWall wall) {
		// TODO implement exercise 2 (d) here.
    }

    /**
     * Check whether the new wall overlaps with any of the already planned walls or with anything that is already placed on the territory.
     * <p>
     * Requires that the new wall is not null.
     *
     * @param newWall the new wall.
     * @return true if the new wall overlaps with anything.
     */
    private boolean wallsOverlap(final HouseWall newWall) {
        assert newWall != null;
        for (HouseWall wall : walls) {
            if (wall.overlapsWith(wall)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks whether any of the tiles that the housewall would cover is already blocked
     * on the territory.
     * <p>
     * Requires that wall is not null.
     *
     * @param wall the new wall.
     * @return true if the wall would cover a blocked tile, false otherwise.
     */
    private boolean isTileOfWallBlockedOnTerritory(final HouseWall wall) {
        assert wall != null;
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
