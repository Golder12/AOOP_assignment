package teacherGui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import models.StudentClass;
import models.Subject;
import models.Teacher;
import services.StudentClassService;
import services.SubjectService;
import services.TeacherService;
import servicesImplementation.StudentClassImplementation;
import servicesImplementation.SubjectServiceImplementation;
import servicesImplementation.TeacherImplementation;

import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class TeacherRegistrationPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField phoneNumberField;
	private JPasswordField passwordField;
	private JPasswordField confirmPasswordField;

	/**
	 * Create the panel.
	 */
	public TeacherRegistrationPanel() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(0, 0,  632, 42);
		add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("RESULT MANAGEMENT SYSTEM");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(164, 0, 270, 38);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("KATIKAMU");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(0, 0, 154, 20);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblPrimarySchool = new JLabel("PRIMARY SCHOOL");
		lblPrimarySchool.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrimarySchool.setForeground(Color.WHITE);
		lblPrimarySchool.setBounds(0, 29, 154, 9);
		panel_2.add(lblPrimarySchool);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(204, 204, 255));
		panel_1.setBounds(0, 43, 632, 31);
		add(panel_1);
		
		JLabel lblRegister = new JLabel("REGISTER");
		lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegister.setBackground(Color.WHITE);
		lblRegister.setBounds(10, 0,  632, 31);
		panel_1.add(lblRegister);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 116, 632, 283);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("First Name");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(20, 33, 66, 23);
		panel.add(lblNewLabel_1_1);
		
		firstNameField = new JTextField();
		firstNameField.setColumns(10);
		firstNameField.setBounds(139, 34, 125, 20);
		panel.add(firstNameField);
		
		JLabel lblNewLabel_2_1 = new JLabel("Last Name");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setBounds(20, 80, 66, 23);
		panel.add(lblNewLabel_2_1);
		
		lastNameField = new JTextField();
		lastNameField.setColumns(10);
		lastNameField.setBounds(139, 81, 125, 20);
		panel.add(lastNameField);
		
		JLabel lblNewLabel_4 = new JLabel("Phone Number");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(20, 142, 88, 22);
		panel.add(lblNewLabel_4);
		
		phoneNumberField = new JTextField();
		phoneNumberField.setColumns(10);
		phoneNumberField.setBounds(139, 143, 125, 20);
		panel.add(phoneNumberField);
		
		JLabel lblNewLabel_3 = new JLabel("Class and Subject you teach");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(351, 11, 201, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("Class");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5.setBounds(361, 37, 66, 14);
		panel.add(lblNewLabel_5);
		
		StudentClassService studentClass = new StudentClassImplementation();
		
		List<StudentClass> classesAvailable = studentClass.getAllStudentClasses();
		
		JComboBox<StudentClass> cb1 = new JComboBox<StudentClass>();
		
		for(StudentClass studentclass:classesAvailable) {
			cb1.addItem(studentclass);
		}
		cb1.setEditable(false);
		cb1.setBounds(427, 33, 125, 22);
		panel.add(cb1);
		
		JLabel lblNewLabel_6 = new JLabel("Subject");
		lblNewLabel_6.setBounds(361, 80, 66, 23);
		panel.add(lblNewLabel_6);
		
		SubjectService subject = new SubjectServiceImplementation();
		
		List<Subject> subjectsAvailable = subject.getAllSubjects();
		
		JComboBox<Subject> cb2 = new JComboBox<Subject>();
		
		for(Subject subjectInstance:subjectsAvailable) {
			cb2.addItem(subjectInstance);
		}
		cb2.setBounds(427, 80, 125, 22);
		panel.add(cb2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(427, 143, 125, 20);
		panel.add(passwordField);
		
		JLabel lblNewLabel_7 = new JLabel("Password");
		lblNewLabel_7.setBounds(351, 142, 66, 23);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Confirm password");
		lblNewLabel_8.setBounds(332, 173, 95, 23);
		panel.add(lblNewLabel_8);
		
		confirmPasswordField = new JPasswordField();
		confirmPasswordField.setBounds(427, 174, 125, 20);
		panel.add(confirmPasswordField);
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Teacher teacher = new Teacher();
				
				TeacherService teacherService = new TeacherImplementation();
				
				teacher.setFirstName(firstNameField.getText());
				teacher.setLastName(lastNameField.getText());
				teacher.setPhoneNumber(phoneNumberField.getText());
				teacher.setPassword(String.valueOf(passwordField.getPassword()));
				teacher.setSubject((Subject) cb2.getSelectedItem());
				teacher.setStudentClass((StudentClass) cb1.getSelectedItem());
				
				teacherService.saveTeacher(teacher);

			}
		});
		btnNewButton_1.setBounds(463, 231, 89, 23);
		panel.add(btnNewButton_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(332, 117, 219, 2);
		panel.add(separator);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(294, 33, 1, 210);
		panel.add(separator_2);

	}
}

