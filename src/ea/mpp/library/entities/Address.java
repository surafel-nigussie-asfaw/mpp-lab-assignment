package ea.mpp.library.entities;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Address {
	private final StringProperty streetProperty = new SimpleStringProperty();
	private final StringProperty cityProperty = new SimpleStringProperty();
	private final StringProperty stateProperty = new SimpleStringProperty();
	private final StringProperty zipCodeProperty = new SimpleStringProperty();
	
	public Address(String street, String city, String state, String zipCode) {
		streetProperty.set(street); 
		cityProperty.set(city);
		stateProperty.set(state);
		zipCodeProperty.set(state);
	}

	public StringProperty streetProperty() {
		return streetProperty;
	}
	public String getStreet() {
		return streetProperty.get();
	}

	public void setStreet(String street) {
		streetProperty.set(street);
	}

	public StringProperty cityProperty() {
		return cityProperty;
	}
	public String getCity() {
		return cityProperty.get();
	}

	public void setCity(String city) {
		cityProperty.set(city);
	}

	public StringProperty stateProperty() {
		return stateProperty;
	}
	public String getState() {
		return stateProperty.get();
	}

	public void setState(String state) {
		stateProperty.set(state);
	}

	public StringProperty zipCodeProperty() {
		return zipCodeProperty;
	}
	public String getZipCode() {
		return zipCodeProperty.get();
	}

	public void setZipCode(String zipCode) {
		zipCodeProperty.set(zipCode);
	}

}
