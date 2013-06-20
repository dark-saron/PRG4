package de.fhe.ai.prg4.io_database;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import com.mysql.*;
import com.mysql.jdbc.PreparedStatement;

import de.fhe.ai.prg4.model.Article;
import de.fhe.ai.prg4.model.Bill;
import de.fhe.ai.prg4.model.Contact;
import de.fhe.ai.prg4.model.Offer;
import de.fhe.ai.prg4.model.User;

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
				//System.out.println(RESULT_SET.getInt("ID"));
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
	Article article = new Article();
		return article;
	}
	
	public boolean queryInsertArticle (Article article){
		boolean success=false;
		return success;
	}
	
	public boolean queryUpdateArticle (Article article){
		boolean success=false;
		return success;
	}
	
	public boolean queryDeleteArticle (int id){
		boolean success=false;
		return success;
	}

	//Offers
	
	public LinkedList<Offer> queryAllOffers(int UserID){
		try {
			LinkedList<Offer> list1 = new LinkedList<Offer>();
			
			RESULT_SET = STATEMENT.executeQuery("SELECT ID,Type,Name FROM article");
			/*
			Offer offer;
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

	
/*public static void main (String[] args){
		
		DBManager DBM = new DBManager();
		
		DBM.open();
		
		DBM.close();
		
}*/
	

}


