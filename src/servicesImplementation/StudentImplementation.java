package servicesImplementation;

import java.util.ArrayList;
import java.util.List;

import models.Student;
import models.StudentClass;
import models.Subject;
import services.StudentClassService;
import services.StudentService;
import services.SubjectService;
import DatabaseManager.DbConnection;
import java.sql.*;

public class StudentImplementation implements StudentService {

	private static Connection con = DbConnection.createConnection();
	SubjectService subjectService = new SubjectServiceImplementation();
	StudentClassService studentClassService = new StudentClassImplementation();
	
	public static String  subjectName = "";
	public static String studentClass = "";
	protected static Student loggedInStudent;
	
	
	@Override
	public void saveStudent(Student student) throws SQLException {
		
		StudentClass currentStudentClass = student.getStudentClass();
		List<Subject> allSubjects = subjectService.getAllSubjects();
		student.setSubjects(allSubjects);
		
		Statement st = con.createStatement();
		String sql = "INSERT INTO Students(firstName,lastName,registrationNumber,gender,age,studentClass) VALUES('" +  student.getFirstName() + "','" + student.getLastName() + "','" + student.getRegistrationNumber() + "', '" + student.getGender() + "','" + student.getAge()  + "','" + currentStudentClass.getName() + "')";
		st.executeUpdate(sql);
		st.close();
		
		
		Statement st1 = con.createStatement();
		for(Subject subject:allSubjects) {
		String subjectName = subject.getName();
		String sql1 = "INSERT INTO StudentsSubjectsClass(studentRegNo,SubjectName,StudentClass) VALUES('" + student.getRegistrationNumber() + "','" + subjectName + "','" + currentStudentClass.getName()  + "')" ;
		st1.executeUpdate(sql1);
		}
	
	}

	
	@Override
	public List<Student> getAllStudents() throws SQLException {
		
		List<Student> allStudents = new ArrayList<>();
				
		Statement st = con.createStatement();
		String sql = "SELECT * FROM Students";
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {
			Student student = new Student();
			student.setFirstName(rs.getString("firstName"));
			student.setLastName(rs.getString("lastName"));
			student.setStudentClass(studentClassService.getClassOfName(rs.getString("studentClass")));
			student.setRegistrationNumber(rs.getString("registrationNumber"));
			allStudents.add(student);
		}		
		
		
		return allStudents;
	}

	@Override
	public void showClassTimetable() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void printAllStudents() throws SQLException {
	
		List<Student> students = getAllStudents();
		
		for(Student student: students) {
			System.out.println(student.getFirstName());
			System.out.println(student.getRegistrationNumber());
		}
		
	}


	@Override
	public List<Student> getStudentsOfClassAndSubject() {
	
		List<Student> requiredStudents = new ArrayList<>();
		
		try {
			String loggedInTeacherIdentity = TeacherImplementation.loggedInTeacher.getPassword();
			
			
			Statement st = con.createStatement();
			String sql = "SELECT SubjectTaught,studentClass FROM teachers WHERE password = '" + loggedInTeacherIdentity + "'";
			
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				subjectName = rs.getString("SubjectTaught");
				studentClass = rs.getString("studentClass");				
			}
			
			String sql1 = "SELECT studentRegNo FROM studentssubjectsclass WHERE StudentClass = '" + studentClass + "' AND SubjectName = '" + subjectName + "'";
			ResultSet rs1 = st.executeQuery(sql1);
			
			
			while(rs1.next()) {
				String studentRegistrationNumber = rs1.getString("studentRegNo");
				requiredStudents.add(getStudentOfRegNo(studentRegistrationNumber));	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return requiredStudents;
	}


	@Override
	public Student getStudentOfRegNo(String registrationNumber) {
		
		try {
			
			Statement st = con.createStatement();
			String sql = "SELECT * FROM Students WHERE registrationNumber = '" + registrationNumber + "'";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				Student student = new Student();
				
				student.setFirstName( rs.getString("firstName"));
				student.setLastName( rs.getString("lastName"));
				student.setRegistrationNumber(registrationNumber);
				return student;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}


	@Override
	public void saveStudentMark(Student student) {
		
		List<Subject> subjects = student.getSubjects();
	
		try {
		Statement st = con.createStatement();
		for(Subject subject:subjects) {
			String sql = "UPDATE StudentsSubjectsClass SET StudentMark = '" + subject.getSubjectMark() + "' WHERE studentRegNo = '" + student.getRegistrationNumber() + "' AND SubjectName = '" + subject.getName() + "'" ;
			st.executeUpdate(sql);
		}
		}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}


	@Override
	public boolean loginStudent(Student student) {
		
		try {
			Statement st;
			st = con.createStatement();
			
			String trialRegNo = student.getRegistrationNumber();
			
			String sql = "SELECT * FROM Students";
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				String recordedRegNo = rs.getString("registrationNumber");

				if(trialRegNo.equals(recordedRegNo)) {
					String sql1 = "SELECT firstName,lastName,studentClass FROM Students WHERE registrationNumber = '" + recordedRegNo +"'";
					ResultSet rs1 = st.executeQuery(sql1);
					while(rs1.next()) {
						Student student1 = new Student();
						student1.setFirstName( rs1.getString("firstName"));
						student1.setLastName( rs1.getString("lastName"));
						student1.setRegistrationNumber(recordedRegNo);
						student1.setStudentClass(studentClassService.getClassOfName(rs1.getString("studentClass")));
						loggedInStudent = student1;
						return true;
					}
					}	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
				
	}


	@Override
	public List<Subject> getSubjectMarksOfStudent() {
		
		List<Subject> studentSubjects = new ArrayList<>();
		
		String regNo = loggedInStudent.getRegistrationNumber();
		
		try {
			Statement st;
			st = con.createStatement();
			String sql = "SELECT SubjectName,StudentMark FROM StudentsSubjectsClass WHERE studentRegNo = '" + regNo +"'";
			
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				Subject subject = new Subject();
				subject.setName(rs.getString("SubjectName"));
				
				if(rs.getString("StudentMark") != null)
					subject.setSubjectMark(rs.getString("StudentMark"));
				else
					subject.setSubjectMark("Mark not yet recorded");
								
				studentSubjects.add(subject);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return studentSubjects;
	}


	@Override
	public Student getLoggedInStudentDetails() {
		
		Student student = new Student();
		student.setFirstName(loggedInStudent.getFirstName());
		student.setLastName(loggedInStudent.getLastName());
		student.setRegistrationNumber(loggedInStudent.getRegistrationNumber());
		student.setStudentClass(loggedInStudent.getStudentClass());
		
		return student;
	}

}
