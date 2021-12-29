package DatabaseManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ClassSubjectsTable {

	public static void main(String args[]) {
		
		Connection con = DbConnection.createConnection();
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(createSubjectsClassTable());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static String createSubjectsClassTable() {
		
		String sql = "CREATE TABLE SubjectsClass"+
					"(subjectName VARCHAR(255),"
					+ "studentClass VARCHAR(255)," +
					"PRIMARY KEY(subjectName, studentClass),"+
					"FOREIGN KEY (subjectName) references Subjects(subjectName),"+
					"FOREIGN KEY (studentClass) references StudentClass(nameOfClass))";
		
		return sql;
	}
	
}
