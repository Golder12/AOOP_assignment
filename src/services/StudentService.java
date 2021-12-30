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
	 * Saves a student
	 */
	void saveStudent(Student student) throws SQLException;
	
	
	/*
	 * Gets all saved students
	 */
	List<Student> getAllStudents() throws SQLException;
	
	
	/*
	 * Shows a timetable for a certain class
	 */
	void showClassTimetable();
	
	
	/*
	 * Gets Students of a particular class 
	 * registered for a particular subject
	 */
	List<Student> getStudentsOfClassAndSubject();
	
	/*
	 * Gets student of a provided registration
	 * Number
	 */
	Student getStudentOfRegNo(String registrationNumber);
	
	/*
	 * Saves a student's mark in a particula
	 */
	void saveStudentMark(Student student);
	
	boolean loginStudent(Student student);
	
	List<Subject> getSubjectMarksOfStudent();
	
	Student getLoggedInStudentDetails();
	

}
