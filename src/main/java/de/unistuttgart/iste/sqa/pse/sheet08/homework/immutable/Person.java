package de.unistuttgart.iste.sqa.pse.sheet08.homework.immutable;

import java.util.Date;

/**
 * Represents a person with a name and birth date.
 */
public class Person {
	//@ private instance invariant name != null && name.length() > 0;
	//@ private instance invariant birthDate != null;
	
	public String name;
	public Date birthDate;
	
	/*@
	  @ requires name != null && name.length() > 0;
	  @ requires birthDate != null;
	  @ ensures this.name == name;
	  @ ensures this.birthDate == birthDate;
	  @*/
	/**
	 * Creates a new person with the given name.
	 * @param name Name of the person.
	 * @param birthDate Birth date of the person.
	 * @throws IllegalArgumentException If the preconditions are not satisfied.
	 */
	public Person(final String name, final Date birthDate) throws IllegalArgumentException {
		if (name == null || name.length() == 0 || birthDate == null) {
			throw new IllegalArgumentException("A person may not have a null or empty name, and their birth date must not be null.");
		}
		this.name = name;
		this.birthDate = birthDate;
	}
	
	/*@
	  @ ensures \result == name;
	  @*/
	/**
	 * @return This person's name.
	 */
	public /*@ pure @*/ String getName() {
		return name;
	}
	
	/*@
	  @ ensures \result == birthDate;
	  @*/
	/**
	 * @return This person's birth date.
	 */
	public /*@ pure @*/ Date getBirthDate() {
		return birthDate;
	}
	
	/*@
	  @ requires name != null;
	  @ ensures this.name == name;
	  @*/
	/**
	 * Sets this person's name.
	 * @param name The new name.
	 * @throws IllegalArgumentException If the preconditions are not satisfied.
	 */
	public void setName(final String name) throws IllegalArgumentException {
		if (name == null || name.length() == 0) {
			throw new IllegalArgumentException("A person may not have a null or empty name.");
		}
		this.name = name;
	}
	
	/*@
	  @ requires birthDate != null;
	  @ ensures this.birthDate == birthDate;
	  @*/
	/**
	 * Sets this person's birth date.
	 * @param birthDate The new birth date.
	 * @throws IllegalArgumentException If the preconditions are not satisfied.
	 */
	public void setBirthDate(final Date birthDate) throws IllegalArgumentException {
		if (birthDate == null) {
			throw new IllegalArgumentException("A person's birth date may not be null.");
		}
		this.birthDate = birthDate;
	}
	
}
