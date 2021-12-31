package views_;

import java.sql.*;

import models.Student;
import services.StudentService;
import servicesImplementation.StudentImplementation;

public class Trial {

	public static void main(String[] args) {
		
			
			StudentService newStudent = new StudentImplementation();
			
			Student student = new Student();
			
			
			try {
				newStudent.printAllStudents();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
	
}
