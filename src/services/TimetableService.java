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
	
	void saveTimeTableEntry(Timetable timetableEntry);
	
	List<Timetable> getTimetableEntriesOfClass();

}
