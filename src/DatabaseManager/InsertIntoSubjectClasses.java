package DatabaseManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertIntoSubjectClasses {

public static void main(String args[]) {
		
		Connection con = DbConnection.createConnection();
		try {
			Statement stmt = con.createStatement();
			
			String sql = "INSERT INTO SubjectsClass VALUES ('English','One')";
			stmt.executeUpdate(sql);
			String sql1 = "INSERT INTO SubjectsClass VALUES ('Maths','Two')";
			stmt.executeUpdate(sql1);
			String sql2 = "INSERT INTO SubjectsClass VALUES ('Science','Six')";
			stmt.executeUpdate(sql2);
			String sql3 = "INSERT INTO SubjectsClass VALUES ('SocialStudies','Seven')";
			stmt.executeUpdate(sql3);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
