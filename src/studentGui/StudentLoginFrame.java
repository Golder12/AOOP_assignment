package studentGui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import models.Student;
import services.StudentService;
import servicesImplementation.StudentImplementation;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class StudentLoginFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField regNoTextField;
	
	/**
	 * Create the frame.
	 */
	public StudentLoginFrame() {
		setResizable(false);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 734,  500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		getContentPane().setLayout(null);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 718, 461);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(102, 204, 255));
		panel_1.setBounds(0, 42, 718, 54);
		panel.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Student Login");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(0, 0, 717, 54);
		panel_1.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(Color.WHITE);
		
		JLabel lblStudentRegistrationNumber = new JLabel("Student Registration Number :");
		lblStudentRegistrationNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentRegistrationNumber.setBounds(135, 187, 176, 20);
		panel.add(lblStudentRegistrationNumber);
		
		regNoTextField = new JTextField();
		regNoTextField.setColumns(10);
		regNoTextField.setBounds(414, 187, 176, 20);
		panel.add(regNoTextField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				StudentService studentService = new StudentImplementation();
				
				Student student = new Student();
				
				student.setRegistrationNumber(regNoTextField.getText());
				
				if(studentService.loginStudent(student))
					new StudentFrame().setVisible(true);
				
			}
		});
		btnNewButton.setBounds(337, 282, 89, 23);
		panel.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(0, 0, 718, 42);
		panel.add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("RESULT MANAGEMENT SYSTEM");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(164, 0, 554, 38);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("KATIKAMU");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(0, 0, 154, 20);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblPrimarySchool = new JLabel("PRIMARY SCHOOL");
		lblPrimarySchool.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrimarySchool.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrimarySchool.setForeground(Color.WHITE);
		lblPrimarySchool.setBounds(0, 29, 154, 9);
		panel_2.add(lblPrimarySchool);

		
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentLoginFrame frame = new StudentLoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	

}

