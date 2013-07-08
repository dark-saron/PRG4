package de.fhe.ai.prg4.controller;

import de.fhe.ai.prg4.io_database.DBManager;
import de.fhe.ai.prg4.model.Bill;

public class BillLogic {
	private DBManager dbManager;
	private Bill bill;
	private Boolean flag;
	
	
	public BillLogic()
	{
		dbManager = new DBManager();
		bill = new Bill();
		
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
	public boolean setNewArticle(int id, float total, String bought_At,
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
	
	public float CalculateSum(float total, float ship_cost)
	{
		return total + ship_cost;
	}
	
	
}
