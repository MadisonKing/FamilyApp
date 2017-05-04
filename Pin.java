package com.familyApp.FamilyApp;

import java.util.ArrayList;

/**
 * This class represents the pin number that is attached to a family object
 * the pin number is randomly generated (but we must check that it does not already exist)
 * @author Madison King
 *
 */
public class Pin {
	
	/**integer to represent the pin number */
	protected int pinNumber;
	
	/**family that is attached to pin number */
	protected Family family;
	

	/**
	 * empty constructor that generates pin
	 */
	public Pin() {
		super();
		this.pinNumber = (int) ((Math.random() + 2) * 1234);
		family = new Family();
	}
	
	public Pin(int pinNumber, Family family){
		this.pinNumber = pinNumber;
		this.family = family;
	}
	
	public Pin(int pinNumber, String familyName){
		this.pinNumber = pinNumber;
		this.family = new Family(familyName);
		family.setPin(pinNumber);
	}
	
	/**
	 * 
	 */
	public Pin(String familyName) {
		super();
		this.pinNumber = (int) ((Math.random() + 2) * 1234);
		family = new Family(familyName);
	}

	/**
	 * @return the pinNumber
	 */
	public int getPinNumber() {
		return pinNumber;
	}

	/**
	 * @param pinNumber the pinNumber to set
	 */
	public void setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
	}

	
	/**
	 * @return the family
	 */
	public Family getFamily() {
		return family;
	}

	/**
	 * @param family the family to set
	 */
	public void setFamily(Family family) {
		this.family = family;
	}
	
	public void display(){
		System.out.println(pinNumber);
		family.display();
	}
	
}