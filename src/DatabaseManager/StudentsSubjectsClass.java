package DatabaseManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentsSubjectsClass {
	
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
		
		String sql = "CREATE TABLE StudentsSubjectsClass"+
					"(studentRegNo VARCHAR(255) NOT NULL," + 
					"StudentClass VARCHAR(255) NOT NULL," + 
					"SubjectName VARCHAR(255) NOT NULL," + 
					"StudentMark INTEGER," +
					"PRIMARY KEY(studentRegNo, SubjectName, StudentClass)," +
					"FOREIGN KEY (studentRegNo) references Students(registrationNumber)," + 
					"FOREIGN KEY (SubjectName) references Subjects(subjectname),"+
					"FOREIGN KEY (StudentClass) references StudentClass(nameOfClass))";
		
		return sql;
	}

}
