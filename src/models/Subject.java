package models;

import java.util.List;

public class Subject {

	
	private String name;
	private Teacher subjectTeacher;
	private StudentClass studentClass;
	private List<Student> students;
	private String subjectMark;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the studentClass
	 */
	public StudentClass getStudentClass() {
		return studentClass;
	}

	/**
	 * @param studentClass the studentClass to set
	 */
	public void setStudentClass(StudentClass studentClass) {
		this.studentClass = studentClass;
	}

	/**
	 * @return the students
	 */
	public List<Student> getStudents() {
		return students;
	}

	/**
	 * @param students the students to set
	 */
	public void setStudents(List<Student> students) {
		this.students = students;
	}

	/**
	 * @return the subjectTeacher
	 */
	public Teacher getSubjectTeacher() {
		return subjectTeacher;
	}

	/**
	 * @param subjectTeacher the subjectTeacher to set
	 */
	public void setSubjectTeacher(Teacher subjectTeacher) {
		this.subjectTeacher = subjectTeacher;
	}
	
@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}

/**
 * @return the subjectMark
 */
public String getSubjectMark() {
	return subjectMark;
}

/**
 * @param subjectMark the subjectMark to set
 */
public void setSubjectMark(String subjectMark) {
	this.subjectMark = subjectMark;
}
	
	
}
