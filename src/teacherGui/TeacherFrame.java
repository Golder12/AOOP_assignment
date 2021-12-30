package teacherGui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TeacherFrame extends JFrame {

	private JPanel contentPane;

	
	/**
	 * Create the frame.
	 */
	public TeacherFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(0, 49, 163, 412);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(161, 22, 573, 439);
		contentPane.add(tabbedPane);
		
		JPanel panelTeacherHome = new StudentsDisplay();
		tabbedPane.addTab("New tab", null, panelTeacherHome, null);
		
		JPanel registerStudentPanel = new RegisterStudentPanel();
		registerStudentPanel.setBackground(Color.WHITE);
		tabbedPane.addTab("Register student", null, registerStudentPanel, null);
		
		JPanel recordMarksPanel = new RecordMarksPanel();
		recordMarksPanel.setBackground(Color.WHITE);
		tabbedPane.addTab("record marks", null, recordMarksPanel, null);
		
		JPanel timeTable = new TeachingTimePanel();
		tabbedPane.addTab("TimeTableChoice", null, timeTable, null);
		
		JButton btnNewButton = new JButton("Register Student");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
				
			}
		});
		btnNewButton.setBounds(10, 32, 143, 44);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Record Marks");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(2);
			}
		});
		btnNewButton_1.setBounds(10, 87, 143, 44);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Registered Students");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		btnNewButton_2.setBounds(10, 142, 143, 44);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("View Timetable");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(3);
			}
		});
		btnNewButton_3.setBounds(10, 197, 143, 44);
		panel_1.add(btnNewButton_3);
		
		
		
		
		
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherFrame frame = new TeacherFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
