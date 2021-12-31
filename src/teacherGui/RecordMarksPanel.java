package teacherGui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JList;
import models.Student;
import models.Subject;
import services.StudentService;
import services.SubjectService;
import servicesImplementation.StudentImplementation;
import servicesImplementation.SubjectServiceImplementation;

import javax.swing.ListModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class RecordMarksPanel extends JPanel {
	private JTextField classTextField;
	private JTextField markToSave;

	/**
	 * Create the panel.
	 */
	public RecordMarksPanel() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 573, 412);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Record Student's Marks");
		lblNewLabel.setBounds(10, 5, 430, 25);
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(303, 83, 91, 25);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Class");
		lblNewLabel_2.setBounds(303, 119, 91, 25);
		panel.add(lblNewLabel_2);
		
		JLabel markRecorded = new JLabel("Mark");
		markRecorded.setBounds(303, 172, 91, 25);
		panel.add(markRecorded);
		
		JLabel firstNameLabel = new JLabel("StudentName");
		firstNameLabel.setBounds(432, 83, 104, 25);
		panel.add(firstNameLabel);
		firstNameLabel.setFont(new Font("Tahoma", Font.ITALIC, 11));
		firstNameLabel.setBackground(Color.WHITE);
		
		classTextField = new JTextField();
		classTextField.setBounds(432, 121, 104, 20);
		panel.add(classTextField);
		classTextField.setColumns(10);
		
		markToSave = new JTextField();
		markToSave.setBounds(432, 173, 104, 22);
		panel.add(markToSave);
		markToSave.setColumns(10);
		
		StudentService studentService = new StudentImplementation();
		List<Student> studentsForGrading = studentService.getStudentsOfClassAndSubject();
		
		DefaultListModel<Student> listModel = new DefaultListModel<Student>();
		
		for(Student student:studentsForGrading) {
			listModel.addElement(student);
		}
		
		JList<Student> list = new JList<Student>(listModel);
		list.setBounds(10, 61, 262, 340);
		panel.add(list);
		
		 list.addListSelectionListener(new ListSelectionListener() {

	            @Override
	            public void valueChanged(ListSelectionEvent e) {
	                if (!e.getValueIsAdjusting()) {
	                	firstNameLabel.setText(list.getSelectedValue().getFirstName());
	                	classTextField.setText(list.getSelectedValue().getLastName());
	                }
	            }
	        });
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				StudentService studentService = new StudentImplementation();
				
				SubjectService subjectService = new SubjectServiceImplementation();
				
				Student student = list.getSelectedValue();
				
				List<Subject> subjects = new ArrayList<>();
				
				String subjectToBeRecorded = StudentImplementation.subjectName;
				Subject subject = subjectService.getSubjectOfName(subjectToBeRecorded);
			
				subject.setSubjectMark(markToSave.getText());
				subjects.add(subject);
				student.setSubjects(subjects);				
				
				studentService.saveStudentMark(student);
			}
		});
		btnNewButton.setBounds(432, 232, 104, 23);
		panel.add(btnNewButton);
		
		
		
		
		
	}
}
