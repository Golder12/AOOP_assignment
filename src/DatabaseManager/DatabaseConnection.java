package DatabaseManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
static Connection con = null;
static Connection conDb = null;
	
	public DatabaseConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection createConnectionForDatabase() {
		try {
			
			
			Connection conDb = DriverManager.getConnection("jdbc:mysql://localhost?autoReconnect=true&useSSL=false", "root", "dokigolder");
			return conDb;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static Connection createConnection() {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/RMS_J?autoReconnect=true&useSSL=false", "root", "dokigolder");
			return con;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
