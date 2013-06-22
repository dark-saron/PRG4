package de.fhe.ai.prg4.io_database;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

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
			
			Article article = new Article();
			RESULT_SET.next();
		
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
		boolean success=false;
		
		try {
			
			String type=article.getType();
			String name=article.getName();
			String place=article.getPlace();
			String ean_isbn=article.getEan_Isbn();
			String externalID=article.getEan_Isbn();
			String description=article.getDescription();
			String photo=article.getPhoto();
			
			success=STATEMENT.execute("INSERT INTO article (Type,Name,Place,externalID,EAN_ISBN,Description,Photo) VALUES ('"+type+"','"+name+"','"+place+"','"+externalID+"','"+ean_isbn+"','"+description+"','"+photo+"'") ;
			
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
			
			int rows=STATEMENT.executeUpdate("Update article SET Type='"+newtype+"',Name='"+newname+"',Place='"+newplace+"',externalID='"+newexternalID+"',EAN_ISBN='"+newean_isbn+"',Description='"+newdescription+"',Photo='"+newphoto+"' WHERE ID ='"+article.getId()+"'");
			
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
			
			success=STATEMENT.execute("Delete LOW_PRIORITY FROM article WHERE ID ='"+id+"'");
			
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
		Offer offer = new Offer();
		return offer;
	}
	
	public boolean queryInsertOffer(Offer offer){
		boolean success = false;
		return success;
	}
	
	public boolean queryUpdateOffer(Offer offer){
		boolean success = false;
		return success;
	}
	
	public boolean queryDeleteOffer(int ID){
		boolean success = false;
		return success;
	}
	
	// Contacts
	
	public LinkedList<Contact> queryAllContacts(int UserID){
		try {
			RESULT_SET = STATEMENT.executeQuery("SELECT ID,Type,Name FROM article");
			
			LinkedList<Contact> list1 = new LinkedList<Contact>();
			
			/*Offer offer;
			while (RESULT_SET.next()){
				offer = new Offer();
				//System.out.println(RESULT_SET.getInt("ID"));
				article.setId(RESULT_SET.getInt("ID"));
				article.setType(RESULT_SET.getString("Type"));
				article.setName(RESULT_SET.getString("Name"));
				list1.add(article);
				
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

		LinkedList<Offer> offer = DBM.queryAllOffers(1);
		System.out.print(offer.get(1));
		//Article article = DBM.queryArticleDetails(2);
		//System.out.print(article.getName());
		DBM.close();
		
}
	

}


