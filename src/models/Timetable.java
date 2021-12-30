package models;

public class Timetable {
	
	private StudentClass studentClass;
	
	private String timeOfTeaching;
	
	private String Monday;
	
	private String Tuesday;
	
	private String Wednesday;
	
	private String Thursday;
	
	private String Friday;
	
	private Subject subject;

	public String getThursday() {
		return Thursday;
	}

	public void setThursday(String thursday) {
		Thursday = thursday;
	}

	public String getFriday() {
		return Friday;
	}

	public void setFriday(String friday) {
		Friday = friday;
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

}
