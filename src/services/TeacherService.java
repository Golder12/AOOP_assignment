package services;

import models.Teacher;

/**
 * This is the interface providing methods for the 
 *Teacher model
 *
 */

public interface TeacherService {
	
	void saveTeacher(Teacher teacher);
	
	boolean loginTeacher(Teacher teacher);

	

}
