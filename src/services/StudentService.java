package services;

import java.sql.SQLException;
import java.util.List;

import models.Student;
import models.Subject;

public interface StudentService {
	
	void saveStudent(Student student) throws SQLException;
	
	List<Student> getAllStudents() throws SQLException;
	
	void printAllStudents() throws SQLException;
	
	void showClassTimetable();
	
	List<Student> getStudentsOfClassAndSubject();
	
	Student getStudentOfRegNo(String registrationNumber);
	
	void saveStudentMark(Student student);
	
	boolean loginStudent(Student student);
	
	List<Subject> getSubjectMarksOfStudent();
	
	

}
