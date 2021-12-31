package views_;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.Subject;
import services.StudentService;
import servicesImplementation.StudentImplementation;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;

public class ViewMarks extends JFrame {

	private JPanel contentPane;
	
	
	/**
	 * Create the frame.
	 */
	public ViewMarks() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Your Results");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(175, 11, 92, 14);
		contentPane.add(lblNewLabel);
		
		JLabel subjectE = new JLabel("English");
		subjectE.setBounds(129, 49, 92, 26);
		contentPane.add(subjectE);
		
		JLabel subjectEValue = new JLabel("No mark yet");
		subjectEValue.setBounds(231, 49, 149, 26);
		contentPane.add(subjectEValue);
		
		JLabel subjectM = new JLabel("Maths");
		subjectM.setBounds(129, 86, 92, 26);
		contentPane.add(subjectM);
		
		JLabel subjectMValue = new JLabel("No mark yet");
		subjectMValue.setBounds(231, 86, 149, 26);
		contentPane.add(subjectMValue);
		
		JLabel subjectS = new JLabel("Science");
		subjectS.setBounds(129, 123, 92, 26);
		contentPane.add(subjectS);
		
		JLabel subjectSValue = new JLabel("No mark yet");
		subjectSValue.setBounds(231, 123, 149, 26);
		contentPane.add(subjectSValue);
		
		JLabel subjectSS = new JLabel("SocialStudies");
		subjectSS.setBounds(129, 162, 92, 26);
		contentPane.add(subjectSS);
		
		JLabel subjectSSValue = new JLabel("No mark yet");
		subjectSSValue.setBounds(231, 160, 149, 26);
		contentPane.add(subjectSSValue);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(129, 73, 207, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(129, 110, 207, 2);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(129, 147, 207, 2);
		contentPane.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(129, 199, 207, 2);
		contentPane.add(separator_3);
		
		StudentService studentService = new StudentImplementation();
		
		List<Subject> subjectsWithMarks = new ArrayList<>();
		subjectsWithMarks = studentService.getSubjectMarksOfStudent();
		
		for(Subject subject:subjectsWithMarks) {
			
			String subjectName = subject.getName();
			
			if(subjectName.equals(subjectE.getText())) {
				subjectEValue.setText(subject.getSubjectMark());
			}
			
			if(subjectName.equals(subjectM.getText())) {
				subjectMValue.setText(subject.getSubjectMark());
			}
			
			if(subjectName.equals(subjectS.getText())) {
				subjectSValue.setText(subject.getSubjectMark());
			}
			
			if(subjectName.equals(subjectSS.getText())) {
				subjectSSValue.setText(subject.getSubjectMark());
			}
				
			
		}
		
		
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewMarks frame = new ViewMarks();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
