package de.fhe.ai.prg4.controller;

import java.util.regex.Pattern;

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
	
	//combines insert of contact and address with checkup is success
	public boolean CreateNewContactWithAddress(
			String cFirst_Name, 
			String cLast_Name, 
			String cTitle,
			String cEmail, 
			String cPhone, 
			String cMobile, 
			int cUser_Id,
			String aFirst_Name, 
			String aLast_Name,
			String aStreet_Nr, 
			String aZip, 
			String aCity, 
			String aCountry, 
			String aTitle, 
			String aGender)
	{
		
		address = new Address(-1, aFirst_Name, aLast_Name, aStreet_Nr, aZip, aCity, aCountry, aTitle, aGender);
		
		if(!setNewAddress(address))
			return false;
		DBManager.open();
		address.setId(dbManager.queryAddressID());
		DBManager.close();
		
		contact = new Contact(-1, cFirst_Name, cLast_Name, cTitle, cEmail, cPhone, cMobile, cUser_Id,address.getId(),address.getId());
		
		if(!setNewContact(contact))
		{
			if(contact.getShipping_Address_Id() == contact.getBilling_Address_Id())
			{
				deleteAddress(contact.getShipping_Address_Id());
			}
			else
			{
				deleteAddress(contact.getShipping_Address_Id());
				deleteAddress(contact.getBilling_Address_Id());
			}
			return false;
			
		}
		return true;
	}

	public boolean DeleteContactWithAddress(int id)
	{
		contact = getContact(id);
		int id_sa = contact.getShipping_Address_Id();
		int id_ba = contact.getBilling_Address_Id();
		if(!deleteContact(id))
			return false;

		if(id_sa == id_ba)
			{
				if(!deleteAddress(id_ba))
						return false;
			}
			else
			{
				if(!deleteAddress(id_sa) && 
				!deleteAddress(id_ba))
					return false;
			}
			
			
		return true;
	}

	//combines update of contact and address with checkup is success
	public boolean UpdateContactWithAddress(
			int cid, 
			String cFirst_Name, 
			String cLast_Name, 
			String cTitle,
			String cEmail, 
			String cPhone, 
			String cMobile, 
			int cUser_Id,
			int aID, 
			String aFirst_Name, 
			String aLast_Name,
			String aStreet_Nr, 
			String aZip, 
			String aCity, 
			String aCountry, 
			String aTitle, 
			String aGender)
	{
		contact = new Contact(cid, cFirst_Name, cLast_Name, cTitle, cEmail, cPhone, cMobile, cUser_Id,aID,aID);

		if(!setContact(contact))
			return false;
		
		address = new Address(aID, aFirst_Name, aLast_Name, aStreet_Nr, aZip, aCity, aCountry, aTitle, aGender);
		
		if(!setAddress(address))
			return false;
		
		return true;
	}

	
	
	//create new Contact
	public boolean setNewContact(Contact contact)
	{
		//TODO: check for error input
		boolean status;
		
		//db connection to call the insert query
		DBManager.open();
		status = dbManager.queryInsertContact(contact);
		DBManager.close();
		
		return status;
	}
	
	//edit a existing contact
	public boolean setContact(Contact contact)
	{

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
		address = dbManager.queryAddressDetails(id);
		DBManager.close();
		
		return address; 
	}
	
	//create new address in the DB
	public boolean setNewAddress(Address address)
	{
		boolean check;
		
		//TODO: Missing query for the address
		DBManager.open();
		check = dbManager.queryInsertAdress(address);
		DBManager.close();
		return check; 
	}
	
	//update old Address
	public boolean setAddress(Address address)
	{
		
		boolean check;
		
		//TODO: Missing query for the address
		DBManager.open();
		check = dbManager.queryUpdateAddress(address);
		DBManager.close();
		return check; 
	}

	
	//delete address in the DB
	public boolean deleteAddress(int id)
		{
			boolean check;
			
			//TODO: Missing query for the address
			DBManager.open();
			check = dbManager.queryDeleteAddress(id);
			DBManager.close();
			return check; 
		}
	
}
