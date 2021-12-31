package studentGui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import models.Timetable;
import services.TimetableService;
import servicesImplementation.TimetableImplementation;

public class TimeTablePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	static String nameOfStudentClass;

	/**
	 * Create the panel.
	 */
	public TimeTablePanel() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 573, 39);
		add(panel);
		panel.setLayout(null);
		
		JLabel classTimetable = new JLabel();
		classTimetable.setText("Primary  timetable");
		classTimetable.setFont(new Font("Tahoma", Font.PLAIN, 15));
		classTimetable.setBounds(0, 0, 201, 34);
		panel.add(classTimetable);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 37,573, 263);
		add(panel_1);
		panel_1.setLayout(null);
		
		TimetableService timetable = new TimetableImplementation();
		List<Timetable> recordedTimeTables = timetable.getTimetableEntriesOfClass();
		
		
		String columns[] = {"","7:00 - 9:00","9:00 - 10:30","10:30 - 11:00", "11:00 - 1:00", "1:00 - 2:00","2:00 - 3:00","3:00 - 4:00"};
		int numberOfColumns = columns.length;
		String data[][] = new String[recordedTimeTables.size()][numberOfColumns];
		
		data[0][0] = "Monday";
		data[1][0] = "Tuesday";
		data[2][0] = "Wednesday";
		data[3][0] = "Thursday";
		data[4][0] = "Friday";
		
		
		
		int j =1;
		for(Timetable timetableEntry:recordedTimeTables) {
			while(j<8) {
			nameOfStudentClass = timetableEntry.getStudentClass().getName();
			if(j != 3 || j != 5 ) {
				data[0][j] = timetableEntry.getMonday();
				data[1][j] = timetableEntry.getTuesday();
				data[2][j] = timetableEntry.getWednesday();
				data[3][j] = timetableEntry.getThursday();
				data[4][j] = timetableEntry.getFriday();
			}
			if(j == 3) {
				data[0][3] = "break";
				data[1][3] = "break";
				data[2][3] = "break";
				data[3][3] = "break";
				data[4][3] = "break";
			}
			if(j == 5) {
				data[0][5] = "lunch";
				data[1][5] = "lunch";
				data[2][5] = "lunch";
				data[3][5] = "lunch";
				data[4][5] = "lunch";
			}	
			j++;
			
			}
		}
		
		classTimetable.setText("Primary " + nameOfStudentClass + " timetable" );
		
		DefaultTableModel model = new DefaultTableModel(data,columns);
		
		table = new JTable(model);
		table.setBounds(0, 0, 573, 263);
		
		JScrollPane sp =new JScrollPane(table);
		sp.setBounds(0, 0, 573, 256);

		panel_1.add(sp);

	}
}
