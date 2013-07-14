package de.fhe.ai.prg4.model;

public class Address {

	private	int Id	;
	private	String	First_Name	;
	private	String	Last_Name	;
	private	String	Street_Nr	;
	private	String	Zip			;
	private	String	City		;
	private	String	Country		;
	private String Title		;
	private String Gender			;
	
	public Address(int id, String first_Name, String last_Name,
			String street_Nr, String zip, String city, String country, String title,
			String gender) {
		super();
		Id = id;
		First_Name = first_Name;
		Last_Name = last_Name;
		Street_Nr = street_Nr;
		Zip = zip;
		City = city;
		Country = country;
		Title = title;
		Gender = gender;
		
	}

	public Address() {
		super();
		Id = -1;
		First_Name = null;
		Last_Name = null;
		Street_Nr = null;
		Zip = null;
		City = null;
		Country = null;
		Gender = "w";
	}
	
	public Address (Address adr)
	{
		super();
		Id = adr.getId();
		First_Name = adr.getFirst_Name();
		Last_Name = adr.getLast_Name();
		Street_Nr = adr.getStreet_Nr();
		Zip = adr.getZip();
		City = adr.getCity();
		Country = adr.getCountry();
		Gender = adr.getGender();
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
	public String getStreet_Nr() {
		return Street_Nr;
	}
	public void setStreet_Nr(String street_Nr) {
		Street_Nr = street_Nr;
	}
	public String getZip() {
		return Zip;
	}
	public void setZip(String zip) {
		Zip = zip;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	
	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}
	
}
