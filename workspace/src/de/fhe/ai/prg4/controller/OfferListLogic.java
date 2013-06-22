package de.fhe.ai.prg4.controller;

import java.util.LinkedList;

import de.fhe.ai.prg4.io_database.DBManager;
import de.fhe.ai.prg4.model.Offer;

public class OfferListLogic {
	
	DBManager dbManager = new DBManager();
	LinkedList<Offer> list = new LinkedList<Offer>();
	
	public LinkedList<Offer> getOfferList()
	{
		DBManager.open();
		// TODO: replace the hardcoded userid later
		LinkedList<Offer> list =  dbManager.queryAllOffers(1);
		DBManager.close();
		
		return list;
	}
	
	//future feature
	public LinkedList<Offer> orderOfferList(int order)
	{	
		//call of db funktion to get list with articles with order []
		return null;
	}
	
	public LinkedList<Offer> filterOfferList(int filter)
	{
		//call of db funktion to get list with articles with filter []
		return null;
	}

}
