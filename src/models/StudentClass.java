package models;

import java.util.List;

/**
 * 
 *  This model describes the 'StudentClass'
 * entity and the attributes it can hold.
 * 
 * The StudentClass entity represents a 
 * learning class in Katikamu primary school
 *
 */
public class StudentClass {
	
	private String name;			//name of the class
	private List<Subject> subjects;	//subjects taught in the class

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	
	@Override
	public String toString() {
		return name;
	}
	

}
