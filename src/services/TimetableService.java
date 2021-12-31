package services;

import java.util.List;

import models.Timetable;

/**
 * 
 *This is the interface providing methods for the 
 *Timetable model
 *
 */

public interface TimetableService {
	
	/**
	 * saves a timetable entry which consists of the time period of teaching,
	 * the class being taught as well as the subject being taught
	 * @param timetableEntry
	 */
	void saveTimeTableEntry(Timetable timetableEntry);
	
	/**
	 * Gets all the timetable information that has been recorded
	 * @return
	 */
	List<Timetable> getTimetableEntriesOfClass();

}
