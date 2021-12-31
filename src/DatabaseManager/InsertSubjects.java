package DatabaseManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertSubjects {

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
		
		String sql = "CREATE TABLE Timetables"+
					"(studentClass VARCHAR )";
		
		return sql;
	}
	
}
