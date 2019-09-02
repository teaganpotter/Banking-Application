package com.banking;

public class Address implements java.io.Serializable{

	private String street;
	private String city;
	private String state;
	private String zipCode;

	public Address() {}
	

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return street + " " + city + " " + state + " " + zipCode;
	}

	
}

