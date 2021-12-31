package DatabaseManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class StudentsTable {
	
	
	
	public static void main(String args[]) {
		
		Connection con = DbConnection.createConnection();
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(createStudentsTable());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static String createStudentsTable() {
		
		String sql = "CREATE TABLE Students"+
					"(firstName VARCHAR(255)," + 
					"lastName VARCHAR(255)," +
					"registrationNumber VARCHAR(255),"+
					"gender VARCHAR(1)," + 
					"age INTEGER ," + 
					"studentClass VARCHAR(255),"+
					"PRIMARY KEY(registrationNumber)," + 
					"FOREIGN KEY (studentClass) REFERENCES StudentClass(nameOfClass))";
		
		return sql;
	}

}
