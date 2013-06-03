package model;

import java.sql.Date;

public class Offer {
	
	private int 	Id;
	private float 	Startsaleprice;
	private float	Buynowprice;
	private Date 	Start;
	private	Date	End;
	private String	Url;
	private	String	Status;
	private	int		Creator_User_Id;
	private	int		Article_Id;
	private	int		User_User_Id; // ?
	
	
	public Offer(int id, float startsaleprice, float buynowprice, Date start,
			Date end, String url, String status, int creator_User_Id,
			int article_Id, int user_User_Id) {
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
		User_User_Id = user_User_Id;
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


	public Date getStart() {
		return Start;
	}


	public void setStart(Date start) {
		Start = start;
	}


	public Date getEnd() {
		return End;
	}


	public void setEnd(Date end) {
		End = end;
	}


	public String getUrl() {
		return Url;
	}


	public void setUrl(String url) {
		Url = url;
	}


	public String getStatus() {
		return Status;
	}


	public void setStatus(String status) {
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


	public int getUser_User_Id() {
		return User_User_Id;
	}


	public void setUser_User_Id(int user_User_Id) {
		User_User_Id = user_User_Id;
	}
	
	
	
	
	

}
