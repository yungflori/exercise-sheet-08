package de.unistuttgart.iste.sqa.pse.sheet08.homework.habitat.house;

import de.hamstersimulator.objectsfirst.datatypes.Location;
import de.hamstersimulator.objectsfirst.external.model.Territory;
import de.hamstersimulator.objectsfirst.external.model.TerritoryBuilder;

import java.util.HashSet;
import java.util.Set;

/**
 * This class is like the building company that builds the house.
 * At first, all the parts of the house are specified and the house is built by placing walls on the territory's tiles.
 * This class uses the {@link TerritoryBuilder} to place the walls on the territory.
 */
public final class HouseBuilder {

    private final Set<Wall> walls;

    private final TerritoryBuilder territoryBuilder;
    private final Territory territory;

    /**
     * Creates a new HouseBuilder.
     *
     * @param territoryBuilder Builder of the territory, required to place the walls.
     * @param territory The territory itself, required to check it the house to be build is valid.
     */
    public HouseBuilder(final TerritoryBuilder territoryBuilder, final Territory territory) {
        this.territoryBuilder = territoryBuilder;
        this.territory = territory;

        this.walls = new HashSet<>();
    }

    /**
     * Adds a new wall to the house that will be built.
     *
     * @param wall the new wall.
     * @return The builder for chaining.
     */
    public HouseBuilder withWall(final Wall wall) {
        if (this.wallsOverlap(wall)) {
            throw new IllegalArgumentException("New wall overlaps with existing wall.");
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
        for (Wall wall: walls) {
            buildWall(wall);
        }
        return new House(walls);
    }

    /**
     * Create a single wall by placing walls on the territory's tiles.
     *
     * @param wall the wall to be put on the territory.
     */
    private void buildWall(final Wall wall) {
    	// TODO implement exercise 2 (c) here.
    }

    /**
     * Check whether the new wall overlaps with any of the already planned walls or with anything that is already placed on the territory.
     *
     * @param newWall the new wall.
     * @return true if the new wall overlaps with anything.
     */
    private boolean wallsOverlap(final Wall newWall) {
        for (Wall wall: walls) {
            if (this.wallIsBlockedOnTerritory(newWall)) {
                return true;
            } else if (wall.isVertical() && newWall.isVertical() && this.verticalWallsOverlap(wall, newWall)) {
                return true;
            } else if (wall.isHorizontal() && newWall.isHorizontal() && this.horizontalWallsOverlap(wall, newWall)) {
                return true;
            } else if (wall.isHorizontal() && newWall.isVertical() && this.intersectionWallsOverlap(wall, newWall)) {
                return true;
            } else if (this.intersectionWallsOverlap(newWall, wall)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks whether any of the tiles that the wall would cover is already blocked on the territory, e.g. by a grain, a hamster or another wall.
     *
     * @param wall the new wall.
     * @return true if the wall would cover a blocked tile, false otherwise.
     */
    private boolean wallIsBlockedOnTerritory(final Wall wall) {
        if (wall.isVertical()) {
            for (int i = wall.getStart().getRow(); i < wall.getEnd().getRow() ; i++) {
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

    /**
     * Checks whether a planned vertical wall overlaps with another planned vertical wall.
     * 
     * @param wall a vertical wall
     * @param otherWall anoter vertical wall
     * @return true if the walls overlap, false otherwise.
     */
    private boolean verticalWallsOverlap(final Wall wall, final Wall otherWall) {
        if(wall.getStart().getColumn() != otherWall.getStart().getColumn()){ // not in the same column -> no overlap
            return false;
        }
        if (wall.getStart().getRow() >= otherWall.getStart().getRow() && wall.getStart().getRow() <= otherWall.getEnd().getRow()) {
            return true;
        }
        if (wall.getEnd().getRow() >= otherWall.getStart().getRow() && wall.getEnd().getRow() <= otherWall.getStart().getRow()) {
            return true;
        }
        return false;
    }

    /**
     * Checks whether a planned horizontal wall overlaps with another planned horizontal wall.
     *
     * @param wall a horizontal wall
     * @param otherWall another horizontal wall
     * @return true if the walls overlap, false otherwise.
     */
    private boolean horizontalWallsOverlap(final Wall wall, final Wall otherWall) {
        if(wall.getStart().getRow() != otherWall.getStart().getRow()){ // not in the same row -> no overlap
            return false;
        }
        if (wall.getStart().getColumn() >= otherWall.getStart().getColumn() && wall.getStart().getColumn() <= otherWall.getEnd().getColumn()) {
            return true;
        }
        if (wall.getEnd().getColumn() >= otherWall.getStart().getColumn() && wall.getEnd().getColumn() <= otherWall.getStart().getColumn()) {
            return true;
        }
        return false;
    }

    /**
     * Checks whether a planned horizontal wall overlaps with a planned vertical wall.
     * 
     * @param horizontalWall a horizontal wall
     * @param verticalWall a vertical wall
     * @return true if the walls overlap, false otherwise.
     */
    private boolean intersectionWallsOverlap(final Wall horizontalWall, final Wall verticalWall) {
        assert horizontalWall.isHorizontal() && verticalWall.isVertical();

        for (int i = horizontalWall.getStart().getColumn(); i <= horizontalWall.getEnd().getColumn(); i++) {
            Location horizontalLoc = Location.from(horizontalWall.getStart().getRow(), i);

            for(int j = verticalWall.getStart().getRow(); j <= verticalWall.getEnd().getRow(); j++) {
                Location verticalLoc = Location.from(j, verticalWall.getStart().getColumn());
                if (verticalLoc.equals(horizontalLoc)) {
                    return true;
                }
            }
        }
        return false;
    }

}

