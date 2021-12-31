package services;

import java.util.List;

import models.Subject;

/**
 * This is the interface providing methods for the 
 *Subject model
 *
 */
public interface SubjectService{
	
	/**
	 * Gets all subjects
	 * @return a list of subjects
	 */
	List<Subject> getAllSubjects();
	
	
	/**
	 * gets a subject when provided with its name
	 * 
	 * 
	 * @param subjectName
	 * @return a Subject object
	 */
	Subject getSubjectOfName(String subjectName);
	

}
