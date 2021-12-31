package teacherGui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import models.Teacher;
import services.TeacherService;
import servicesImplementation.TeacherImplementation;
import views_.TeacherHome;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginPanel extends JPanel {
	private JTextField firstNamelogin;
	private JPasswordField passwordLogin;

	/**
	 * Create the panel.
	 */
	public LoginPanel() {
		setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(0, 0, 632, 42);
		add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("RESULT MANAGEMENT SYSTEM");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(164, 0, 468, 38);
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
		panel_1.setBounds(0, 42,632, 31);
		add(panel_1);
		
		JLabel lblTeacherLogin = new JLabel("Teacher Login");
		lblTeacherLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeacherLogin.setBackground(Color.WHITE);
		lblTeacherLogin.setBounds(0, 0, 632, 31);
		panel_1.add(lblTeacherLogin);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 73, 632, 422);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("First name :");
		lblNewLabel_1_1.setBounds(176, 93, 95, 14);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Password :");
		lblNewLabel_2_1.setBounds(176, 145, 95, 20);
		panel.add(lblNewLabel_2_1);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeacherService teacherService = new TeacherImplementation();
				
				Teacher teacher = new Teacher();
				teacher.setFirstName(firstNamelogin.getText());
				teacher.setPassword(String.valueOf(passwordLogin.getPassword()));
				
				if(teacherService.loginTeacher(teacher))
					new TeacherFrame().setVisible(true);
			}
		});
		btnNewButton.setBounds(256, 204, 95, 23);
		panel.add(btnNewButton);
		
		firstNamelogin = new JTextField();
		firstNamelogin.setBounds(312, 90, 161, 20);
		panel.add(firstNamelogin);
		firstNamelogin.setColumns(10);
		
		passwordLogin = new JPasswordField();
		passwordLogin.setBounds(312, 145, 161, 20);
		panel.add(passwordLogin);

	}

}
