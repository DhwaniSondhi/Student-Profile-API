package org.practice.services;

import java.util.List;

import org.practice.dao.StudentJDBCTemplate;
import org.practice.models.Student;
import org.practice.services.customexceptions.DuplicateKeyException;
import org.practice.services.customexceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {

	@Autowired
	private StudentJDBCTemplate studentJDBCTemplate;
	
	public StudentJDBCTemplate getStudentJDBCTemplate() {
		return studentJDBCTemplate;
	}

	public void setStudentJDBCTemplate(StudentJDBCTemplate studentJDBCTemplate) {
		this.studentJDBCTemplate = studentJDBCTemplate;
	}

	public List<Student> getStudents() {
		return this.studentJDBCTemplate.getAllStudents();		
	}

	public Student getStudent(String id) {
		try {
			return this.studentJDBCTemplate.getStudent(id);
		}catch(EmptyResultDataAccessException exp) {
			throw new NotFoundException("Student with id:"+id+" not found!");
		}
	}
	
	//https://stackoverflow.com/questions/27776919/transaction-rollback-after-catching-exception
	@Transactional(rollbackFor=Exception.class)
	public Student createStudent(Student student) {
		try {
			this.studentJDBCTemplate.createStudent(student);
		}catch(DataIntegrityViolationException exp) {
			throw new DuplicateKeyException("User with id:"+student.getId()+" already exists!");
		}
		return this.getStudent(student.getId());
	}

/*	public Student editStudent(String id, Student student) {
		student.setId(id);
		this.students.put(id, student);
		return this.getStudent(id);
	}

	public void deleteStudent(String id) {
		this.students.remove(id);
	}*/
}
