package de.unistuttgart.iste.sqa.pse.sheet08.homework.habitat.house;

import de.hamstersimulator.objectsfirst.datatypes.Location;

import java.util.Optional;

/**
 * A Wall in a {@link House}.
 * <p>
 * Every wall consist of a start and end location, both are inclusive, i.e. the start and the end location are part of the wall.
 * The start location must be closer to the territories origin (the upper left corner) than the end location.
 * In addition, the start and end location must be in line, i.e. for a horizontal wall, they must be in the same row,
 * and for a vertical wall, they must be in the same column.
 *
 * <p>
 * A Wall must at least be two tiles long, i.e. start and end must not be the same location.
 *
 * <p>
 * Some walls also have a door.
 * If a wall has a door, the door must be located in between start and end.
 * The door must not be at the very start or end at the wall.
 *
 */
public final class Wall {
    private final Location start;
    private final Location end;

    private final Optional<Location> door;

    /*@
    @ requires start != null;
    @ requires end != null;
    @ requires door != null;
    @*/
    /**
     * Constructs a new wall, which may or may not have a door.
     *
     * @param start location of the wall's first part
     * @param end location of the wall's last part
     * @param door location of the wall's door.
     */
    public Wall(final Location start, final Location end, final Optional<Location> door) {
    	// TODO implement exercise 2 (a) here. 
    	
    	
        this.start = start;
        this.end = end;
        this.door = door;
    }
    
    

    /**
     * Get the first tile of the wall.
     *
     * @return the first tile of the wall.
     */
    public Location getStart() {
        return start;
    }

    /**
     * Get the last tile of the wall.
     *
     * @return the last tile of the wall.
     */
    public Location getEnd() {
        return end;
    }

    /**
     * Get the door of the wall.
     *
     * @return the door of the wall.
     */
    public Optional<Location> getDoor() {
        return door;
    }

    /**
     * Checks if the wall is vertical.
     *
     * @return true if the wall is vertical, false otherwise.
     */
    public boolean isVertical() {
        return start.getColumn() == end.getColumn();
    }

    /**
     * Checks if the wall is horizontal.
     *
     * @return true if the wall is horizontal, false otherwise.
     */
    public boolean isHorizontal() {
        return start.getRow() == end.getRow();
    }
}
