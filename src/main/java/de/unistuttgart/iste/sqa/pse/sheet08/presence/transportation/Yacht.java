package de.unistuttgart.iste.sqa.pse.sheet08.presence.transportation;

/**
 * A private yacht.
 */
public class Yacht extends PrivateTransportation {

	/*@
	@ requires registrationNumber != null;
	@*/
	/**
	 * Creates a new yacht object.
	 * @param registrationNumber Registration number of the yacht.
	 */
	public Yacht(String registrationNumber) {
		super(registrationNumber);
	}

	@Override
	public int getTotalCapacity() {
		return 10;
	}

	@Override
	public TransportationType getTransportationType() {
		return TransportationType.WATER;
	}

	@Override
	public EfficiencyCategory getEfficiencyCategory() {
		return EfficiencyCategory.C;
	}

	@Override
	public float getSpeed() {
		return 70;
	}

	/**
	 * @return The minimum water depth that can be safely navigated by this yacht, in meters.
	 */
	public float getMinimumWaterDepth() {
		return 5;
	}
}
