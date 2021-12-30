package DatabaseManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertSubjects {

public static void main(String args[]) {
		
		Connection con = DbConnection.createConnection();
		try {
			Statement stmt = con.createStatement();
<<<<<<< HEAD
			stmt.executeUpdate(createStudentsTable());
=======
			
			String sql = "INSERT INTO Subjects VALUES ('English')";
			stmt.executeUpdate(sql);
			String sql1 = "INSERT INTO Subjects VALUES ('Maths')";
			stmt.executeUpdate(sql1);
			String sql2 = "INSERT INTO Subjects VALUES ('Science')";
			stmt.executeUpdate(sql2);
			String sql3 = "INSERT INTO Subjects VALUES ('SocialStudies')";
			stmt.executeUpdate(sql3);
			
>>>>>>> e5258a11d0dd28cdf991a303ef4e4ed2f34c8595
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
<<<<<<< HEAD
	public static String createStudentsTable() {
		
		String sql = "CREATE TABLE Timetables"+
					"(studentClass VARCHAR )";
		
		return sql;
	}
	
=======
>>>>>>> e5258a11d0dd28cdf991a303ef4e4ed2f34c8595
}
