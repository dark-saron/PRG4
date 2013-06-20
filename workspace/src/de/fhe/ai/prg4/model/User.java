package de.fhe.ai.prg4.model;

/**
 * 
 * @author Daniel W.
 *
 */

public class User {
	
	private int Id;
	private	String Username;
	private	String Pw;
	
	
	public User(int id, String username, String pw) {
		super();
		Id = id;
		Username = username;
		Pw = pw;
	}


	public User(String username, String pW) {
		super();
		Id = -1;
		Username = username;
		Pw = pW;
	}


	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}


	public String getUsername() {
		return Username;
	}


	public void setUsername(String username) {
		Username = username;
	}


	public String getPw() {
		return Pw;
	}


	public void setPw(String pw) {
		Pw = pw;
	}
	
	public Boolean getUser(String userName, String pw) {
		
		return true;
	}


	public void setUser(String pw) {
		//Pw = pw;
	}
	


}
