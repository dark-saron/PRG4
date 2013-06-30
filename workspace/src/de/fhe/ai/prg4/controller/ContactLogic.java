package de.fhe.ai.prg4.controller;

import de.fhe.ai.prg4.io_database.DBManager;
import de.fhe.ai.prg4.model.Address;
import de.fhe.ai.prg4.model.Contact;

public class ContactLogic {
	private DBManager dbManager;
	private Contact contact;
	private Address address;
	private Boolean flag;
	
	public ContactLogic()
	{
		dbManager = new DBManager();
		contact = new Contact();
		address = new Address();
		
	}
	public boolean deleteContact(int contactID)
	{
		flag = false;
		if(contactID == -1)
			return flag;
		DBManager.open();
		flag = dbManager.queryDeleteContact(contactID);
		DBManager.close();
		
		return flag;
	}
	
	public Contact getContact(int contactID)
	{
		
		if(contactID == -1)
			return null;
		DBManager.open();
		contact = dbManager.queryContactDetails(contactID);
		DBManager.close();
		
		return contact;
	}
	
	//create new Contact
	public boolean setNewContact(String first_Name, String last_Name, String title,
			String email, String phone, String mobile, int user_Id,
			int shipping_Address_Id, int billing_Address_Id)
	{
		//TODO: check for error input
		contact = new Contact(-1,first_Name, last_Name, title,
				email, phone, mobile, user_Id,
				shipping_Address_Id, billing_Address_Id);
		
		boolean status;
		
		//db connection to call the insert query
		dbManager.open();
		status = dbManager.queryInsertContact(contact);
		dbManager.close();
		
		return status;
	}
	
	//edit a existing contact
	public boolean setContact(int id, String first_Name, String last_Name, String title,
			String email, String phone, String mobile, int user_Id,
			int shipping_Address_Id, int billing_Address_Id)
	{

		contact = new Contact(id, first_Name, last_Name, title,
				email, phone, mobile, user_Id,
				shipping_Address_Id, billing_Address_Id);
		
		boolean status;
		
		//db connection um ein insert aufzurufen
		DBManager.open();
		status = dbManager.queryUpdateContact(contact);
		DBManager.close();
		
		return status;
	}
	
	public Address getAddress(int id)
	{
		//TODO: Missing query for the address
		DBManager.open();
		//address = dbManager.qu
		DBManager.close();
		return address; 
	}
	
	public Address setNewAddress(String first_Name, String last_Name,
			String street_Nr, String zip, String city, String country)
	{
		
		address = new Address(-1, first_Name, last_Name, street_Nr, zip, city, country);
		
		//TODO: Missing query for the address
		DBManager.open();
		//address = dbManager.qu
		DBManager.close();
		return address; 
	}
	
	public Address setAddress(int id, String first_Name, String last_Name,
			String street_Nr, String zip, String city, String country)
	{
		address = new Address(id, first_Name, last_Name, street_Nr, zip, city, country);
		
		//TODO: Missing query for the address
		DBManager.open();
		//address = dbManager.qu
		DBManager.close();
		return address; 
	}


}
