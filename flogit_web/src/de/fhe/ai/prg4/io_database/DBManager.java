package de.fhe.ai.prg4.io_database;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import com.mysql.*;
import com.mysql.jdbc.PreparedStatement;

import de.fhe.ai.prg4.model.Article;

public class DBManager {
	
	static final String PATH_DRIVER_JDBC 	= "com.mysql.jdbc.Driver";
	static final String PATH_DB 			= "jdbc:mysql://localhost/mydb";
	static final String USER 				= "admin" ;
	static final String PASSWORT 			= "admin";
	
	private static  Connection 	CONNECTION	= null;
	private static Statement STATEMENT 		= null;
	private static ResultSet RESULT_SET 	= null;
	private static boolean link = false;	//Datenbankverbindung steht
		
	
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
	
	

	/*public static void getResultSet (String _query){
		try {
			
			RESULT_SET = STATEMENT.executeQuery(_query);
			
			////////////////////// TESTZWECKE
			while(RESULT_SET.next())
			{
				 System.out.println(RESULT_SET.toString() );
				 System.out.println(RESULT_SET.getString("pw") );
			}
			////////////////////////
			
			STATEMENT.close();

			
		} catch (Exception e) {	
			e.printStackTrace();
		}
		

	}
	*/
	public List<Article> queryallarticles(){
		try {
			RESULT_SET = STATEMENT.executeQuery("SELECT ID,Type,Name FROM article");
			
			List<Article> list1 = new LinkedList<Article>();
			Article artikel;
			while (RESULT_SET.next()){
				artikel = new Article();
				System.out.println(RESULT_SET.getInt("ID"));
		
				artikel.setType(RESULT_SET.getString("Type"));
				artikel.setName(RESULT_SET.getString("Name"));
				list1.add(artikel);
				
			}
			return list1;
		}
		catch (SQLException e){
			System.out.println(e);
			return null;
		}	
	}
	
	
	
	
	//public List<String> 
	
public static void main (String[] args){
		
		DBManager DBM = new DBManager();
		
		DBM.open();
		List<Article> list1 = DBM.queryallarticles();
		
		System.out.println(list1);
		
		DBM.close();
		
}
	

}


