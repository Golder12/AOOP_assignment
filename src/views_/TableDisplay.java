package views_;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import models.Student;
import services.StudentService;
import servicesImplementation.StudentImplementation;

import javax.swing.JTable;

public class TableDisplay extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	/**
	 * Create the frame.
	 */
	public TableDisplay() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		
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
			 table.setBounds(30,40,200,300);   
			 			 
			 JScrollPane sp=new JScrollPane(table); 
			 
			 add(sp);
			
			
			}catch(SQLException e) {
				e.printStackTrace();
			} 
			
		setVisible(true);
	}


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
					TableDisplay frame = new TableDisplay();
					
				
	}

	
}
