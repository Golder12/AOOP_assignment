package services;

import models.Teacher;

/**
 * This is the interface providing methods for the 
 *Teacher model
 *
 */

public interface TeacherService {
	
	/**
	 * Saves a teacher
	 * @param teacher 
	 */
	void saveTeacher(Teacher teacher);
	
	/**
	 * Handles logging in a teacher
	 * @param teacher
	 * @return a boolean value; true if the teacher has created an account
	 */
	boolean loginTeacher(Teacher teacher);

	

}
