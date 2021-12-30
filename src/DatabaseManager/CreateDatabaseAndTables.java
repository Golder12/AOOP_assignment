package DatabaseManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabaseAndTables {
	
	public static void main(String[] args) {
		
		try {
			Connection conDb =  DatabaseConnection.createConnectionForDatabase();
			Statement st = conDb.createStatement();
			st.executeUpdate(createDatabaseRms());
			
			Connection con = DatabaseConnection.createConnection();
			Statement stmt = con.createStatement();
			
			stmt.executeUpdate(createStudentClassTable());
			
			/*
			 * 	Inserting into student class table.
			 * 	The values being inserted are those
			 * of the primary classes in our primary school.
			 * 
			 */
			String[] studentClasses = {"One", "Two", "Three", "Four", "Five", "Six", "Seven"};
			for(String studentClass:studentClasses) {
					String sql = "INSERT INTO StudentClass VALUES('" +  studentClass + "')";
					stmt.executeUpdate(sql);
			}
			
			stmt.executeUpdate(createStudentsTable());
			stmt.executeUpdate(createSubjectsTable());
			
			/*
			 * 	Inserting into subjects table.
			 * 	The values being inserted are those of
			 * subjects that are taught in our primary
			 * school.
			 * 
			 */
			String[] subjects = {"English", "Maths", "Science","Social Studies"};
			for(String subject:subjects) {
				String sql = "INSERT INTO Subjects VALUES('" +  subject + "')";
				stmt.executeUpdate(sql);
			}
			
			stmt.executeUpdate(createTeachersTable());
			stmt.executeUpdate(createTimeTablesTable());
			
			/*
			 * 
			 * Inserting into the table holding the timetable
			 * organization.
			 * The values being inserted are:
			 * 	- studentClass
			 * 	- the time for which the class is taught e.g English from seven 
			 * to nine thirty
			 * 	- and a value signifying the order of the times at which the students 
			 * are taught e.g Seven to Nine have a TimeOrder of 1 implies it is the 
			 * first period of the day followed by whichever has a TimeOrder of 2.
			 * 
			 */
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
			
			
			stmt.executeUpdate(createSubjectsClassTable());
			
			/*
			 * 
			 * Inserting into the subjects-Classes table.
			 * The values being inserted are of the subjects
			 * and classes at which they are taught
			 * 
			 */
			for(String studentClass : studentClasses) {
				String sql = "INSERT INTO SubjectsClass(SubjectName, studentClass) VALUES ('English','" +studentClass+"')";
				stmt.executeUpdate(sql);
				String sq2 = "INSERT INTO SubjectsClass(SubjectName, studentClass) VALUES ('Maths','" +studentClass+"')";
				stmt.executeUpdate(sq2);
				String sq3 = "INSERT INTO SubjectsClass(SubjectName, studentClass) VALUES ('Science','" +studentClass+"')";
				stmt.executeUpdate(sq3);
				String sq4 = "INSERT INTO SubjectsClass(SubjectName, studentClass) VALUES ('Social Studies','" +studentClass+"')";
				stmt.executeUpdate(sq4);
				
			}
			
			stmt.executeUpdate(createStudentsSubjectsClassTable());
						
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/*
	 * 
	 * Creates the database to use for this application.
	 * The database is called RMS_J
	 * 
	 */
	public static String createDatabaseRms() {
		
		String sql = "CREATE DATABASE RMS_J";
		
		return sql;
	}
	
	
	/*
	 * 
	 * Creating a table to store students and their details
	 * 
	 */
	public static String createStudentsTable() {
		
		String sql = "CREATE TABLE Students"+
					"(firstName VARCHAR(255)," + 
					"lastName VARCHAR(255)," +
					"registrationNumber VARCHAR(255),"+
					"gender VARCHAR(1)," + 
					"age INTEGER ," + 
					"studentClass VARCHAR(255),"+
					"PRIMARY KEY(registrationNumber)," + 
					"FOREIGN KEY (studentClass) REFERENCES StudentClass(nameOfClass))";
		
		return sql;
	}
	

	/*
	 * 
	 * Creating a table to store subjects and their details
	 * 
	 */
	public static String createSubjectsTable() {
		
		String sql = "CREATE TABLE Subjects"+
					"(subjectName VARCHAR(255)," +
					"PRIMARY KEY(subjectName))";
		
		return sql;
	}

	
	/*
	 * 
	 * Creating a table to store classes of students
	 * 
	 */
	public static String createStudentClassTable() {
	
	String sql = "CREATE TABLE StudentClass"+
				"(nameOfClass VARCHAR(255),"+
				"PRIMARY KEY(nameOfClass))";
	
	return sql;
	}
	
	
	/*
	 * 
	 * Creating a table to store teachers and their details
	 * 
	 */
	public static String createTeachersTable() {
		
		String sql = "CREATE TABLE Teachers"+
					"(firstName VARCHAR(255)," +
					"lastName VARCHAR(255),"+
					"phoneNumber VARCHAR(255),"+
					"SubjectTaught VARCHAR(255)," + 
					"studentClass VARCHAR(255)," +
					"password VARCHAR(255)," +
					"PRIMARY KEY(SubjectTaught, studentClass))" ;
		
		return sql;
	}

	/*
	 * 
	 * Creating a table to store timetables and their details
	 * 
	 */
	public static String createTimeTablesTable() {
	
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
	
	
	/*
	 * 
	 * Creating an associative table SubjectsClass.
	 * It is the result of the many-to-many relationship between 
	 * subjects and classes.It contains foreign keys
	 * from subjects table and student class table.
	 * 
	 */
	public static String createSubjectsClassTable() {
		
		String sql = "CREATE TABLE SubjectsClass"+
					"(SubjectName VARCHAR(255),"
					+ "studentClass VARCHAR(255)," +
					"PRIMARY KEY(subjectName, studentClass),"+
					"FOREIGN KEY (studentClass) references StudentClass(nameOfClass)," +
					"FOREIGN KEY (SubjectName) references Subjects(subjectName))";
		
		return sql;
	}
	
	
	/*
	 * 
	 * Creating an associative table Students-SubjectsClass.
	 * It is the result of the many-ton-many association between 
	 * 'subjects taught in a class' and 'students'. It contains 
	 * foreign keys from 'students','subjects' and 'student class'.
	 * 
	 */
	public static String createStudentsSubjectsClassTable() {
		
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
