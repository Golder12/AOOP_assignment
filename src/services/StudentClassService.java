package services;

import java.util.List;

import models.StudentClass;

/**
 *This is the interface providing methods for the 
 *StudentClass model
 *
 *
 *
 */
public interface StudentClassService {
	
	/*
	 * This method is to save a studentclass.
	 */
	void saveStudentClass(StudentClassService studentClass);

	/*
	 * This method retrieves all the studentClasses
	 * available.
	 */
	List<StudentClass> getAllStudentClasses();
	
	/*
	 * This method gets a certain studentClass object
	 * when provided with a name
	 */
	StudentClass getClassOfName(String studentClassName);
}
