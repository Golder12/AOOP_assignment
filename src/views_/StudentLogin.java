package views_;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.Student;
import services.StudentService;
import servicesImplementation.StudentImplementation;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentLogin extends JFrame {

	private JPanel contentPane;
	private JTextField regNoTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentLogin frame = new StudentLogin();
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
	public StudentLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Login");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(167, 5, 85, 20);
		panel.add(lblNewLabel);
		
		JLabel lblRegNo = new JLabel("Student Registration Number");
		lblRegNo.setBounds(23, 63, 176, 20);
		panel.add(lblRegNo);
		
		regNoTextField = new JTextField();
		regNoTextField.setBounds(235, 63, 176, 20);
		panel.add(regNoTextField);
		regNoTextField.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				StudentService studentService = new StudentImplementation();
				
				Student student = new Student();
				
				student.setRegistrationNumber(regNoTextField.getText());
				
				if(studentService.loginStudent(student))
					new StudentHome().setVisible(true);
				
			}
		});
		btnNewButton.setBounds(167, 148, 89, 23);
		panel.add(btnNewButton);
	}
}
