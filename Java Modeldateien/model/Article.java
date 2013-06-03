package model;

public class Article {
	
	private	int 	Id;
	private	String	Description;
	private	String	Place;
	private	String 	Name;
	private	String	Photo;
	private	String 	Ean_Isbn;
	private	String	externalId;
	
	public Article(int id, String description, String place, String name,
			String photo, String ean_Isbn, String externalId) {
		super();
		Id = id;
		Description = description;
		Place = place;
		Name = name;
		Photo = photo;
		Ean_Isbn = ean_Isbn;
		this.externalId = externalId;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getPlace() {
		return Place;
	}

	public void setPlace(String place) {
		Place = place;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPhoto() {
		return Photo;
	}

	public void setPhoto(String photo) {
		Photo = photo;
	}

	public String getEan_Isbn() {
		return Ean_Isbn;
	}

	public void setEan_Isbn(String ean_Isbn) {
		Ean_Isbn = ean_Isbn;
	}

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}
	
	

}
