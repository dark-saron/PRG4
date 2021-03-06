package de.fhe.ai.prg4.model;

import java.io.Serializable;

public class Article implements Serializable{
	
	private	int 	Id;
	private	String	Description;
	private	String	Place;
	private String Type;
	private	String 	Name;
	private	String	Photo;
	private	String 	Ean_Isbn;

	
	public Article(int id, String type, String description, String place, String name,
			String photo, String ean_Isbn) {
		super();
		Id = id;
		Type = type;
		Description = description;
		Place = place;
		Name = name;
		Photo = photo;
		Ean_Isbn = ean_Isbn;

	}
	
	public Article(Article art) {
		super();
		Id = art.Id;
		Type = art.Type;
		Description = art.Description;
		Place = art.Place;
		Name = art.Name;
		Photo = art.Photo;
		Ean_Isbn = art.Ean_Isbn;

	}

	
	public Article() {
		super();
		Id = -1;
		Type = null;
		Description = null;
		Place = null;
		Name = null;
		Photo = null;
		Ean_Isbn = null;
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
		this.Name = name;
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


	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}
	
	

}
