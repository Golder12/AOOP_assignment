package DatabaseManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentClassTable {

public static void main(String args[]) {
		
		Connection con = DbConnection.createConnection();
		try {
			Statement stmt = con.createStatement();

			
			String sql = "INSERT INTO StudentClass VALUES ('One')";
			stmt.executeUpdate(sql);
			String sql1 = "INSERT INTO StudentClass VALUES ('Two')";
			stmt.executeUpdate(sql1);
			String sql2 = "INSERT INTO StudentClass VALUES ('Three')";
			stmt.executeUpdate(sql2);
			String sql3 = "INSERT INTO StudentClass VALUES ('Four')";
			stmt.executeUpdate(sql3);
			String sql4 = "INSERT INTO StudentClass VALUES ('Five')";
			stmt.executeUpdate(sql4);
			String sql5 = "INSERT INTO StudentClass VALUES ('Six')";
			stmt.executeUpdate(sql5);
			String sql6 = "INSERT INTO StudentClass VALUES ('Seven')";
			stmt.executeUpdate(sql6);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static String createStudentClassTable() {
		
		String sql = "CREATE TABLE StudentClass"+
					"(nameOfClass VARCHAR(255),"+
					"PRIMARY KEY(nameOfClass))";
		
		return sql;
	}
	
	
}
