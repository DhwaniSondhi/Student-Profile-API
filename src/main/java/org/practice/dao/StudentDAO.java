package org.practice.dao;

import java.util.List;

import org.practice.models.Student;

public interface StudentDAO {
	
	public List<Student> getAllStudents();
	public Student getStudent(String id);
	public void createStudent(Student student);
	public void updateStudent(Student student);
	public void deleteStudent(String id);
}
