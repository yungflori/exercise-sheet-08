package de.unistuttgart.iste.sqa.pse.sheet08.presence.transportation;

/**
 * Provides static methods for efficiency calculations.
 */
public final class Efficiency {

	/*@
	@ requires maxPersonCount > 0;
	@ requires maxSpeed > 0f;
	@ ensures \result != null;
	@*/
	/**
	 * Calculates the efficiency category based on the maxPersonCount and speed of the corresponding transportation method
	 * @param maxPersonCount maximal person count of the corresponding transportation method
	 * @param maxSpeed overall speed of the corresponding transportation method
	 * @return the calculated efficiency category
	 * @throws IllegalArgumentException If the preconditions are not satisfied.
	 */
	public static EfficiencyCategory calculateEfficiency(final int maxPersonCount, final float maxSpeed)
			throws IllegalArgumentException {
		if (maxPersonCount < 0 || maxSpeed < 0) {
			throw new IllegalArgumentException("Parameters have to be > 0");
		}

		float efficiency = maxPersonCount / maxSpeed;

		if (efficiency < 0.2) {
			return EfficiencyCategory.D;
		} else if (efficiency < 0.3) {
			return EfficiencyCategory.C;
		} else if (efficiency < 0.4) {
			return EfficiencyCategory.B;
		} else {
			return EfficiencyCategory.A;
		}
	}

	/*@
	@ requires energyType !== null;
	@ ensures \result != null;
	@*/
	/**
	 * Calculates the efficiency category based on the used energy type of the corresponding transportation method
	 * @param maxPersonCount maximal person count of the corresponding transportation method
	 * @param speed overall speed of the corresponding transportation method
	 * @return the calculated efficiency category
	 * @throws IllegalArgumentException If the preconditions are not satisfied.
	 */
	public static EfficiencyCategory calculateEfficiency(final EnergyType energyType) throws IllegalArgumentException {
		switch (energyType) {
			case ELECTRIC:
				return EfficiencyCategory.A;
			case STEAM:
				return EfficiencyCategory.B;
			case GASOLINE:
				return EfficiencyCategory.C;
			default:
				throw new IllegalArgumentException("Energy type may not be null.");
		}
	}
}
