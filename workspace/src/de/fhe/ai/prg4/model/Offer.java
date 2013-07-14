package de.fhe.ai.prg4.model;

import java.sql.Date;

public class Offer {
	
	private int 	Id;
	private float 	Startsaleprice;
	private float	Buynowprice;
	private String 	Start;
	private	String	End;
	private String	Url;
	private	int		Status;
	private	int		Creator_User_Id;
	private	int		Article_Id;
	private String	Article_Name;
	private String	Auctionhouse;
	private	String	externalId;
	
	
	public Offer(int id, float startsaleprice, float buynowprice, String start,
			String end, String url, int status, int creator_User_Id,
			int article_Id, String	article_Name, String auctionhouse, String externalId) {
		super();
		Id = id;
		Startsaleprice = startsaleprice;
		Buynowprice = buynowprice;
		Start = start;
		End = end;
		Url = url;
		Status = status;
		Creator_User_Id = creator_User_Id;
		Article_Id = article_Id;
		Article_Name = null;
		Auctionhouse = auctionhouse;
		this.externalId = externalId;
	}


	public Offer() {
		Id = -1;
		Startsaleprice = -1;
		Buynowprice = -1;
		Start = null;
		End = null;
		Url = null;
		Status = -1;
		Creator_User_Id = -1;
		Article_Id = -1;
		Article_Name = null;
		Auctionhouse = null; 
		this.externalId = null;
	}

	public String getAuctionhouse(){
		return Auctionhouse;
	}
	
	public void setAuctionhouse(String auctionhouse){
		Auctionhouse = auctionhouse;
	}
	
	
	public String getArticle_Name() {
		return Article_Name;
	}
	
	public void setArticle_Name(String article_name){
		Article_Name = article_name;
	}


	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}


	public float getStartsaleprice() {
		return Startsaleprice;
	}


	public void setStartsaleprice(float startsaleprice) {
		Startsaleprice = startsaleprice;
	}


	public float getBuynowprice() {
		return Buynowprice;
	}


	public void setBuynowprice(float buynowprice) {
		Buynowprice = buynowprice;
	}


	public String getStart() {
		return Start;
	}


	public void setStart(String start) {
		Start = start;
	}


	public String getEnd() {
		return End;
	}


	public void setEnd(String end) {
		End = end;
	}


	public String getUrl() {
		return Url;
	}


	public void setUrl(String url) {
		Url = url;
	}


	public int getStatus() {
		return Status;
	}


	public void setStatus(int status) {
		Status = status;
	}


	public int getCreator_User_Id() {
		return Creator_User_Id;
	}


	public void setCreator_User_Id(int creator_User_Id) {
		Creator_User_Id = creator_User_Id;
	}


	public int getArticle_Id() {
		return Article_Id;
	}


	public void setArticle_Id(int article_Id) {
		Article_Id = article_Id;
	}
	
	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}
	

}
