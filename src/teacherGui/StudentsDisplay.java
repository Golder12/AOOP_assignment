package teacherGui;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import models.Student;
import services.StudentService;
import servicesImplementation.StudentImplementation;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentsDisplay extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField searchTextField;
	
	/**
	 * Create the panel.
	 */
	public StudentsDisplay() {
	
		setBackground(Color.WHITE);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 33, 573, 267);
		panel.setBackground(Color.WHITE);
		add(panel);
		panel.setLayout(null);
		
		
		
		StudentService newStudent = new StudentImplementation();
		try {
			List<Student> registeredStudents = newStudent.getAllStudents();
			
			String columns[] = {"Registration Number","Name","Class"};
			int numberOfColumns = columns.length;
			String data[][] = new String[registeredStudents.size()][numberOfColumns];
			String prefix = "Primary ";
			
			int i = 0;
			for(Student student:registeredStudents) {
				String name = student.getLastName() + " " + student.getFirstName() ;
				String regNo = student.getRegistrationNumber();
				String studentClass = prefix +  student.getStudentClass();
				data[i][0] = regNo;
				data[i][1] = name;
				data[i][2] = studentClass;
				i++;
			}
			
			DefaultTableModel model = new DefaultTableModel(data,columns);
			table = new JTable(model);
			table.setShowVerticalLines(false);
			table.setBorder(new LineBorder(new Color(0, 0, 0)));
			table.setBounds(0,0,440,256);
			
			
			JScrollPane sp=new JScrollPane(table); 
			sp.setBounds(0, 0, 573, 256);
			 
			 panel.add(sp);
			 
			 JPanel panel_1 = new JPanel();
			 panel_1.setBackground(Color.WHITE);
			 panel_1.setBounds(0, 0,  573, 33);
			 add(panel_1);
			 panel_1.setLayout(null);
			 
			 searchTextField = new JTextField(15);
			 searchTextField.setBounds(321, 11, 143, 20);
			 panel_1.add(searchTextField);
			 searchTextField.setColumns(10);
			 
			 
			 JButton btnNewButton = new JButton("Search");
			 btnNewButton.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		
			 		
						Student registeredStudent = newStudent.getStudentOfRegNo(searchTextField.getText());
						String columns[] = {"Registration Number","Name","Class"};
						int numberOfColumns = columns.length;
						String data[][] = new String[1][numberOfColumns];
						String prefix = "Primary ";
						
						
							String name = registeredStudent.getLastName() + " " + registeredStudent.getFirstName() ;
							String regNo = registeredStudent.getRegistrationNumber();
							String studentClass = prefix +  registeredStudent.getStudentClass();
							data[0][0] = regNo;
							data[0][1] = name;
							data[0][2] = studentClass;
							
							panel.setVisible(false);
							
							JPanel panel1 = new JPanel();
							panel1.setBounds(0, 33, 573, 267);
							panel1.setBackground(Color.WHITE);
							add(panel1);
							panel1.setLayout(null);
							

							DefaultTableModel model = new DefaultTableModel(data,columns);
							JTable table1 = new JTable(model);
							table1.setShowVerticalLines(false);
							table1.setBorder(new LineBorder(new Color(0, 0, 0)));
							table1.setBounds(0,0,440,256);
							
							JScrollPane sp1 =new JScrollPane(table1);
							sp1.setBounds(0, 0, 573, 256);
							
							panel1.add(sp);
							
			 	}});
			 btnNewButton.setBounds(474, 10, 89, 23);
			 panel_1.add(btnNewButton);
			
		 setVisible(true);
		
		}catch(SQLException e) {
			e.printStackTrace();
		} 
		
	}
}
