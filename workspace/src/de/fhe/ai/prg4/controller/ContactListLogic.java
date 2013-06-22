package de.fhe.ai.prg4.controller;

import java.util.LinkedList;

import de.fhe.ai.prg4.io_database.DBManager;
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
	public LinkedList<Contact> getContactList()
	{
		DBManager.open();
		// TODO: replace the hardcoded userid later
		LinkedList<Contact> list =  dbManager.queryAllContacts(1);
		DBManager.close();
		
		return list;
	}
}
