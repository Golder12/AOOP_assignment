package teacherGui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

import models.Student;
import models.StudentClass;
import services.StudentClassService;
import services.StudentService;
import servicesImplementation.StudentClassImplementation;
import servicesImplementation.StudentImplementation;

import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class RegisterStudentPanel extends JPanel {
	private JTextField firstName;
	private JTextField lastName;
	private JTextField regNo;
	private JTextField age;
	ButtonGroup group = new ButtonGroup();
	
	/**
	 * Create the panel.
	 */
	public RegisterStudentPanel() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 5, 472, 334);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter the student's details");
		lblNewLabel.setBounds(0, 11, 472, 23);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First name");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(42, 45, 142, 23);
		panel.add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.BLACK);
		separator.setBackground(Color.BLACK);
		separator.setBounds(230, 45, 1, 239);
		panel.add(separator);
		
		firstName = new JTextField();
		firstName.setColumns(1);
		firstName.setBounds(42, 67, 142, 27);
		panel.add(firstName);
		
		JLabel lblNewLabel_2 = new JLabel("Last Name");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(42, 119, 142, 34);
		panel.add(lblNewLabel_2);
		
		lastName = new JTextField();
		lastName.setColumns(1);
		lastName.setBounds(42, 153, 142, 27);
		panel.add(lastName);
		
		JLabel lblNewLabel_3 = new JLabel("Registration\r\n Number");
		lblNewLabel_3.setBounds(42, 199, 142, 34);
		panel.add(lblNewLabel_3);
		
		regNo = new JTextField();
		regNo.setColumns(10);
		regNo.setBounds(42, 232, 142, 27);
		panel.add(regNo);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBackground(Color.WHITE);
		rdbtnFemale.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnFemale.setBounds(246, 69, 99, 23);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBackground(Color.WHITE);
		rdbtnMale.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnMale.setBounds(347, 69, 103, 23);
		
		//adding the radio buttons to a group
		group.add(rdbtnMale);
		group.add(rdbtnFemale);
				
		panel.add(rdbtnFemale);
		panel.add(rdbtnMale);
		
		
		JLabel lblNewLabel_4 = new JLabel("Age");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(269, 129, 142, 14);
		panel.add(lblNewLabel_4);
		
		age = new JTextField();
		age.setColumns(10);
		age.setBounds(271, 153, 140, 27);
		panel.add(age);
		
		JLabel lblNewLabel_6 = new JLabel("Class");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(269, 209, 142, 14);
		panel.add(lblNewLabel_6);
		
		
		//adding student classes to the dropdown option
		StudentClassService studentClass = new StudentClassImplementation();
		
		List<StudentClass> classesAvailable = studentClass.getAllStudentClasses();
		
		JComboBox<StudentClass> ClassNames = new JComboBox<StudentClass>();
		
		for(StudentClass studentclass:classesAvailable) {
			ClassNames.addItem(studentclass);
		}
		ClassNames.setEditable(false);
		ClassNames.setBounds(271, 234, 140, 22);
		panel.add(ClassNames);
		
		JButton btnSaveButton = new JButton("Save");
		btnSaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//getting the value of the radio button selected from the button group
				char gender = '\0';
				
				if(rdbtnMale.isSelected()) {
					gender = 'M';
				}
				else if(rdbtnFemale.isSelected()){
					gender = 'F';
				}else {
					gender = 'S';
				}
				
				//student object instantiated 
				Student student = new Student();
				StudentService newStudent = new StudentImplementation();
				
				//setting the attributes of the student object with details from the form
				student.setFirstName(firstName.getText());
				student.setLastName(lastName.getText());
				student.setRegistrationNumber(regNo.getText());
				student.setGender(gender);
				student.setAge(Integer.parseInt(age.getText()));
				
				student.setStudentClass((StudentClass) ClassNames.getSelectedItem());
				
				try {
					System.out.println(student);
					newStudent.saveStudent(student);
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
		btnSaveButton.setBounds(322, 281, 89, 23);
		panel.add(btnSaveButton);
		
		JLabel lblNewLabel_5 = new JLabel("Gender");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(246, 49, 204, 14);
		panel.add(lblNewLabel_5);
		

	}
}
