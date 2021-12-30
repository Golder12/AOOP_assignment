package services;

import java.util.List;

import models.StudentClass;

public interface StudentClassService {
	
	void saveStudentClass(StudentClassService studentClass);

	List<StudentClass> getAllStudentClasses();
	
	StudentClass getClassOfName(String studentClassName);
}
