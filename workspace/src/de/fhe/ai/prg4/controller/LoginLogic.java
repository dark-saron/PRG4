package de.fhe.ai.prg4.controller;

import de.fhe.ai.prg4.io_database.DBManager;
import de.fhe.ai.prg4.model.User;

/**
 * 
 * @author Shayla
 * wont be implemented in the beta version
 */

public class LoginLogic {

	public String Login(String Username, String PW)
	{
		User us = new User(Username,PW);
		//db connector wiedergabe ob es geklappt hat
		return PW;
	}
	
	public String Logout()
	{
		
		return "Logout";
	}
	
}
