package models;

import java.util.List;

public class Student {
	
	private int id;
	private String firstName;
	private String lastName;
	private String registrationNumber;
	private char gender;
	private int age;
	private List<Subject> subjects;
	private StudentClass studentClass;
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
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
		// TODO Auto-generated method stub
		String toDisplay = lastName + firstName;
		
		return toDisplay;
	}
	
}
