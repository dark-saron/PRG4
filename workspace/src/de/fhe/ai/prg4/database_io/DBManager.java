package de.fhe.ai.prg4.database_io;
import java.sql.*;
import java.util.LinkedList;

import com.mysql.*;
import com.mysql.jdbc.PreparedStatement;
import com.sun.org.apache.xalan.internal.xsltc.compiler.Parser;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import de.fhe.ai.prg4.model.Article;

public class DBManager {
	
	static final String PATH_DRIVER_JDBC 	= "com.mysql.jdbc.Driver";
	static final String PATH_DB 			= "jdbc:mysql://localhost/mydb";
	static final String USER 				= "root" ;
	static final String PASSWORT 			= "callofduty";
	
	private static  Connection 	CONNECTION	= null;
	
	private static Statement STATEMENT 		= null;
	private static ResultSet RESULT_SET 	= null;;
		
	
	// called once!!! at start
	public static void open(){
		try {
			Class.forName(PATH_DRIVER_JDBC).newInstance();
			CONNECTION 	= DriverManager.getConnection(PATH_DB,USER,PASSWORT);
			STATEMENT 	= CONNECTION.createStatement();

		
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
	
	

	public static LinkedList<Article> queryAllArticle (){
		
		LinkedList<Article> list = new LinkedList<Article>();
		
		try {
			
			RESULT_SET = STATEMENT.executeQuery("SELECT * FROM article");
			String test ="";
			
			////////////////////// TESTZWECKE
			while(RESULT_SET.next())
			{
				Article art = new Article();
				art.setId(RESULT_SET.getInt("ID"));
				art.setType(RESULT_SET.getString("Type"));
				art.setName(RESULT_SET.getString("Name"));
				list.add(art);
			}
			////////////////////////
			for (Article article : list) {
				 System.out.println(article.getId() );
			}
			
			
			STATEMENT.close();

			
		} catch (Exception e) {	
			e.printStackTrace();
		}
		return list;
		

	}
	
	

	
	//public List<String> 
	
public static void main (String[] args){
		
		DBManager DBM = new DBManager();
		
		DBM.open();
		//DBM.getResultSet();
		DBM.close();
		
}
	

}


