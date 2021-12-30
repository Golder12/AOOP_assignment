package views_;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.MouseInputAdapter;
import javax.swing.table.DefaultTableModel;

import org.w3c.dom.events.MouseEvent;

import models.Student;
import models.Subject;
import services.StudentService;
import services.SubjectService;
import servicesImplementation.StudentImplementation;
import servicesImplementation.SubjectServiceImplementation;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;

public class RecordStudentsMarks extends JFrame {

	private JPanel contentPane;
	private JTextField classTextField;
	private JTextField markToSave;
	private JTextField firstNameLabel;
	
	public RecordStudentsMarks() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 250);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Record Student's Marks");
		lblNewLabel.setBounds(5, 5, 424, 14);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 45, 170, 194);
		panel.add(scrollPane);
		
		StudentService studentService = new StudentImplementation();
		List<Student> studentsForGrading = studentService.getStudentsOfClassAndSubject();
		
		
		
		DefaultListModel<Student> listModel = new DefaultListModel<Student>();
		
		for(Student student:studentsForGrading) {
			listModel.addElement(student);
		}
		
		JList<Student> list = new JList<Student>(listModel);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setVisibleRowCount(20);
		
		classTextField = new JTextField();
		classTextField.setBackground(Color.WHITE);
		classTextField.setEditable(false);
		classTextField.setBounds(318, 115, 86, 20);
		panel.add(classTextField);
		classTextField.setColumns(10);
		
		markToSave = new JTextField();
		markToSave.setBounds(318, 157, 86, 20);
		panel.add(markToSave);
		markToSave.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(226, 93, 71, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Class");
		lblNewLabel_2.setBounds(226, 118, 71, 14);
		panel.add(lblNewLabel_2);
		
		JLabel markRecorded = new JLabel("Mark");
		markRecorded.setBounds(226, 160, 71, 14);
		panel.add(markRecorded);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				StudentService studentService = new StudentImplementation();
				
				SubjectService subjectService = new SubjectServiceImplementation();
				
				Student student = list.getSelectedValue();
				
				List<Subject> subjects = new ArrayList<>();
				
				String subjectToBeRecorded = StudentImplementation.subjectName;
				Subject subject = subjectService.getSubjectOfName(subjectToBeRecorded);
			
				subject.setSubjectMark(markToSave.getText());
				subjects.add(subject);
				student.setSubjects(subjects);				
				
				studentService.saveStudentMark(student);
			}
		});
		btnNewButton.setBounds(321, 200, 86, 23);
		panel.add(btnNewButton);
		
		 list.addListSelectionListener(new ListSelectionListener() {

	            @Override
	            public void valueChanged(ListSelectionEvent e) {
	                if (!e.getValueIsAdjusting()) {
	                	firstNameLabel.setText(list.getSelectedValue().getFirstName());
	                	classTextField.setText(list.getSelectedValue().getLastName());
	                		                	
	                }
	            }
	        });
		 
		scrollPane.setRowHeaderView(list);
		
		JLabel SubjectBeingAwardedForMarks = new JLabel(StudentImplementation.subjectName);
		SubjectBeingAwardedForMarks.setBounds(23, 20, 71, 14);
		panel.add(SubjectBeingAwardedForMarks);
		
		JLabel ClassBeingAwardedMarks = new JLabel(StudentImplementation.studentClass);
		ClassBeingAwardedMarks.setBounds(123, 20, 71, 14);
		panel.add(ClassBeingAwardedMarks);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBackground(Color.BLACK);
		separator.setForeground(Color.BLACK);
		separator.setBounds(215, 45, 2, 194);
		panel.add(separator);
		
		firstNameLabel = new JTextField();
		firstNameLabel.setEditable(false);
		firstNameLabel.setColumns(10);
		firstNameLabel.setBackground(Color.WHITE);
		firstNameLabel.setBounds(318, 84, 86, 20);
		panel.add(firstNameLabel);
		
		
		setVisible(true);
	}


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecordStudentsMarks frame = new RecordStudentsMarks();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
