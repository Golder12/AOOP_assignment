package models;

/**
 * 
 *  This model describes the 'Timetable'
 * entity and the attributes it can hold.
 * 
 * The Timetable entity represents a 
 * a timetable of a given class in Katikamu primary school
 *
 */
public class Timetable {
	
	private StudentClass studentClass; 	//class to which the timetable belongs
	private String timeOfTeaching; 		//time period of a lesson
	private Subject subject;			//particular subject taught in the class
	
	//The following are attributes representing a particular
	//day of the week on which learning takes place.
	private String Monday; 
	private String Tuesday;
	private String Wednesday;
	private String Thursday;
	private String Friday;
	
	
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
	 * @return the monday
	 */
	public String getMonday() {
		return Monday;
	}

	/**
	 * @param monday the monday to set
	 */
	public void setMonday(String monday) {
		Monday = monday;
	}

	/**
	 * @return the tuesday
	 */
	public String getTuesday() {
		return Tuesday;
	}

	/**
	 * @param tuesday the tuesday to set
	 */
	public void setTuesday(String tuesday) {
		Tuesday = tuesday;
	}

	/**
	 * @return the wednesday
	 */
	public String getWednesday() {
		return Wednesday;
	}

	/**
	 * @param wednesday the wednesday to set
	 */
	public void setWednesday(String wednesday) {
		Wednesday = wednesday;
	}

	/**
	 * @return the timeOfTeaching
	 */
	public String getTimeOfTeaching() {
		return timeOfTeaching;
	}

	/**
	 * @param timeOfTeaching the timeOfTeaching to set
	 */
	public void setTimeOfTeaching(String timeOfTeaching) {
		this.timeOfTeaching = timeOfTeaching;
	}

	/**
	 * @return the subject
	 */
	public Subject getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	/**
	 * @return the thursday
	 */
	public String getThursday() {
		return Thursday;
	}

	/**
	 * @param thursday the thursday to set
	 */
	public void setThursday(String thursday) {
		Thursday = thursday;
	}

	/**
	 * @return the friday
	 */
	public String getFriday() {
		return Friday;
	}

	/**
	 * @param friday the friday to set
	 */
	public void setFriday(String friday) {
		Friday = friday;
	}

}
