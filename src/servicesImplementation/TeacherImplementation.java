package servicesImplementation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DatabaseManager.DbConnection;
import models.Subject;
import models.Teacher;
import services.TeacherService;

public class TeacherImplementation implements TeacherService{
	
	protected static Teacher loggedInTeacher;
	
	private static Connection con = DbConnection.createConnection();

	@Override
	public void saveTeacher(Teacher teacher) {
		
		
		try {
			
			String teacherSubject = teacher.getSubject().getName();
			String teacherClass = teacher.getStudentClass().getName();
			
			Statement st;
			st = con.createStatement();
			
			String sql = "INSERT INTO Teachers(firstName,lastName,phoneNumber,SubjectTaught,studentClass,password) VALUES('" +  teacher.getFirstName() + "','" + teacher.getLastName() + "','" + teacher.getPhoneNumber() + "', '" + teacherSubject + "','" + teacherClass  + "','" + teacher.getPassword() + "')";
			
			st.executeUpdate(sql);			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

}

	@Override
	public boolean loginTeacher(Teacher teacher) {
		
		try {
			Statement st;
			st = con.createStatement();
			
			String trialFirstName = teacher.getFirstName();
			String trialPassword = teacher.getPassword();
			
			String sql = "SELECT * FROM Teachers";
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				String recordedFirstName = rs.getString("firstName");
				String recordedPassword = rs.getString("password");
				
				if(trialFirstName.equals(recordedFirstName))
					if(trialPassword.equals(recordedPassword)) {
						String sql1 = "SELECT firstName,lastName,SubjectTaught,studentClass FROM Teachers WHERE password = '" + trialPassword +"'";
						ResultSet rs1 = st.executeQuery(sql1);
						while(rs1.next()) {
							loggedInTeacher = teacher;
						}
						return true;
					}
				
			}		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
}
