package DatabaseManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SubjectsTable {
	
public static void main(String args[]) {
		
		Connection con = DbConnection.createConnection();
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(createSubjectsTable());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static String createSubjectsTable() {
		
		String sql = "CREATE TABLE Subjects"+
					"(subjectName VARCHAR(255)," +
					"PRIMARY KEY(subjectName))";
		
		return sql;
	}

}
