package de.unistuttgart.iste.sqa.pse.sheet08.homework.immutable;

import java.util.Date;

/**
 * Represents a person with a name and birth date.
 */
public class Person {
	//@ private instance invariant name != null && name.length() > 0;
	//@ private instance invariant age >= ;
	
	public String name;
	public int age;
	
	/*@
	  @ requires name != null && name.length() > 0;
	  @ requires age >= 0;
	  @ ensures this.name == name;
	  @ ensures this.age == age;
	  @*/
	/**
	 * Creates a new person with the given name.
	 * @param name Name of the person.
	 * @param age Birth date of the person.
	 * @throws IllegalArgumentException If the preconditions are not satisfied.
	 */
	public Person(final String name, final int age) throws IllegalArgumentException {
		if (name == null || name.length() == 0 || age < 0) {
			throw new IllegalArgumentException("A person may not have a null or empty name, and their birth date must not be null.");
		}
		this.name = name;
		this.age = age;
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
	  @ ensures \result == age;
	  @*/
	/**
	 * @return This person's birth date.
	 */
	public /*@ pure @*/ int getAge() {
		return age;
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
	  @ requires age >= 0;
	  @ ensures this.age == age;
	  @*/
	/**
	 * Sets this person's birth date.
	 * @param age The new birth date.
	 * @throws IllegalArgumentException If the preconditions are not satisfied.
	 */
	public void setAge(final int age) throws IllegalArgumentException {
		if (age < 0) {
			throw new IllegalArgumentException("A person's birth date may not be less than zero.");
		}
		this.age = age;
	}
	
}
