package views_;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.Student;
import models.StudentClass;
import services.StudentClassService;
import services.StudentService;
import servicesImplementation.StudentClassImplementation;
import servicesImplementation.StudentImplementation;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

public class RegisterStudent extends JFrame {

	private JPanel contentPane;
	private JTextField firstName;
	private JTextField lastName;
	
	StudentService newStudent = new StudentImplementation();
	private JTextField regNo; //this is the student's registration number
	private JTextField age; 
	private JTextField studentClass;
	
	ButtonGroup group = new ButtonGroup();
	
	public RegisterStudent() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter the student's details");
		lblNewLabel.setBounds(5, 5, 269, 26);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(15, 30, 259, 420);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//Entering students firstName
		JLabel lblNewLabel_1 = new JLabel("First name");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 7, 99, 34);
		panel.add(lblNewLabel_1);
		
		firstName = new JTextField();
		firstName.setBounds(109, 7, 142, 27);
		panel.add(firstName);
		firstName.setColumns(1);
		
		//Entering students lastName
		JLabel lblNewLabel_2 = new JLabel("Last Name");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 62, 99, 34);
		panel.add(lblNewLabel_2);
		
		lastName = new JTextField();
		lastName.setBounds(109, 66, 142, 27);
		panel.add(lastName);
		lastName.setColumns(1);
		
		//Entering student's registration Number
		JLabel lblNewLabel_3 = new JLabel("Registration\r\n Number");
		lblNewLabel_3.setBounds(10, 121, 89, 34);
		panel.add(lblNewLabel_3);
		
		regNo = new JTextField();
		regNo.setBounds(109, 121, 142, 27);
		panel.add(regNo);
		regNo.setColumns(10);
		
		/*
		 * Below are two radio buttons  to help us choose a student's gender.
		 * They are of the following values:
		 *  (i) Male 
		 *  (ii) Female 
		 *  
		 * The radio buttons are added to a Button group so that only one
		 * of either radio button can be chosen so a student is either Male or
		 * Female.
		 * 
		 */
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnFemale.setBounds(10, 191, 109, 23);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnMale.setBounds(142, 191, 109, 23);
		
		//adding the radio buttons to a group
		group.add(rdbtnMale);
		group.add(rdbtnFemale);
		
		panel.add(rdbtnFemale);
		panel.add(rdbtnMale);
		
		//Adding student's age
		JLabel lblNewLabel_4 = new JLabel("Age");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(10, 257, 89, 14);
		panel.add(lblNewLabel_4);
		
		age = new JTextField();
		age.setBounds(109, 251, 140, 27);
		panel.add(age);
		age.setColumns(10);
		
		//selecting student's class
		JLabel lblNewLabel_6 = new JLabel("Class");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(10, 315, 89, 14);
		panel.add(lblNewLabel_6);
		
		StudentClassService studentClass = new StudentClassImplementation();
		
		List<StudentClass> classesAvailable = studentClass.getAllStudentClasses();
		
		
		JComboBox<StudentClass> ClassNames = new JComboBox<StudentClass>();
		
		for(StudentClass studentclass:classesAvailable) {
			ClassNames.addItem(studentclass);
		}
		
		ClassNames.setEditable(false);
		ClassNames.setBounds(109, 311, 140, 22);
		panel.add(ClassNames);

		
		/*
		 * The 'save' button has an event listener attached to it
		 * where we will be getting values entered in the form above
		 * and attaching them to a student object. This object will
		 * then be able to use its 'saveStudent' method to save the 
		 * student's details
		 * 
		 * 
		 */
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
		
		btnSaveButton.setBounds(160, 362, 89, 23);
		panel.add(btnSaveButton);
		
		setVisible(true);
	}
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new RegisterStudent();
	}
}
