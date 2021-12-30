package services;

import java.util.List;

import models.Timetable;

public interface TimetableService {
	
	void saveTimeTableEntry(Timetable timetableEntry);
	
	List<Timetable> getTimetableEntriesOfClass();

}
