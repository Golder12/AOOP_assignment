package services;

import java.util.List;

import models.StudentClass;

/**
 *This is the interface providing methods for the 
 *StudentClass model
 *
 */
public interface StudentClassService {

	/**
	 * Returns student classes 
	 * @return a list of student classes
	 */
	List<StudentClass> getAllStudentClasses();
	
	/**
	 * This method gets a certain studentClass object
	 * when provided with a name
	 * @param studentClassName
	 * @return a student class
	 */
	StudentClass getClassOfName(String studentClassName);
}
