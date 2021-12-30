package DatabaseManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class InsertIntoTimetableTable {

	public static void main(String[] args) {
		
		Connection con = DbConnection.createConnection();
		try {
			Statement stmt = con.createStatement();
			
			String[] studentClasses = new String[7];
			
			String sql0 = "SELECT * FROM StudentClass";
			ResultSet rss = stmt.executeQuery(sql0);
			
			int i = 0;
			while(rss.next()) {
				String name = rss.getString("nameOfClass");
				studentClasses[i] = name;
				i++;
			}	
			
			for(String studentClass:studentClasses) {
				
				String sql = "INSERT INTO Timetables(StudentClass, TimeOfTeaching, TimeOrder) VALUES ('" + studentClass + "','SevenToNine','1')";
				stmt.executeUpdate(sql);
				String sql1 = "INSERT INTO Timetables(StudentClass, TimeOfTeaching, TimeOrder) VALUES ('" + studentClass + "','NineToTenThirty','2')";
				stmt.executeUpdate(sql1);
				String sql2 = "INSERT INTO Timetables(StudentClass, TimeOfTeaching, TimeOrder) VALUES ('" + studentClass + "','ElevenToOne','3')";
				stmt.executeUpdate(sql2);
				String sql3 = "INSERT INTO Timetables(StudentClass, TimeOfTeaching, TimeOrder) VALUES ('" + studentClass + "','TwoToThree','4')";
				stmt.executeUpdate(sql3);
				String sql4 = "INSERT INTO Timetables(StudentClass, TimeOfTeaching, TimeOrder) VALUES ('" + studentClass + "','ThreeToFour','5')";
				stmt.executeUpdate(sql4);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	
	}

}
