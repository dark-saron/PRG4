package de.fhe.ai.prg4;
import java.sql.*;

import com.mysql.*;
import com.mysql.jdbc.PreparedStatement;

public class DBManager {
	
	static final String PATH_DRIVER_JDBC 	= "com.mysql.jdbc.Driver";
	static final String PATH_DB 			= "jdbc:mysql://localhost/mydb";
	static final String USER 				= "root" ;
	static final String PASSWORT 			= "";
	
	private static  Connection 	CONNECTION	= null;
	private static Statement STATEMENT 		= null;
	private static ResultSet RESULT_SET 	= null;;
		
	
	// called once!!! at start
	public static void open(){
		try {
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
	
	public static void getResultSet (String _query){
		try {
			RESULT_SET = STATEMENT.executeQuery(_query);
			////////////////////// TESTZWECKE
			while(RESULT_SET.next())
			{
				 System.out.println(RESULT_SET.toString() );
				 System.out.println(RESULT_SET.getString("Username") );
			}
			////////////////////////
			STATEMENT.close();
		} catch (Exception e) {	
			e.printStackTrace();
		}
	}
	//public List<String> 
}


