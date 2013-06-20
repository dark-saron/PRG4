package de.fhe.ai.prg4.model;

import java.sql.Date;

public class Bill {
	
	private int 	Id;
	private String	Buyer;
	//private String	Offer_Id; //?
	private	float	Total;
	private	Date	Bought_At;
	private	Date	Paid_At;
	private	float	Shipping_Cost;
	private	int		Offer_Id;
	private int 	User_Id;
	private	int		Contact_Id;
	
	
	public Bill(int id, String buyer, float total, Date bought_At,
			Date paid_At, float shipping_Cost, int offer_Id, int user_Id,
			int contact_Id) {
		super();
		Id = id;
		Buyer = buyer;
		Total = total;
		Bought_At = bought_At;
		Paid_At = paid_At;
		Shipping_Cost = shipping_Cost;
		Offer_Id = offer_Id;
		User_Id = user_Id;
		Contact_Id = contact_Id;
	}


	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}


	public String getBuyer() {
		return Buyer;
	}


	public void setBuyer(String buyer) {
		Buyer = buyer;
	}


	public float getTotal() {
		return Total;
	}


	public void setTotal(float total) {
		Total = total;
	}


	public Date getBought_At() {
		return Bought_At;
	}


	public void setBought_At(Date bought_At) {
		Bought_At = bought_At;
	}


	public Date getPaid_At() {
		return Paid_At;
	}


	public void setPaid_At(Date paid_At) {
		Paid_At = paid_At;
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


	public int getUser_Id() {
		return User_Id;
	}


	public void setUser_Id(int user_Id) {
		User_Id = user_Id;
	}


	public int getContact_Id() {
		return Contact_Id;
	}


	public void setContact_Id(int contact_Id) {
		Contact_Id = contact_Id;
	}
	
	

	
	

}
