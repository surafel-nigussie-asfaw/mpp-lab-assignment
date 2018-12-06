package ea.mpp.library.entities;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {
//	private String firstName;
	private final StringProperty firstNameProperty = new SimpleStringProperty();
	private final StringProperty lastNameProperty = new SimpleStringProperty();
	private final StringProperty phoneNumberProperty = new SimpleStringProperty();

	private Address address;

	public Person(String firstName, String lastName, String phoneNumber) {
		firstNameProperty.set(firstName);
		lastNameProperty.set(lastName);
		phoneNumberProperty.set(phoneNumber);
	}
	
	public Person(String firstName, String lastName, String phoneNumber, Address address) {
		firstNameProperty.set(firstName);
		lastNameProperty.set(lastName);
		phoneNumberProperty.set(phoneNumber);
		this.address = address;
	}
	
	public StringProperty firstNameProperty() {
		return firstNameProperty;
	}
	
	public String getFirstName() {
		return firstNameProperty.get();
	}
	
	public void setFirstName(String firstName) {
		this.firstNameProperty.set(firstName);
	}
	
	public String getLastName() {
		return lastNameProperty.get();
	}
	public void setLastName(String lastName) {
		this.lastNameProperty.set(lastName);
	}
	public StringProperty lastNameProperty() {
		return lastNameProperty;
	}
	public String getPhoneNumber() {
		return phoneNumberProperty.get();
	}
	public void setPhoneNumber(String phoneNumber) {
		phoneNumberProperty.set(phoneNumber);
	}
	public StringProperty phoneNumberProperty() {
		return lastNameProperty;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
}
