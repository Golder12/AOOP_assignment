package servicesImplementation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DatabaseManager.DbConnection;
import models.Subject;
import services.SubjectService;

public class SubjectServiceImplementation implements SubjectService{
	
	private static Connection con = DbConnection.createConnection();

	
	/**
	 * Gets all subjects
	 * @return a list of subjects
	 */
	@Override
	public List<Subject> getAllSubjects() {
		
		List<Subject> allSubjects = new ArrayList<>();
		
		Statement st;
		try {
			st = con.createStatement();
			String sql = "SELECT * FROM Subjects";
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				Subject subject = new Subject();
				subject.setName(rs.getString("subjectName"));
				allSubjects.add(subject);
			}		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return allSubjects;
	}

	/**
	 * gets a subject when provided with its name
	 * 
	 * 
	 * @param subjectName
	 * @return a Subject object
	 */
	@Override
	public Subject getSubjectOfName(String subjectName) {
		try {
			
			Statement st = con.createStatement();
			String sql = "SELECT * FROM Subjects WHERE subjectName = '" + subjectName + "'";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				Subject subject = new Subject();
				subject.setName( rs.getString("subjectName"));
				return subject;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	
	
}
