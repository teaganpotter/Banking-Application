package com.user;

import java.util.List;

import com.banking.Account;
import com.banking.Address;

public class User implements java.io.Serializable {
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private Address address;
	private Account checking;
	private Account savings;
	private boolean hasOverdraftProtection;
	
	public User () {
		checking = new Account("checking");
		savings = new Account("savings");
	}
	
	
	public Account getChecking() {
		return checking;
	}

	public void setChecking(Account checking) {
		this.checking = checking;
	}

	public Account getSavings() {
		return savings;
	}

	public void setSavings(Account savings) {
		this.savings = savings;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public boolean getHasOverdraftProtection() {
		return hasOverdraftProtection;
	}

	public void setHasOverdraftProtection(boolean hasOverdraftProtection) {
		this.hasOverdraftProtection = hasOverdraftProtection;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password=" + password
				+ ", address=" + address + "]";
	}
	
}

