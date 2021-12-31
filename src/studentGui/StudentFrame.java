package studentGui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import views_.ViewMarks;

import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

import models.Student;
import services.StudentService;
import servicesImplementation.StudentImplementation;

public class StudentFrame extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Create the frame.
	 */
	public StudentFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 734, 49);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("RESULT MANAGEMENT SYSTEM");
		lblNewLabel_1.setBounds(164, 0, 570, 49);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		
		JLabel lblNewLabel = new JLabel("KATIKAMU");
		lblNewLabel.setBounds(0, 0, 154, 20);
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		
		JLabel lblPrimarySchool = new JLabel("PRIMARY SCHOOL");
		lblPrimarySchool.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrimarySchool.setForeground(Color.WHITE);
		lblPrimarySchool.setBounds(0, 29, 154, 20);
		panel.add(lblPrimarySchool);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(0, 0, 46, 14);
		panel.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(0, 49, 163, 412);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Log Out");
		btnNewButton_1.setBounds(10, 378, 143, 23);
		panel_1.add(btnNewButton_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_2.setForeground(Color.BLACK);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(0, 0, 163, 71);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel labelRegNo = new JLabel("New label");
		labelRegNo.setHorizontalAlignment(SwingConstants.CENTER);
		labelRegNo.setBounds(10, 0, 143, 25);
		panel_2.add(labelRegNo);
		
		JLabel labelLastName = new JLabel("New label");
		labelLastName.setHorizontalAlignment(SwingConstants.CENTER);
		labelLastName.setBounds(10, 24, 143, 20);
		panel_2.add(labelLastName);
		
		JLabel labelFName = new JLabel("New label");
		labelFName.setHorizontalAlignment(SwingConstants.CENTER);
		labelFName.setBounds(10, 46, 143, 25);
		panel_2.add(labelFName);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(161, 26, 573, 435);
		contentPane.add(tabbedPane);
		
		JPanel panelStudentHome = new TimeTablePanel();
		panelStudentHome.setBackground(Color.WHITE);
		tabbedPane.addTab("StudentsHome", null, panelStudentHome, null);
		
		JPanel panelStudentsResults = new ResultsPanel();
		panelStudentsResults.setBackground(Color.WHITE);
		panelStudentsResults.setLayout(null);
		tabbedPane.addTab("StudentsResults", null, panelStudentsResults, null);

		JButton btnNewButton = new JButton("Your Results");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		btnNewButton.setBounds(10, 82, 143, 23);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("TimeTable");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		btnNewButton_2.setBounds(10, 116, 143, 23);
		panel_1.add(btnNewButton_2);
		
		StudentService studentService = new StudentImplementation();
		
		Student student = studentService.getLoggedInStudentDetails();
		
		labelRegNo.setText(student.getRegistrationNumber());
		labelLastName.setText(student.getLastName());
		labelFName.setText(student.getFirstName());
		
		
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentFrame frame = new StudentFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
