package org.practice.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.practice.models.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentService {

	private HashMap<String, Student> students;

	public void setStudents(HashMap<String, Student> students) {
		this.students = students;
	}

	public List<Student> getStudents() {
		return new ArrayList<Student>(this.students.values());
	}

	public Student getStudent(String id) {
		return this.students.get(id);
	}

	public Student addStudent(Student student) {
		this.students.put(student.getId(), student);
		return this.getStudent(student.getId());
	}

	public Student editStudent(String id, Student student) {
		student.setId(id);
		this.students.put(id, student);
		return this.getStudent(id);
	}

	public void deleteStudent(String id) {
		this.students.remove(id);
	}
}
