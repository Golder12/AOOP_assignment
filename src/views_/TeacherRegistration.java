package views_;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.StudentClass;
import models.Subject;
import models.Teacher;
import services.StudentClassService;
import services.SubjectService;
import services.TeacherService;
import servicesImplementation.StudentClassImplementation;
import servicesImplementation.SubjectServiceImplementation;
import servicesImplementation.TeacherImplementation;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TeacherRegistration extends JFrame {

	private JPanel contentPane;
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField phoneNumberField;
	private JTextField passwordField;
	private JTextField confirmPasswordField;

	/**
	 * Create the frame.
	 */
	public TeacherRegistration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 561);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REGISTRATION FORM");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(142, 0, 134, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(75, 39, 66, 23);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Last Name");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(75, 73, 66, 23);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Class and Subject you teach");
		lblNewLabel_3.setBounds(75, 165, 201, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Phone Number");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(75, 107, 95, 22);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Class");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(85, 198, 56, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Subject");
		lblNewLabel_6.setBounds(95, 223, 46, 23);
		panel.add(lblNewLabel_6);
		
		StudentClassService studentClass = new StudentClassImplementation();
		
		List<StudentClass> classesAvailable = studentClass.getAllStudentClasses();
		
		JComboBox<StudentClass> cb1 = new JComboBox<StudentClass>();
		
		for(StudentClass studentclass:classesAvailable) {
			cb1.addItem(studentclass);
		}
		
		cb1.setEditable(false);
		cb1.setBounds(195, 190, 180, 22);
		panel.add(cb1);
		
		
		SubjectService subject = new SubjectServiceImplementation();
		
		List<Subject> subjectsAvailable = subject.getAllSubjects();
		
		JComboBox<Subject> cb2 = new JComboBox<Subject>();
		
		for(Subject subjectInstance:subjectsAvailable) {
			cb2.addItem(subjectInstance);
		}
		cb2.setBounds(195, 223, 180, 22);
		panel.add(cb2);
		
		JLabel lblNewLabel_7 = new JLabel("Password");
		lblNewLabel_7.setBounds(75, 306, 66, 23);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Confirm password");
		lblNewLabel_8.setBounds(75, 359, 95, 23);
		panel.add(lblNewLabel_8);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(70, 152, 305, 2);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(75, 274, 305, 2);
		panel.add(separator_1);
		
		firstNameField = new JTextField();
		firstNameField.setBounds(195, 40, 180, 20);
		panel.add(firstNameField);
		firstNameField.setColumns(10);
		
		lastNameField = new JTextField();
		lastNameField.setBounds(195, 74, 180, 20);
		panel.add(lastNameField);
		lastNameField.setColumns(10);
		
		phoneNumberField = new JTextField();
		phoneNumberField.setBounds(195, 108, 180, 20);
		panel.add(phoneNumberField);
		phoneNumberField.setColumns(10);
		
		passwordField = new JTextField();
		passwordField.setBounds(195, 307, 180, 20);
		panel.add(passwordField);
		passwordField.setColumns(10);
		
		confirmPasswordField = new JTextField();
		confirmPasswordField.setBounds(195, 360, 180, 20);
		panel.add(confirmPasswordField);
		confirmPasswordField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			Teacher teacher = new Teacher();
			
			TeacherService teacherService = new TeacherImplementation();
			
			teacher.setFirstName(firstNameField.getText());
			teacher.setLastName(lastNameField.getText());
			teacher.setPhoneNumber(phoneNumberField.getText());
			teacher.setPassword(passwordField.getText());
			teacher.setSubject((Subject) cb2.getSelectedItem());
			teacher.setStudentClass((StudentClass) cb1.getSelectedItem());
			
			teacherService.saveTeacher(teacher);
				
				
			}
		});
		btnNewButton_1.setBounds(286, 423, 89, 23);
		panel.add(btnNewButton_1);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		
		
		new TeacherRegistration();
	}
}
