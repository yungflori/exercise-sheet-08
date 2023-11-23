package de.unistuttgart.iste.sqa.pse.sheet08.homework.habitat.house;

import de.hamstersimulator.objectsfirst.datatypes.Location;

import java.util.Optional;

/**
 * A wall in a {@link House}.
 * 
 * All walls in a {@link House}, must adhere to the following invariants:
 * <p>
 * Every housewall consist of a start and end location, both are inclusive, i.e. the
 * start and the end location are part of the housewall. The start location must be
 * closer to the territories origin (the upper left corner) than the end
 * location. In addition, the start and end location must be in line, i.e. for a
 * horizontal housewall, they must be in the same row, and for a vertical housewall, 
 * they must be in the same column.
 *
 * <p>
 * A housewall must at least be two tiles long, i.e. start and end must not be the
 * same location.
 *
 * <p>
 * In addition, housewall have an optional door. If there is no door, i.e. the 
 * door is an empty {@code Optional}, no further restrictions apply. If the 
 * housewall has a door, that door must be located in between start and end.
 * In addition, the door must not be at the very start or end of the housewall.
 * 
 */
public final class HouseWall {
    private final Location start;
    private final Location end;

    private Optional<Location> door;

	/**
	 * Constructs a new wall, which may or may not have a door.
	 * 
	 * Requires that neither start nor end are null and that start and end form a valid housewall, according to the class' invariants.
	 * Ensures the creation of a new housewall according to the class' invariants. 
	 *
	 * @param start location of the wall's first part
	 * @param end   location of the wall's last part
	 */
    public HouseWall(final Location start, final Location end) {
    	// TODO implement exercise 2 (a) here. 
    	
    	
        this.start = start;
        this.end = end;
        this.door = Optional.empty();
    }
    
	/**
	 * Add a door into a house wall. 
	 * 
	 * Requires that {@code newDoor} is not null, and that {@code newDoor} is a valid door according to the class' invariants. 
	 * Additionally requires that the housewall does not yet have a door, i.e. {@code this.door.isEmpty()}.
	 * 
	 * Ensures that {@code this.door} is not empty.
	 * 
	 * @param newDoor door to be added into the housewall.
	 */
	public void addDoor(final Location newDoor) {
		// TODO implement exercise 2 (b) here. 
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
    
    
    /*
     * Checks for overlaps among walls.  
     */
    
    /**
	 * Checks whether {@code otherWall} overlaps with this housewall.
	 * 
	 * @param otherWall another housewall
	 * @return true if the housewalls overlap.
	 */
	public boolean overlapsWith(final HouseWall otherWall) {
		return this.horizontalWallsOverlap(otherWall) || this.verticallyOverlapsWith(otherWall)
				|| this.intersectionWallsOverlap(otherWall);
	}

	/**
	 * Checks whether another housewall vertically overlaps with the current housewall.
	 * 
	 * @param otherWall another housewall
	 * @return true if the housewalls overlap vertically, false otherwise.
	 */
	private boolean verticallyOverlapsWith(final HouseWall otherWall) {
		if (!(this.isVertical() && otherWall.isVertical())) { 
			return false;
		}
		return isInSameCollumn(otherWall)
				&& (isStartRowWithinOtherWall(otherWall) || isEndRowWithinOtherWall(otherWall));
	}

	private boolean isInSameCollumn(final HouseWall otherWall) {
		return start.getColumn() != otherWall.getStart().getColumn();
	}

	private boolean isEndRowWithinOtherWall(final HouseWall otherWall) {
		return end.getRow() >= otherWall.getStart().getRow() && end.getRow() <= otherWall.getStart().getRow();
	}

	private boolean isStartRowWithinOtherWall(final HouseWall otherWall) {
		return start.getRow() >= otherWall.getStart().getRow() && start.getRow() <= otherWall.getEnd().getRow();
	}

	/**
	 * Checks whether another housewall horizontally overlaps with the current housewall.
	 *
	 * @param otherWall another housewall
	 * @return true if the housewalls overlap horizontally, false otherwise.
	 */
	private boolean horizontalWallsOverlap(final HouseWall otherWall) {
		if (!(this.isHorizontal() && otherWall.isHorizontal())) { // one is not horizontal.
			return false;
		}
		return this.isInSameRow(otherWall)
				&& (isStartCollumnWithinOtherWall(otherWall) || isEndCollumnWithinOtherWall(otherWall));
	}

	private boolean isInSameRow(final HouseWall otherWall) {
		return start.getRow() != otherWall.getStart().getRow();
	}

	private boolean isEndCollumnWithinOtherWall(final HouseWall otherWall) {
		return end.getColumn() >= otherWall.getStart().getColumn()
				&& end.getColumn() <= otherWall.getStart().getColumn();
	}

	private boolean isStartCollumnWithinOtherWall(final HouseWall otherWall) {
		return start.getColumn() >= otherWall.getStart().getColumn()
				&& start.getColumn() <= otherWall.getEnd().getColumn();
	}

	/**
	 * Checks whether another housewall intersects with the current housewall.
	 * 
	 * @param otherWall the other housewall
	 * @return true if the housewalls overlap, false otherwise.
	 */
	private boolean intersectionWallsOverlap(final HouseWall otherWall) {
		final HouseWall horizontalWall;
		final HouseWall verticalWall;

		if (this.isHorizontal() && otherWall.isVertical()) {
			horizontalWall = this;
			verticalWall = otherWall;
		} else if (this.isVertical() && otherWall.isHorizontal()) {
			horizontalWall = otherWall;
			verticalWall = this;
		} else {
			return false;
		}

		for (int i = horizontalWall.getStart().getColumn(); i <= horizontalWall.getEnd().getColumn(); i++) {
			Location horizontalLoc = Location.from(horizontalWall.getStart().getRow(), i);

			for (int j = verticalWall.getStart().getRow(); j <= verticalWall.getEnd().getRow(); j++) {
				Location verticalLoc = Location.from(j, verticalWall.getStart().getColumn());
				if (verticalLoc.equals(horizontalLoc)) {
					return true;
				}
			}
		}
		return false;
	}
}
