package de.fhe.ai.prg4.model;

import java.sql.Date;

public class Bill {
	
	private int 	Id;
	private	float	Total;
	private	String	Bought_At;
	private	String	Shipped_At;
	private	float	Shipping_Cost;
	private	int		Offer_Id;
	private	int		Contact_Id;
	private	int		Seller_Id;
	
	public Bill(int id, float total, String bought_At,
			String shipped_At, float shipping_Cost, int offer_Id,
			int contact_Id, int	seller_Id) {
		super();
		Id = id;
		Total = total;
		Bought_At = bought_At;
		Shipped_At = shipped_At;
		Shipping_Cost = shipping_Cost;
		Offer_Id = offer_Id;
		Contact_Id = contact_Id;
		Seller_Id = seller_Id;
	}


	public Bill() {
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}


	public float getTotal() {
		return Total;
	}


	public void setTotal(float total) {
		Total = total;
	}


	public String getBought_At() {
		return Bought_At;
	}


	public void setBought_At(String bought_At) {
		Bought_At = bought_At;
	}


	public String getShipped_At() {
		return Shipped_At;
	}


	public void setShipped_At(String shipped_At) {
		Shipped_At = shipped_At;
	}


	public float getShipping_Cost() {
		return Shipping_Cost;
	}


	public void setShipping_Cost(float shipping_Cost) {
		Shipping_Cost = shipping_Cost;
	}


	public int getOffer_Id() {
		return Offer_Id;
	}


	public void setOffer_Id(int offer_Id) {
		Offer_Id = offer_Id;
	}


	public int getContact_Id() {
		return Contact_Id;
	}


	public void setContact_Id(int contact_Id) {
		Contact_Id = contact_Id;
	}
	
	public int getSeller_Id() {
		return Seller_Id;
	}


	public void setSeller_Id(int seller_Id) {
		Seller_Id = seller_Id;
	}

	
	

}
