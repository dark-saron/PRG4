package de.fhe.ai.prg4.model;

public class Bill {
	
	private int 	Id;
	private String	Buyer;
	private	float	Total;
	private	float	Shipping_Cost;
	private	int		Offer_Id;
	private int 	User_Id;
	private	int		Contact_Id;
	
	
	public Bill(int id, String buyer, float total, float shipping_Cost, int offer_Id, int user_Id,
			int contact_Id) {
		super();
		Id = id;
		Buyer = buyer;
		Total = total;
		Shipping_Cost = shipping_Cost;
		Offer_Id = offer_Id;
		User_Id = user_Id;
		Contact_Id = contact_Id;
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
