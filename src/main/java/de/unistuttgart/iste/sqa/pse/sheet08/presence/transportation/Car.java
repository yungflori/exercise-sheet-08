package de.unistuttgart.iste.sqa.pse.sheet08.presence.transportation;

/**
 * A privately owned car.
 */
public class Car {
	// @ private instance invariant registrationNumber != null;

	private final String registrationNumber;

	/*@
	@ requires registrationNumber != null;
	@*/
	/**
	 * Creates a new car object.
	 * @param registrationNumber Registration number of the car.
	 * @throws IllegalArgumentException If the preconditions are not satisfied.
	 */
	public Car(String registrationNumber) throws IllegalArgumentException {
		if (registrationNumber == null) {
			throw new IllegalArgumentException("Registration number may not be null.");
		}
		this.registrationNumber = registrationNumber;
	}

	/*@
	@ ensures \result > 0;
	@*/
	/**
	 * @return The maximum number of people the car can carry at a time.
	 */
	public int getTotalCapacity() {
		return 5;
	}

	/*@
	@ ensures \result != null;
	@*/
	/**
	 * @return The transportation type of the car.
	 */
	public TransportationType getTransportationType() {
		return TransportationType.LAND;
	}

	/*@
	@ ensures \result != null;
	@*/
	/**
	 * @return The efficiency category of the car.
	 */
	public EfficiencyCategory getEfficiencyCategory() {
		return EfficiencyCategory.D;
	}

	/*@
	@ ensures \result > 0;
	@*/
	/**
	 * @return The speed of this car in km/h
	 */
	public float getSpeed() {
		return 180;
	}

	/*@
	@ ensures \result == registrationNumber;
	@*/
	/**
	 * @return The registration number of this car.
	 */
	public /*@ pure @*/ String getRegistrationNumber() {
		return registrationNumber;
	}

	/**
	 * Prints the general vehicle information of the corresponding transportation method
	 */
	public void printTransportationInfo() {
		System.out.println("Registration number: " + registrationNumber + ", Speed: " + this.getSpeed() + " km/h");
	}
}
