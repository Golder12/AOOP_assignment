package services;

import java.util.List;

import models.Subject;

public interface SubjectService{
	
	List<Subject> getAllSubjects();
	
	void saveSubject(Subject subject);
	
	Subject getSubjectOfName(String subjectName);
	

}
