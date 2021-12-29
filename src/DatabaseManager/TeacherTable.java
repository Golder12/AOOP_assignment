package DatabaseManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TeacherTable {

public static void main(String args[]) {
		
		Connection con = DbConnection.createConnection();
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(createTeachersTable());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static String createTeachersTable() {
		
		String sql = "CREATE TABLE Teachers"+
					"(firstName VARCHAR(255)," +
					"lastName VARCHAR(255),"+
					"phoneNumber VARCHAR(255),"+
					"SubjectTaught VARCHAR(255)," + 
					"studentClass VARCHAR(255)," +
					"password VARCHAR(255)," +
					"PRIMARY KEY(SubjectTaught, studentClass))" ;
		
		return sql;
	}
	
}
