package servicesImplementation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DatabaseManager.DbConnection;
import models.StudentClass;
import models.Subject;
import models.Timetable;
import services.TimetableService;

public class TimetableImplementation implements TimetableService {

	private static Connection con = DbConnection.createConnection();
	
	
	/**
	 * saves a timetable entry which consists of the time period of teaching,
	 * the class being taught as well as the subject being taught
	 * @param timetableEntry
	 */
	@Override
	public void saveTimeTableEntry(Timetable timetableEntry) {
		
		String dayToUpdate = "";
		
		String classToUpdate = timetableEntry.getStudentClass().getName();
		
		String timeToUpdate = timetableEntry.getTimeOfTeaching();
		
		String subjectFillingTime = timetableEntry.getSubject().getName();
		
		
		
		if(timetableEntry.getMonday() != null)
			dayToUpdate = "Monday";
		else if(timetableEntry.getTuesday() != null)
			dayToUpdate = "Tuesday";
		else if(timetableEntry.getWednesday() != null)
			dayToUpdate = "Wednesday";
		else if(timetableEntry.getThursday() != null)
			dayToUpdate = "Thursday";
		else
			dayToUpdate = "Friday";
		
		
		if(timeToUpdate.equals("7:00 - 9:00"))
			timeToUpdate = "SevenToNine";
		else if(timeToUpdate.equals("9:00 - 10:30"))
			timeToUpdate = "NineToTenThirty";
		else if(timeToUpdate.equals("11:00 - 1:00"))
			timeToUpdate = "ElevenToOne";
		else if(timeToUpdate.equals("2:00 - 3:00"))
			timeToUpdate = "TwoToThree";
		else 
			timeToUpdate = "ThreeToFour";
		
		
		try {
			Statement st = con.createStatement();
			String sql = "UPDATE Timetables SET " + dayToUpdate + " = '" + subjectFillingTime + "' WHERE TimeOfTeaching = '" + timeToUpdate + "' AND  StudentClass = '" + classToUpdate + "'" ;
			st.executeUpdate(sql);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

	
	/**
	 * Gets all the timetable information that has been recorded
	 * @return
	 */
	@Override
	public List<Timetable> getTimetableEntriesOfClass() {
		
		StudentClass classOfTeacher = null;
		String nameOfClass = "";
		
		StudentClass classOfStudent = null;
		
		Subject subject = null;
		if(TeacherImplementation.loggedInTeacher != null) {
			classOfTeacher = TeacherImplementation.loggedInTeacher.getStudentClass();
			subject = TeacherImplementation.loggedInTeacher.getSubject();
			nameOfClass = classOfTeacher.getName();
		}else {
			classOfStudent = StudentImplementation.loggedInStudent.getStudentClass();
			nameOfClass = classOfStudent.getName();
		}
		
		
		
		List<Timetable> timetableEntriesOfClass = new ArrayList<>();
		
		try {
			
			Statement st = con.createStatement();
			String sql = "SELECT * FROM Timetables WHERE StudentClass='" + nameOfClass + "'ORDER BY TimeOrder ASC";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				Timetable timetable = new Timetable();
				
				timetable.setTimeOfTeaching(rs.getString("TimeOfTeaching"));
				
				if(classOfTeacher != null)
					timetable.setStudentClass(classOfTeacher);
				else
					timetable.setStudentClass(classOfStudent);
				
				timetable.setSubject(subject);
				
				if(rs.getString("Monday") == null)
					timetable.setMonday("Free");
				else
					timetable.setMonday(rs.getString("Monday"));
				
				if(rs.getString("Tuesday") == null)
					timetable.setTuesday("Free");
				else
					timetable.setTuesday(rs.getString("Tuesday"));
				
				if(rs.getString("Wednesday") == null)
					timetable.setWednesday("Free");
				else
					timetable.setWednesday(rs.getString("Wednesday"));
				
				if(rs.getString("Thursday") == null)
					timetable.setThursday("Free");
				else
					timetable.setThursday(rs.getString("Thursday"));
				
				if(rs.getString("Friday") == null)
					timetable.setFriday("Free");
				else
					timetable.setFriday(rs.getString("Friday"));
				
				
				
				timetableEntriesOfClass.add(timetable);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return timetableEntriesOfClass;
	}

	}


