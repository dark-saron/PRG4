package de.fhe.ai.prg4.controller;

import de.fhe.ai.prg4.io_database.DBManager;
import de.fhe.ai.prg4.model.Offer;

public class OfferLogic 
{
	private DBManager dbManager;
	private Offer offer;
	private Boolean flag;
	
	public OfferLogic()
	{
		dbManager = new DBManager();
		offer = new Offer();
		
	}

	public boolean existBill(int offerID)
	{
		flag = false;

		if(offerID == -1)
			return flag;
		
		DBManager.open();
		flag = dbManager.queryExistBill(offerID);
		DBManager.close();
		
		return flag;
	}

	
	public boolean deleteOffer(int offerID)
	{
		flag = false;

		if(offerID == -1)
			return flag;
		
		DBManager.open();
		flag = dbManager.queryDeleteOffer(offerID);
		DBManager.close();
		
		return flag;
	}
	
	/**
	 * get offer with given offerID
	 * @param offerID
	 * @return offer
	 */
	public Offer getOffer(int offerID)
	{
		
		if(offerID == -1)
			return null;
		
		DBManager.open();
		offer = dbManager.queryOfferDetails(offerID);
		DBManager.close();
		
		return offer;
	}
	
	/**
	 * create a new offers
	 * 
	 * @param id
	 * @param type
	 * @param description
	 * @param place
	 * @param name
	 * @param photo
	 * @param ean_Isbn
	 * @param externalId
	 * @return flag
	 */
	public boolean setNewOffer(int id, float startsaleprice, 
			float buynowprice, String start,
			String end, 
			String url, 
			int status, 
			int creator_User_Id,
			int article_Id, 
			String	article_Name, 
			String auctionhouse)
	{
		//TODO: überprüfung des unhaltes
		Offer offer = new Offer(id, startsaleprice, buynowprice, start,
				end, url, status, creator_User_Id,
				article_Id, article_Name, auctionhouse);
		boolean flag;
		
		//db connection um ein insert aufzurufen
		DBManager.open();
		flag = dbManager.queryInsertOffer(offer);
		DBManager.close();
		
		return flag;
	}
	
	/**
	 * edit offer
	 * 
	 * @param id
	 * @param type
	 * @param description
	 * @param place
	 * @param name
	 * @param photo
	 * @param ean_Isbn
	 * @param externalId
	 * @return
	 */
	public boolean setOffer(int id, float startsaleprice, float buynowprice, String start,
			String end, String url, int status, int creator_User_Id,
			int article_Id, String	article_Name, String auctionhouse)
	{
		Offer offer = new Offer(id, startsaleprice, buynowprice, start,
				end, url, status, creator_User_Id,
				article_Id, article_Name, auctionhouse);
		
		boolean flag;
		
		//db connection um ein insert aufzurufen
		DBManager.open();
		flag = dbManager.queryUpdateOffer(offer);
		DBManager.close();
		
		return flag;
	}

}
