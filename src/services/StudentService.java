package services;

import java.sql.SQLException;
import java.util.List;

import models.Student;
import models.Subject;

/**
 * This is the interface providing methods for the 
 *Student model
 *
 */
public interface StudentService {
	
	/*
	 * This method saves a student
	 */
	void saveStudent(Student student) throws SQLException;
	
	
	/*
	 * This method gets all saved students
	 */
	List<Student> getAllStudents() throws SQLException;
	
	
	/*
	 * This method shows a timetable for a certain class
	 */
	void showClassTimetable();
	
	List<Student> getStudentsOfClassAndSubject();
	
	Student getStudentOfRegNo(String registrationNumber);
	
	void saveStudentMark(Student student);
	
	boolean loginStudent(Student student);
	
	List<Subject> getSubjectMarksOfStudent();
	
	Student getLoggedInStudentDetails();
	

}
