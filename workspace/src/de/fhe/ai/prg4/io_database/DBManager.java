package de.fhe.ai.prg4.io_database;
import java.sql.*;
import java.sql.Date;
import java.util.*;

import com.mysql.*;
import com.mysql.jdbc.PreparedStatement;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import de.fhe.ai.prg4.model.Article;
import de.fhe.ai.prg4.model.Bill;
import de.fhe.ai.prg4.model.Contact;
import de.fhe.ai.prg4.model.Offer;
import de.fhe.ai.prg4.model.User;
//@Author Roland Peyerl

public class DBManager {
	
	static final String PATH_DRIVER_JDBC 	= "com.mysql.jdbc.Driver";
	static final String PATH_DB 			= "jdbc:mysql://localhost/mydb";
	static final String USER 				= "admin" ;
	static final String PASSWORT 			= "admin";
	
	private static  Connection 	CONNECTION	= null;
	private static Statement STATEMENT 		= null;
	private static ResultSet RESULT_SET 	= null;
	private static boolean link = false;	//link==true --> Datenbankverbindung steht
		
	
	// called once!!! at start
	public static void open(){
		try {
			Class.forName(PATH_DRIVER_JDBC).newInstance();
			CONNECTION 	= DriverManager.getConnection(PATH_DB,USER,PASSWORT);
			STATEMENT 	= CONNECTION.createStatement();
			link = true;
		
		} catch (Exception e) {	
			e.printStackTrace();
		}
	}
	
	// called once!!! at the end
	public static void close(){
		
		try {			
			
			if (RESULT_SET != null){
			RESULT_SET.close();
			}
			
			STATEMENT.close();
			CONNECTION.close();		
		
		} catch (Exception e) {	
			e.printStackTrace();
		}
	}
	//Articles
	public LinkedList<Article> queryAllArticles(){
		try {
			RESULT_SET = STATEMENT.executeQuery("SELECT ID,Type,Name FROM article");
			
			LinkedList<Article> list1 = new LinkedList<Article>();
			Article article;
			while (RESULT_SET.next()){
				article = new Article();
				System.out.println(RESULT_SET.getInt("ID"));
				article.setId(RESULT_SET.getInt("ID"));
				article.setType(RESULT_SET.getString("Type"));
				article.setName(RESULT_SET.getString("Name"));
				list1.add(article);
				
			}
			return list1;
		}
		catch (SQLException e){
			System.out.println(e);
			return null;
		}	
	}
	
	//----------------------------------------
	
	public Article queryArticleDetails (int id){
	
		try {
			
			RESULT_SET = STATEMENT.executeQuery("SELECT * FROM article WHERE ID LIKE '" + id + "'");
			RESULT_SET.next();
			
			Article article = new Article();
			
		
			article.setId(RESULT_SET.getInt("ID"));
			article.setType(RESULT_SET.getString("Type"));
			article.setName(RESULT_SET.getString("Name"));
			article.setDescription(RESULT_SET.getString("Description"));
			article.setPhoto(RESULT_SET.getString("Photo"));
			article.setEan_Isbn(RESULT_SET.getString("EAN_ISBN"));
			article.setExternalId(RESULT_SET.getString("externalID"));
			article.setPlace(RESULT_SET.getString("Place"));
			return article;
		}
			
		catch (SQLException e){
			System.out.println(e);
			return null;
		}	
	}
	
	public boolean queryInsertArticle (Article article){
		boolean success= false;
		try {
			
			String type=article.getType();
			String name=article.getName();
			String place=article.getPlace();
			String ean_isbn=article.getEan_Isbn();
			String externalID=article.getExternalId();
			String description=article.getDescription();
			String photo=article.getPhoto();
			
			System.out.println(article.getName());
			
			int rows=STATEMENT.executeUpdate("INSERT INTO Article (Type,Name,Place,externalID,EAN_ISBN,Description,Photo) VALUES ('"+type+"','"+name+"','"+place+"','"+externalID+"','"+ean_isbn+"','"+description+"','"+photo+"')") ;
			if (rows >0){
				success=true;
			}
			
			return success;
		}
			
		catch (SQLException e){
			System.out.println(e);
			return success;
		}
	}
	
	public boolean queryUpdateArticle (Article article){//Artikel ändern
		boolean success = false;
		try {
			
			String newtype=article.getType();
			String newname=article.getName();
			String newplace=article.getPlace();
			String newean_isbn=article.getEan_Isbn();
			String newexternalID=article.getEan_Isbn();
			String newdescription=article.getDescription();
			String newphoto=article.getPhoto();
			
			int rows=STATEMENT.executeUpdate("UPDATE article SET Type='"+newtype+"',Name='"+newname+"',Place='"+newplace+"',externalID='"+newexternalID+"',EAN_ISBN='"+newean_isbn+"',Description='"+newdescription+"',Photo='"+newphoto+"' WHERE ID ='"+article.getId()+"'");
			
			if (rows>0){
				success=true;
			}
			
			return success;
		}
			
		catch (SQLException e){
			System.out.println(e);
			return success;
		}
	}
	
	public boolean queryDeleteArticle (int id){
		boolean success=false;
		try {
			
			int rows=STATEMENT.executeUpdate("Delete LOW_PRIORITY FROM article WHERE ID ='"+id+"'");
			
			if (rows > 0){
				success=true;
			}
			return success;
		}
			
		catch (SQLException e){
			System.out.println(e);
			return success;
		}
	}

	//Offers
	
	public LinkedList<Offer> queryAllOffers(int UserID){
		try {
			LinkedList<Offer> list1 = new LinkedList<Offer>();
			//@TODO UserID nachreichen
			RESULT_SET = STATEMENT.executeQuery("SELECT Offer.ID, Offer.StatusID, Article.Name, Article.ID FROM Offer join User on Offer.UserID=User.ID join Article on Article.ID=Offer.ArticleID ORDER BY Offer.StatusID");
			
			Offer offer;
			while (RESULT_SET.next()){
				offer = new Offer();
				//System.out.println(RESULT_SET.getInt("ID"));
				offer.setId(RESULT_SET.getInt("Offer.ID"));
				offer.setStatus(RESULT_SET.getInt("Offer.StatusID"));
				offer.setArticle_Id(RESULT_SET.getInt("Article.ID"));
				offer.setArticle_Name(RESULT_SET.getString("Article.Name"));
								
				list1.add(offer);
				
			}
			return list1;
		}
		catch (SQLException e){
			System.out.println(e);
			return null;
		}	
	}
	
	public Offer queryOfferDetails (int id){ //ID von Offer
				
		try {
			
			RESULT_SET = STATEMENT.executeQuery("SELECT * FROM Offer WHERE ID LIKE '" + id + "'");
			
			Offer offer = new Offer();
			RESULT_SET.next();
			
			offer.setId(RESULT_SET.getInt("ID"));
			offer.setStartsaleprice(RESULT_SET.getFloat("Startsaleprice"));
			offer.setBuynowprice(RESULT_SET.getFloat("Buynowprice"));
			offer.setStart(RESULT_SET.getString("Start"));
			offer.setEnd(RESULT_SET.getString("End"));
			offer.setUrl(RESULT_SET.getString("URL"));
			offer.setStatus(RESULT_SET.getInt("StatusID"));
			offer.setAuctionhouse(RESULT_SET.getString("Auctionhouse"));
			offer.setCreator_User_Id(RESULT_SET.getInt("UserID"));
			offer.setArticle_Id(RESULT_SET.getInt("ArticleID"));
			
			RESULT_SET = STATEMENT.executeQuery("SELECT Name FROM Article WHERE ID LIKE '" +offer.getArticle_Id()+ "'");
			RESULT_SET.next();
			offer.setArticle_Name(RESULT_SET.getString("Name"));
			return offer;
		}
			
		catch (SQLException e){
			System.out.println(e);
			return null;
		}	
	}
	
	public boolean queryInsertOffer(Offer offer){
		boolean success = false;
		
		try {			
			int rows=STATEMENT.executeUpdate("INSERT INTO Offer (Startsaleprice,Buynowprice,Start,End,Auctionhouse,URL,ArticleID,UserID,StatusID) VALUES ('"+offer.getStartsaleprice()+"','"+offer.getBuynowprice()+"','"+offer.getStart()+"','"+offer.getEnd()+"','"+offer.getAuctionhouse()+"','"+offer.getUrl()+"','"+offer.getArticle_Id()+"','"+offer.getCreator_User_Id()+"','"+offer.getStatus()+"')");
			if (rows >0){
				success=true;
			}
			
			return success;
		}
			
		catch (SQLException e){
			System.out.println(e);
			return success;
		}
	}
	
	public boolean queryUpdateOffer(Offer offer){
		boolean success = false;
		try {
			int rows=STATEMENT.executeUpdate("Update Offer SET Startsaleprice='"+offer.getStartsaleprice()+"',Buynowprice='"+offer.getBuynowprice()+"',Start='"+offer.getStart()+"',End='"+offer.getEnd()+"',Auctionhouse='"+offer.getAuctionhouse()+"',URL='"+offer.getUrl()+"',ArticleID='"+offer.getArticle_Id()+"',UserID='"+offer.getCreator_User_Id()+"',StatusID='"+offer.getStatus()+"'");
			
			if (rows>0){
				success=true;
			}
			
			return success;
		}
			
		catch (SQLException e){
			System.out.println(e);
			return success;
		}
	}
	
	public boolean queryDeleteOffer(int id){
		boolean success = false;
		try {
			
			int rows=STATEMENT.executeUpdate("Delete LOW_PRIORITY FROM Offer WHERE ID ='"+id+"'");
			
			if (rows > 0){
				success=true;
			}
			return success;
		}
			
		catch (SQLException e){
			System.out.println(e);
			return success;
		}
	}
	
	// Contacts
	
	public LinkedList<Contact> queryAllContacts(int UserID){
		try {
			LinkedList<Contact> list1 = new LinkedList<Contact>();
			//@TODO UserID nachreichen
			RESULT_SET = STATEMENT.executeQuery("SELECT Contact.ID, Contact.First_Name, Contact.Last_Name, Contact.ID FROM Offer join User on Offer.UserID=User.ID join Article on Article.ID=Offer.ArticleID ORDER BY Offer.StatusID");
			
			/*Offer offer;
			while (RESULT_SET.next()){
				offer = new Offer();
				//System.out.println(RESULT_SET.getInt("ID"));
				offer.setId(RESULT_SET.getInt("Offer.ID"));
				offer.setStatus(RESULT_SET.getInt("Offer.StatusID"));
				offer.setArticle_Id(RESULT_SET.getInt("Article.ID"));
				offer.setArticle_Name(RESULT_SET.getString("Article.Name"));
								
				list1.add(offer);
				
			}*/
			return list1;
		}
		catch (SQLException e){
			System.out.println(e);
			return null;
		}	
	}
	
	public Contact queryContactDetails(int ID){ //ID von Contact
		Contact contact = new Contact();
		return contact;
	}
	
	public boolean queryInsertContact(Contact contact){
		boolean success = false;
		return success;
	}
	
	public boolean queryUpdateContact(Contact contact){
		boolean success = false;
		return success;
	}
	
	public boolean queryDeleteContact(int ID){
		boolean success = false;
		return success;
	}

	//Login
	
	public boolean queryLogin (User user){
		boolean success = false;
		return success;
	}

	//Bills
	
	public Bill queryBill (int ID){
		Bill bill = new Bill();
		return bill;
	}
	
	public boolean queryInsertBill (int ID){ //ID von Offer
		boolean success = false;
		return success;
	}
	
	public boolean queryExistBill (int ID){ //ID von Offer
		boolean success = false;
		return success;
	}

	
public static void main (String[] args){
		
		DBManager DBM = new DBManager();
		
		DBM.open();
		
		/*Article article = new Article(1,"Buch", "Ein beispielhaftes Buch", "Box", "Beispielbuch5", "Kein Foto", "3859891302715", "BN12349");
		if (DBM.queryInsertArticle(article)){
			System.out.println("Artikel eingefügt");
		}
		else {
			System.out.println("Artikel wurde nicht eingefügt");
		}
		*/
		//Offer offer = new Offer(-1,3.00f,4.00f, "2000-11-30", "2000-12-30", "http:\\www.123.de", 1,1,1, "", "Bol.de") ;
		//DBM.queryInsertOffer(offer);
		//System.out.println(offer.getStart().toString());
		
		//boolean success=DBM.queryInsertOffer(offer);
		
		//System.out.print(offer.getArticle_Name());
				
		//LinkedList<Offer> offer = DBM.queryAllOffers(1);
		//System.out.print(offer.get(1));
		//Article article = DBM.queryArticleDetails(2);
		//System.out.print(article.getName());
		DBM.close();
		
}
}


