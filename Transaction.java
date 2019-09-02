package com.banking;

import java.util.Date;

public class Transaction implements java.io.Serializable {

	private String type;
	private float amount;
	private Date date;
	
	public Transaction(String type, float amount, Date date) {
		this.type = type;
		this.amount = amount;
		this.date = date;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getAmountstr() {
		return String.format("%.2f", amount);
	}
	public Date getDate() {
		return this.date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
