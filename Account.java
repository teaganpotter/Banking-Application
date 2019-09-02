package com.banking;

import java.util.ArrayList;

public class Account implements java.io.Serializable{

	private String accountName;
	private float balance;
	private ArrayList<Transaction> transactions;
	
	public Account(String name) {
		accountName = name;
		balance = 0;
		transactions = new ArrayList<Transaction>();
	}
	
	public void addTransaction(Transaction trans) {
		transactions.add(trans);
		balance += trans.getAmount();
	}
	
	
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public String getBalancestr() {
		return String.format("%.2f", balance);
	}
	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(ArrayList<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	public Transaction[] getLastTransactions(int number){
		int len = this.transactions.size();
		if (len < number) {
			number = len;
		}
		Transaction[] returnValue = new Transaction[number];
		int start = len - number;
		int index = 0;
		for (int i = start; i<len; i++) {
			returnValue[index] = this.transactions.get(i);
			index++;
		}	
		System.out.println(returnValue.length);
		return returnValue;
	}
	@SuppressWarnings("deprecation")
	public Transaction[] getMonthlyTransactions(int month, int year){
		int cnt = 0;
		for (int i = 0; i < transactions.size(); i++) {
			Transaction t = transactions.get(i);
			System.out.println(t.getDate().getYear() + 1900);
			if ((t.getDate().getMonth() == month) && (t.getDate().getYear()+ 1900 == year)) {
				cnt++;
			}
		}
		System.out.println("count" + cnt);
		Transaction[] returnValue = new Transaction[cnt];
		int index = 0;
		for (int i = 0; i < transactions.size(); i++) {
			Transaction t = transactions.get(i);
			if ((t.getDate().getMonth() == month) && (t.getDate().getYear() + 1900 == year)) {
				returnValue[index] = this.transactions.get(i);
				index++;

			}
		}
		return returnValue;
	}
	
}
