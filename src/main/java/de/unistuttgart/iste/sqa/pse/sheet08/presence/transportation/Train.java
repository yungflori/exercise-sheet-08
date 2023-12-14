package de.unistuttgart.iste.sqa.pse.sheet08.presence.transportation;

/**
 * A train that carries passengers.
 */
public abstract class Train extends PublicTransportation {
	// @ private instance invariant energyType != null;

	private final EnergyType energyType;

	/*@
	@ requires transportationTypeName != null;
	@ requires energyType != null;
	@ ensures this.energyType == energyType;
	@*/
	/**
	 * Creates a new train object.
	 * @param transportationTypeName Name of the transportation method.
	 * @param energyType the corresponding Energy type of the transportation method.
	 * @throws IllegalArgumentException If the preconditions are not satisfied.
	 */
	public Train(final String transportationTypeName, final EnergyType energyType) throws IllegalArgumentException {
		super(transportationTypeName);

		if (energyType == null) {
			throw new IllegalArgumentException("Energy type of a train may not be null.");
		}
		this.energyType = energyType;
	}

	@Override
	public TransportationType getTransportationType() {
		return TransportationType.LAND;
	}

	/**
	 * Prints this train's energy type to the console.
	 */
	public void printEnergyType() {
		System.out.format("Energy type: %s", energyType);
	}

	/*@
	@ ensures \result != null;
	@*/
	/**
	 * Calculates the efficiency category of this train, based on either capacity and speed or the energy type used.
	 * @param useEnergyType If true, the energy type is used for the calculation, otherwise the capacity and speed are used.
	 * @return The efficiency category of the current transportation method.
	 */
	public EfficiencyCategory getEfficiencyCategory(boolean useEnergyType) {
		if (useEnergyType) {
			return Efficiency.calculateEfficiency(energyType);
		} else {
			return super.getEfficiencyCategory();
		}
	}

	@Override
	public void printTransportationInfo() {
		System.out.println("The used transportation method has the transportation type " + this.getTransportationType()
				+ " and the energy type " + energyType);
	}

	public EnergyType getEnergyType(){
        return this.energyType;
    }
}
