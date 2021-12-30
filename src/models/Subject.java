package models;

import java.util.List;

/**
 * 
 *  This model describes the 'Subject'
 * entity and the attributes it can hold.
 * 
 * The Subject entity represents a 
 * subject taught in Katikamu primary school
 *
 */
public class Subject {

	
	private String name;				//name of the subject
	private Teacher subjectTeacher;		//teacher teaching the subject
	private StudentClass studentClass;	//class in which the subject is taught
	private List<Student> students;		//students learning the subject
	private String subjectMark;			//mark being held by a student in the subject
	
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
