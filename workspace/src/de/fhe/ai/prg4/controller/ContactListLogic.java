package de.fhe.ai.prg4.controller;

import java.util.LinkedList;

import de.fhe.ai.prg4.io_database.DBManager;
import de.fhe.ai.prg4.model.Article;
import de.fhe.ai.prg4.model.Contact;

/**
 * 
 * @author Shayla
 *	 06_20_2013
 *
 *	Funktionen: liste get und set
 *	Funktionen (nicht implementieren): ordnen
 *  
 */

public class ContactListLogic {

	DBManager dbManager = new DBManager();
	LinkedList<Contact> list = new LinkedList<Contact>();
	int count = 0;
	
	public LinkedList<Contact> getContactList()
	{
		DBManager.open();
		// TODO: replace the hardcoded userid later
		LinkedList<Contact> list =  dbManager.queryAllContacts(1);
		DBManager.close();
		
		return list;
	}
	
	//future feature
	public LinkedList<Contact> orderContactList(int order)
	{	
		//call of db funktion to get list with articles with order []
		return null;
	}
	
	public LinkedList<Contact> filterContactList(int filter)
	{
		//call of db funktion to get list with articles with filter []
		return null;
	}
	
	public int getContactCount()
	{
		DBManager.open();
		
		count =  dbManager.queryAllContacts(1).size();
		DBManager.close();
		
		return count;
	
	
	}

}
