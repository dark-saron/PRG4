package de.fhe.ai.prg4.model;

public class Address {

	private	int Id	;
	private	String	First_Name	;
	private	String	Last_Name	;
	private	String	Street_Nr	;
	private	String	Zip;
	private	String	City;
	private	String	Country;
	
	public Address(int id, String first_Name, String last_Name,
			String street_Nr, String zip, String city, String country) {
		super();
		Id = id;
		First_Name = first_Name;
		Last_Name = last_Name;
		Street_Nr = street_Nr;
		Zip = zip;
		City = city;
		Country = country;
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
	


}
