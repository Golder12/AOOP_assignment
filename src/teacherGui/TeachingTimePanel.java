package teacherGui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import models.Timetable;
import services.StudentClassService;
import services.TimetableService;
import servicesImplementation.StudentClassImplementation;
import servicesImplementation.SubjectServiceImplementation;
import servicesImplementation.TimetableImplementation;

import java.awt.Color;
import java.util.List;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TeachingTimePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	static String nameOfTeacherClass = "";
	static String subject = "";

	/**
	 * Create the panel.
	 */
	public TeachingTimePanel() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 573, 36);
		add(panel);
		panel.setLayout(null);
		
		JLabel classTimetable = new JLabel();
		classTimetable.setFont(new Font("Tahoma", Font.PLAIN, 15));
		classTimetable.setBounds(10, 0, 201, 34);
		panel.add(classTimetable);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 36,  573, 341);
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
			nameOfTeacherClass = timetableEntry.getStudentClass().getName();
			subject = timetableEntry.getSubject().getName();
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
		
		classTimetable.setText("Primary " + nameOfTeacherClass + " timetable" );
		
		DefaultTableModel model = new DefaultTableModel(data,columns);
		table = new JTable(model);
		table.setBounds(0, 0,573, 264);
		
		JScrollPane sp =new JScrollPane(table);
		sp.setBounds(0, 0, 573, 256);

		panel_1.add(sp);
		
		JComboBox<String> daycomboBox = new JComboBox<String>();
		daycomboBox.setBackground(Color.WHITE);
		daycomboBox.addItem(data[0][0]);
		daycomboBox.addItem(data[1][0]);
		daycomboBox.addItem(data[2][0]);
		daycomboBox.addItem(data[3][0]);
		daycomboBox.addItem(data[4][0]);
		daycomboBox.setBounds(35, 296, 127, 22);
		panel_1.add(daycomboBox);
		
		
		JLabel lblNewLabel = new JLabel("Add Teaching time");
		lblNewLabel.setBounds(35, 267, 141, 18);
		panel_1.add(lblNewLabel);
		
		JComboBox<String> timecomboBox = new JComboBox<String>();
		timecomboBox.setBackground(Color.WHITE);
		timecomboBox.addItem("7:00 - 9:00");
		timecomboBox.addItem("9:00 - 10:30");
		timecomboBox.addItem("11:00 - 1:00");
		timecomboBox.addItem("2:00 - 3:00");
		timecomboBox.addItem("3:00 - 4:00");
		timecomboBox.setBounds(224, 296, 127, 22);
		panel_1.add(timecomboBox);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TimetableService timeTableService = new TimetableImplementation();
				StudentClassService studentClassService = new StudentClassImplementation();
				SubjectServiceImplementation subjectService = new SubjectServiceImplementation();
				
				Timetable timeToSave = new Timetable();
				
				timeToSave.setStudentClass(studentClassService.getClassOfName(nameOfTeacherClass));
				
				timeToSave.setTimeOfTeaching((String) timecomboBox.getSelectedItem());
				
				String dayToTeach = (String) daycomboBox.getSelectedItem();
				
				timeToSave.setSubject(subjectService.getSubjectOfName(subject));
				
				if(dayToTeach.equalsIgnoreCase("monday"))
					timeToSave.setMonday(subject);
				if(dayToTeach.equalsIgnoreCase("tuesday"))
					timeToSave.setTuesday(subject);
				if(dayToTeach.equalsIgnoreCase("wednesday"))
					timeToSave.setWednesday(subject);
				if(dayToTeach.equalsIgnoreCase("thursday"))
					timeToSave.setThursday(subject);
				if(dayToTeach.equalsIgnoreCase("friday"))
					timeToSave.setFriday(subject);
				
				timeTableService.saveTimeTableEntry(timeToSave);	
				
			}
		});
		btnNewButton.setBounds(413, 296, 89, 23);
		panel_1.add(btnNewButton);
		
	}
}
