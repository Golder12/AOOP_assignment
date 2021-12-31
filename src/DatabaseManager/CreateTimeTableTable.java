package DatabaseManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTimeTableTable {
	
public static void main(String args[]) {
		
		Connection con = DbConnection.createConnection();
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(createStudentsSubjectsClass());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static String createStudentsSubjectsClass() {
		
		String sql = "CREATE TABLE Timetables"+
					"(StudentClass VARCHAR(255) NOT NULL," + 
					"TimeOfTeaching VARCHAR(255) NOT NULL," + 
					"TimeOrder INTEGER," +
					"Monday VARCHAR(255)," + 
					"Tuesday VARCHAR(255)," + 
					"Wednesday VARCHAR(255)," + 
					"Thursday VARCHAR(255)," + 
					"Friday VARCHAR(255)," + 
					"PRIMARY KEY(StudentClass, TimeOfTeaching)," +
					"FOREIGN KEY (StudentClass) references StudentClass(nameOfClass))";
		
		return sql;
	}
	

}
