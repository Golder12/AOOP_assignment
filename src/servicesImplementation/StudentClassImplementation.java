package servicesImplementation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DatabaseManager.DbConnection;
import models.Student;
import models.StudentClass;
import models.Subject;
import services.StudentClassService;

public class StudentClassImplementation implements StudentClassService {

	private static Connection con = DbConnection.createConnection();
	
	@Override
	public void saveStudentClass(StudentClassService studentClass) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<StudentClass> getAllStudentClasses() {
		List<StudentClass> allStudentClasses = new ArrayList<>();
		
		Statement st;
		try {
			st = con.createStatement();
			String sql = "SELECT * FROM StudentClass";
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				StudentClass subject = new StudentClass();
				subject.setName(rs.getString("nameOfClass"));
				allStudentClasses.add(subject);
			}		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return allStudentClasses;
	}

	@Override
	public StudentClass getClassOfName(String studentClassName) {
		try {
			
			Statement st = con.createStatement();
			String sql = "SELECT * FROM StudentClass WHERE  nameOfClass= '" + studentClassName + "'";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				StudentClass studentClass = new StudentClass();
				
				studentClass.setName(studentClassName);
				return studentClass;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
