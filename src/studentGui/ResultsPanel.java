package studentGui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import models.Subject;
import services.StudentService;
import servicesImplementation.StudentImplementation;

public class ResultsPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ResultsPanel() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 573, 439);
		add(panel);
		panel.setLayout(null);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Your Results");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(175, 11, 179, 26);
		panel.add(lblNewLabel_2);
		
		JLabel subjectE = new JLabel("English");
		subjectE.setBounds(177, 72, 92, 26);
		panel.add(subjectE);
		
		JLabel subjectEValue = new JLabel("No mark yet");
		subjectEValue.setHorizontalAlignment(SwingConstants.CENTER);
		subjectEValue.setBounds(266, 72, 149, 26);
		panel.add(subjectEValue);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(175, 123, 240, 2);
		panel.add(separator);
		
		JLabel subjectM = new JLabel("Maths");
		subjectM.setBounds(177, 136, 92, 26);
		panel.add(subjectM);
		
		JLabel subjectMValue = new JLabel("No mark yet");
		subjectMValue.setHorizontalAlignment(SwingConstants.CENTER);
		subjectMValue.setBounds(266, 136, 149, 26);
		panel.add(subjectMValue);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(175, 173, 240, 2);
		panel.add(separator_1);
		
		JLabel subjectS = new JLabel("Science");
		subjectS.setBounds(175, 186, 92, 26);
		panel.add(subjectS);
		
		JLabel subjectSValue = new JLabel("No mark yet");
		subjectSValue.setHorizontalAlignment(SwingConstants.CENTER);
		subjectSValue.setBounds(266, 186, 149, 26);
		panel.add(subjectSValue);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(175, 223, 240, 2);
		panel.add(separator_3);
		
		JLabel subjectSS = new JLabel("SocialStudies");
		subjectSS.setBounds(175, 246, 92, 26);
		panel.add(subjectSS);
		
		JLabel subjectSSValue = new JLabel("No mark yet");
		subjectSSValue.setHorizontalAlignment(SwingConstants.CENTER);
		subjectSSValue.setBounds(266, 246, 149, 26);
		panel.add(subjectSSValue);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(175, 283, 240, 2);
		panel.add(separator_2);
		
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
		
		setVisible(true);
		
	}

}
