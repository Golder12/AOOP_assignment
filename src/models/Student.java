package models;

import java.util.List;

/**
 * This model describes the 'Student'
 * entity and the attributes it can hold.
 * 
 * The Student entity represents a student
 * in Katikamu primary school
 * 
 *
 */
public class Student {
	
	private String firstName;				//first name of a student
	private String lastName;				//last name of a student
	private String registrationNumber;		//registration Number of a student
	private char gender;					//gender of the student
	private int age;						//age of the student
	private List<Subject> subjects;			//subjects being learned by the student
	private StudentClass studentClass;		//class of the student
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the gender
	 */
	public char getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(char gender) {
		this.gender = gender;
	}
	/**
	 * @return the registrationNumber
	 */
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	/**
	 * @param registrationNumber the registrationNumber to set
	 */
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	
	/**
	 * @return the subjects
	 */
	public List<Subject> getSubjects() {
		return subjects;
	}
	/**
	 * @param subjects the subjects to set
	 */
	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
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
	
	
	@Override
	public String toString() {

		String toDisplay = lastName + firstName;
		
		return toDisplay;
	}
	
}
