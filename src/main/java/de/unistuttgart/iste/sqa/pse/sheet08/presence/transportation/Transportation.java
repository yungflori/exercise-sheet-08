package de.unistuttgart.iste.sqa.pse.sheet08.presence.transportation;

/**
 * A transportation method for people.
 */
public interface Transportation {

	/*@
	@ ensures \result > 0;
	@*/
	/**
	 * @return The maximum number of people the transportation method can carry at a time.
	 */
	public int getTotalCapacity();

	/*@
	@ ensures \result != null;
	@*/
	/**
	 * @return The transportation type of the transportation method.
	 */
	public TransportationType getTransportationType();

	/*@
	@ ensures \result != null;
	@*/
	/**
	 * @return The efficiency category of the current transportation method.
	 */
	public EfficiencyCategory getEfficiencyCategory();
}
