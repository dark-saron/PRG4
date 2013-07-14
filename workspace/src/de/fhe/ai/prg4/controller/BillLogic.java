package de.fhe.ai.prg4.controller;

import de.fhe.ai.prg4.io_database.DBManager;
import de.fhe.ai.prg4.model.Address;
import de.fhe.ai.prg4.model.Bill;

public class BillLogic {
	private DBManager dbManager;
	private Bill bill;
	private ContactLogic cLogic;
	private static Boolean flag;
	
	
	public BillLogic()
	{
		dbManager = new DBManager();
		bill = new Bill();
		cLogic = new ContactLogic();
		
	}
	
	public Bill getBill(int billID)
	{
		
		if(billID == -1)
			return null;
		DBManager.open();
		bill = dbManager.queryBill(billID);
		DBManager.close();
		
		return bill;
	}
	
	//anlegen eine neue Rechnung
	public boolean setNewBill(int id, float total, String bought_At,
			String shipped_At, float shipping_Cost,
			int offer_Id, int buyer_Id, int seller_Id)
	{
		//TODO: überprüfung des unhaltes
		Bill bill1 = new Bill(id, total, bought_At, shipped_At, 
				shipping_Cost, offer_Id, buyer_Id, seller_Id);
		boolean status;
		
		//db connection um ein insert aufzurufen
		DBManager.open();
		status = dbManager.queryInsertBill(bill1);
		DBManager.close();
		
		return status;
	}
	
	public boolean setNewBill(Bill bill)
	{
		//TODO: überprüfung des unhaltes
		boolean status;
		
		//db connection um ein insert aufzurufen
		DBManager.open();
		status = dbManager.queryInsertBill(bill);
		DBManager.close();
		
		return status;
	}
	
	public int GetBillID(int offerID)
	{
		int id;
		DBManager.open();
		
		id= dbManager.queryGetBillID(offerID);
		
		DBManager.close();
		
		return id;
	}
	
	public boolean CreateNewBill(Bill bill, Address seller, Address buyer)
	{
		//help var to make sure that later on none connected Addresses get deleted from Contacts
		boolean isConnectedBuyerAddress = false;
		boolean isConnectedSellerAddress = false;
		
		int sellerAddrID = -1;
		int buyerAddrID = -1;
		
		//create of the seller address in the DB
		if(seller.getId() == -1)
		{
			
			flag = cLogic.setNewAddress(seller);
		
			if(!flag)
				return false;
		
			sellerAddrID = cLogic.getAddressID();
		}
		else
		{
			isConnectedSellerAddress = true;
			sellerAddrID = seller.getId();
		}
		
		
		//create the buyer address in the DB
		if(buyer.getId() == -1)
		{
			flag = cLogic.setNewAddress(buyer);
			
			if(!flag && !isConnectedSellerAddress)
			{
				cLogic.deleteAddress(sellerAddrID);
				return false;
			}
			buyerAddrID = cLogic.getAddressID();
		}
		else
		{
			isConnectedBuyerAddress = true;
			buyerAddrID = buyer.getId();
		}
		
		//create the BILL
		//set the Address IDs for buyer and seller
		bill.setContact_Id(buyerAddrID);
		bill.setSeller_Id(sellerAddrID);
		
		flag = setNewBill(bill);
		
		if(!flag)
		{
			if(sellerAddrID != buyerAddrID)
			{
				if(!isConnectedSellerAddress)
					cLogic.deleteAddress(sellerAddrID);
				
				if(!isConnectedBuyerAddress)
					cLogic.deleteAddress(buyerAddrID);
			}
			else
				if(!isConnectedSellerAddress)
					cLogic.deleteAddress(sellerAddrID);
		}
		
		
		return true;
	}
	
	public float CalculateSum(float total, float ship_cost)
	{
		return total + ship_cost;
	}
	
	
}
