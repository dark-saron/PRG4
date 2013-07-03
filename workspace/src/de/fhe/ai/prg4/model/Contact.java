package de.fhe.ai.prg4.model;

public class Contact {
	
	private int 	Id;
	private String 	First_Name;
	private String 	Last_Name;
	private String	Title;
	private String	Email;
	private String	Phone;
	private String	Mobile;
	private int		User_Id;
	private int	Shipping_Address_Id;
	private int	Billing_Address_Id;
	
	
	public Contact(int id, String first_Name, String last_Name, String title,
			String email, String phone, String mobile, int user_Id,
			int shipping_Address_Id, int billing_Address_Id) {
		super();
		
		Id = id;
		First_Name = first_Name;
		Last_Name = last_Name;
		Title = title;
		Email = email;
		Phone = phone;
		Mobile = mobile;
		User_Id = user_Id;
		Shipping_Address_Id = shipping_Address_Id;
		Billing_Address_Id = billing_Address_Id;
	}


	public Contact() {
		// TODO Auto-generated constructor stub
	}



	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}


	public String getFirst_Name() {
		return First_Name;
	}


	public void setFirst_Name(String first_Name) {
		First_Name = first_Name;
	}


	public String getLast_Name() {
		return Last_Name;
	}


	public void setLast_Name(String last_Name) {
		Last_Name = last_Name;
	}


	public String getTitle() {
		return Title;
	}


	public void setTitle(String title) {
		Title = title;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}


	public String getPhone() {
		return Phone;
	}


	public void setPhone(String phone) {
		Phone = phone;
	}


	public String getMobile() {
		return Mobile;
	}


	public void setMobile(String mobile) {
		Mobile = mobile;
	}


	public int getUser_Id() {
		return User_Id;
	}


	public void setUser_Id(int user_Id) {
		User_Id = user_Id;
	}


	public int getShipping_Address_Id() {
		return Shipping_Address_Id;
	}


	public void setShipping_Address_Id(int shipping_Address_Id) {
		Shipping_Address_Id = shipping_Address_Id;
	}


	public int getBilling_Address_Id() {
		return Billing_Address_Id;
	}


	public void setBilling_Address_Id(int billing_Address_Id) {
		Billing_Address_Id = billing_Address_Id;
	}
		
}
