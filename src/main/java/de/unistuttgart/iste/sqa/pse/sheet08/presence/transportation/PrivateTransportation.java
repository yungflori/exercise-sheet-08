package de.unistuttgart.iste.sqa.pse.sheet08.presence.transportation;

/**
 * A private transportation method for people.
 */
public abstract class PrivateTransportation implements Transportation {
	// @ private instance invariant registrationNumber != null;

	private final String registrationNumber;

	/*@
	@ requires registrationNumber != null;
	@ ensures this.registrationNumber == registrationNumber;
	@*/
	/**
	 * Creates a new private transportation object.
	 * @param registrationNumber The registration number of the transportation method.
	 * @throws IllegalArgumentException If the preconditions are not satisfied.
	 */
	public PrivateTransportation(final String registrationNumber) throws IllegalArgumentException {
		if (registrationNumber == null) {
			throw new IllegalArgumentException("Registration number may not be null.");
		}
		this.registrationNumber = registrationNumber;
	}

	/*@
	@ ensures \result == registrationNumber;
	@*/
	/**
	 * @return The registration number of this transportation method.
	 */
	public /*@ pure @*/ String getRegistrationNumber() {
		return registrationNumber;
	}

	/*@
	@ ensures \result > 0;
	@*/
	/**
	 * @return The speed of this transportation method in km/h
	 */
	public abstract float getSpeed();

	/**
	 * Prints the general vehicle information of the corresponding transportation method
	 */
	public void printTransportationInfo() {
		System.out.println("Registration number: " + registrationNumber + ", Speed: " + this.getSpeed() + " km/h");
	}
}
