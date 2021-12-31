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
import java.awt.Font;

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
		
		JLabel subjectE = new JLabel("English");
		subjectE.setBounds(48, 72, 92, 26);
		panel.add(subjectE);
		
		JLabel subjectEValue = new JLabel("No mark yet");
		subjectEValue.setHorizontalAlignment(SwingConstants.CENTER);
		subjectEValue.setBounds(212, 72, 149, 26);
		panel.add(subjectEValue);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(48, 123, 486, 2);
		panel.add(separator);
		
		JLabel subjectM = new JLabel("Maths");
		subjectM.setBounds(48, 136, 92, 26);
		panel.add(subjectM);
		
		JLabel subjectMValue = new JLabel("No mark yet");
		subjectMValue.setHorizontalAlignment(SwingConstants.CENTER);
		subjectMValue.setBounds(212, 136, 149, 26);
		panel.add(subjectMValue);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(48, 173, 486, 2);
		panel.add(separator_1);
		
		JLabel subjectS = new JLabel("Science");
		subjectS.setBounds(48, 186, 92, 26);
		panel.add(subjectS);
		
		JLabel subjectSValue = new JLabel("No mark yet");
		subjectSValue.setHorizontalAlignment(SwingConstants.CENTER);
		subjectSValue.setBounds(212, 186, 149, 26);
		panel.add(subjectSValue);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(48, 223, 486, 2);
		panel.add(separator_3);
		
		JLabel subjectSS = new JLabel("SocialStudies");
		subjectSS.setBounds(48, 246, 92, 26);
		panel.add(subjectSS);
		
		JLabel subjectSSValue = new JLabel("No mark yet");
		subjectSSValue.setHorizontalAlignment(SwingConstants.CENTER);
		subjectSSValue.setBounds(212, 246, 149, 26);
		panel.add(subjectSSValue);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(48, 283, 486, 2);
		panel.add(separator_2);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(402, 72, 132, 26);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(402, 136, 132, 26);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(402, 186, 132, 26);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(402, 246, 132, 26);
		panel.add(lblNewLabel_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 204, 255));
		panel_1.setBounds(0, 0, 573, 39);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("YOUR RESULTS");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(44, 0, 489, 39);
		panel_1.add(lblNewLabel_2);
		
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
