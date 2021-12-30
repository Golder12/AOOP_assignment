package services;

import java.util.List;

import models.Subject;

/**
 * This is the interface providing methods for the 
 *Subject model
 *
 */
public interface SubjectService{
	
	List<Subject> getAllSubjects();
	
	void saveSubject(Subject subject);
	
	Subject getSubjectOfName(String subjectName);
	

}
