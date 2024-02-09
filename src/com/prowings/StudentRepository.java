package com.prowings;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class StudentRepository {

	public int createStudent(Student s) {
		Connection con = null;
		int res = 0;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee-db", "prowingsuser",
					"prowingsuser");
			Statement stmt = con.createStatement();
			int id = s.getId();
			String name = s.getName();
			String subject = s.getSubject();
			int roll = s.getRollNo();
			String insertQuery = "insert into student values("+id+","+"'"+name+"'"+","+"'"+subject+"'"+","+roll+")";
			res = stmt.executeUpdate(insertQuery);

			if (res > 0)
				System.out.println("Student record inserted successfully.. afftected rows are : " + res);
			else
				System.out.println("Record not inserted!!");

		} catch (SQLException e) {
			System.out.println("Some exception occurred while connecting to the DB!!");
			e.printStackTrace();
		} finally {
			try {
				con.close();
				System.out.println("Connection closed successfully!!!");
			} catch (SQLException e) {
				System.out.println("Error while closing the connection!!");
				e.printStackTrace();
			}
		}
		return res;

	}
	
	public Student getStudent(int id)
	{
		return null;
		
	}

	public List<Student> getAllStudents()
	{
		return null;
		
	}

	public boolean deleteStudent(int id)
	{
		return false;
		
	}
	
	public boolean updateStudent(Student updatedStudent)
	{
		return false;
	}

}
