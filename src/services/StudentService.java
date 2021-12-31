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
	
	/**
	 *  Saves a student
	 * @param student
	 * @throws SQLException
	 */
	void saveStudent(Student student) throws SQLException;
	
	
	/**
	 * Gets all saved students
	 * @return
	 * @throws SQLException
	 */
	List<Student> getAllStudents() throws SQLException;
	
	
	
	/**
	 * Gets Students of a particular class 
	 * registered for a particular subject
	 * @return
	 */
	List<Student> getStudentsOfClassAndSubject();
	
	/**
	 *  Gets student of a provided registration
	 * Number
	 * @param registrationNumber
	 * @return
	 */
	Student getStudentOfRegNo(String registrationNumber);
	
	/**
	 * Saves a student's mark in a particular 
	 * subject;
	 * @param student
	 */
	void saveStudentMark(Student student);
	
	/**
	 * Handles the logging in of a student
	 * @param student
	 * @return a boolean value;  true if the student is registered
	 */
	boolean loginStudent(Student student);
	
	
	/**
	 *  Gets the subject marks of a student
	 * @return a list of subjects with a student's marks attached
	 */
	List<Subject> getSubjectMarksOfStudent();
	
	/**
	 * Gets the details of a student who is
	 * logged in
	 * @return a student
	 */
	Student getLoggedInStudentDetails();
	

}
