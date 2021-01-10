package org.practice.controllers;


import java.util.List;

import org.practice.models.Student;
import org.practice.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class StudentController {

	@Autowired
	private StudentService studentservice;

	@GetMapping("/getStudents")
	public List<Student> getStudents(){
		return this.studentservice.getStudents();
	}
	
	@GetMapping("/getStudent/{id}")
	public Student getStudent(@PathVariable String id) {
		return this.studentservice.getStudent(id);
	}
	
	@PostMapping("/createStudent")
	public Student createStudent(@RequestBody Student student) {
		return this.studentservice.createStudent(student);
	}
	
	/*@PutMapping("/editStudent/{id}")
	public Student editStudent(@PathVariable String id, @RequestBody Student student) {
		return this.studentservice.editStudent(id, student);
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public void deleteStudent(@PathVariable String id) {
		this.studentservice.deleteStudent(id);
	}*/
}
