package com.banking;


import java.io.FileInputStream;

import java.io.FileOutputStream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.user.User;

public class Bank implements java.io.Serializable  {

	private String name;
	private static String fileName = "C:\\Test\\Bank.txt";
	
	private User[] users = new User[0];
	
	public Bank () {
		name= "Claim Academy Bank";
		
	}
	
	public static Bank load() throws IOException, ClassNotFoundException {
		
	    FileInputStream file = new FileInputStream(fileName); 
        ObjectInputStream in = new ObjectInputStream(file); 
          
        Bank b = (Bank)in.readObject(); 
          
        in.close(); 
        file.close();
        
		return b;
	}
	public void save() throws IOException {
		 FileOutputStream file = new FileOutputStream(fileName); 
         ObjectOutputStream out = new ObjectOutputStream(file); 
   
         out.writeObject(this); 
           
         out.close(); 
         file.close(); 
		  
	}
	
	public void addUser(User usr) {
		User[] newUser = new User[users.length + 1];
		System.arraycopy(users, 0, newUser, 0, users.length);
		newUser[newUser.length - 1] = usr;
		users = newUser;
		try {
			save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void deleteUser(String email) {
		User[] tempArray = new User[users.length - 1];
		for (int i=0; i<users.length; i++) {
			if (email != users[i].getEmail()) {
				tempArray[i] = users[i];
			}
		}
		users = tempArray;
	}
		
	
	public User getUser(String email, String password) {
		for (int i = 0; i < users.length; i++) {
			if (email.equalsIgnoreCase(users[i].getEmail())) {
				if (password.contentEquals(users[i].getPassword())) {
					return users[i];
				}
			}
		}
		return null;
	}
	
	public User getRealUser(User user) {
		for (int i = 0; i < users.length; i++) {
			if (user.getEmail().equalsIgnoreCase(users[i].getEmail())) {
				return users[i];
			}
		}
		return null;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static String getFileName() {
		return fileName;
	}

	public static void setFileName(String fileName) {
		Bank.fileName = fileName;
	}

	public User[] getUsers() {
		return users;
	}

	public void setUsers(User[] users) {
		this.users = users;
	}
	
	
}
