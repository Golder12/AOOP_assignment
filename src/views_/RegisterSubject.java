package views_;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.StudentClass;
import models.Subject;
import services.StudentClassService;
import services.SubjectService;
import servicesImplementation.StudentClassImplementation;
import servicesImplementation.SubjectServiceImplementation;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class RegisterSubject extends JFrame {

	private JPanel contentPane;
	private JTextField nametextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterSubject frame = new RegisterSubject();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegisterSubject() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 309, 254);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Register Subject");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 314, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Subject name");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(24, 50, 124, 22);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Class");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(24, 102, 124, 22);
		panel.add(lblNewLabel_2);
		
		StudentClassService studentClass = new StudentClassImplementation();
		
		List<StudentClass> classesAvailable = studentClass.getAllStudentClasses();
		
		
		JComboBox<StudentClass> ClassNames = new JComboBox<StudentClass>();
		
		for(StudentClass studentclass:classesAvailable) {
			ClassNames.addItem(studentclass);
		}
		
		ClassNames.setEditable(false);
		ClassNames.setBounds(182, 102, 98, 22);
		panel.add(ClassNames);

		
		nametextField = new JTextField();
		nametextField.setBounds(182, 50, 98, 22);
		panel.add(nametextField);
		nametextField.setColumns(10);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SubjectService subjectservice = new SubjectServiceImplementation();
				Subject subject = new Subject();
				
				
				subject.setName(nametextField.getText());
				subject.setStudentClass((StudentClass) ClassNames.getSelectedItem());
				
				subjectservice.saveSubject(subject);
			}
		});
		btnNewButton.setBounds(182, 177, 109, 33);
		panel.add(btnNewButton);
		
		
		
		
		
		
		}
}
