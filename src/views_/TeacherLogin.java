package views_;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.Teacher;
import services.TeacherService;
import servicesImplementation.TeacherImplementation;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TeacherLogin extends JFrame {

	private JPanel contentPane;
	private JTextField firstNamelogin;
	private JTextField passwordLogin;
	
	/**
	 * Create the frame.
	 */
	public TeacherLogin() {
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
		
		JLabel lblNewLabel = new JLabel("TEACHER LOGIN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(158, 11, 125, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First name");
		lblNewLabel_1.setBounds(87, 52, 84, 14);
		panel.add(lblNewLabel_1);
		
		firstNamelogin = new JTextField();
		firstNamelogin.setBounds(216, 49, 161, 20);
		panel.add(firstNamelogin);
		firstNamelogin.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("password");
		lblNewLabel_2.setBounds(87, 106, 84, 14);
		panel.add(lblNewLabel_2);
		
		passwordLogin = new JTextField();
		passwordLogin.setBounds(216, 103, 161, 20);
		panel.add(passwordLogin);
		passwordLogin.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeacherService teacherService = new TeacherImplementation();
				
				Teacher teacher = new Teacher();
				teacher.setFirstName(firstNamelogin.getText());
				teacher.setPassword(passwordLogin.getText());
				
				if(teacherService.loginTeacher(teacher))
					new TeacherHome().setVisible(true);
				
			}
		});
		btnNewButton.setBounds(288, 169, 89, 23);
		panel.add(btnNewButton);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherLogin frame = new TeacherLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}



}
