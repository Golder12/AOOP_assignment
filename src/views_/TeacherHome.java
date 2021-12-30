package views_;

import javax.swing.*;

import models.Student;
import services.StudentService;
import servicesImplementation.StudentImplementation;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;

public class TeacherHome extends JFrame {


	/**
	 * Create the frame.
	 */
	public TeacherHome() {
		
		setBounds(100, 100, 650, 400);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 158, 361);
		getContentPane().add(panel);
		
		JButton btnNewButton = new JButton("Register Student");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RegisterStudent().setVisible(true);
			}
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Registered Students");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TableDisplay().setVisible(true);
			}
		});
		
		
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Record Student's Marks");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RecordStudentsMarks().setVisible(true);
			}
		});
		panel.add(btnNewButton_2);
		
//		DisplayStudents panel_1 = new DisplayStudents();
//		panel_1.setBounds(189, 30, 418, 300);
//		getContentPane().add(panel_1);
//		panel_1.setVisible(true);
//		
//		panel.add(panel_1);
		
		
		setVisible(true);

	}
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		new TeacherHome();
		
		
}
}
