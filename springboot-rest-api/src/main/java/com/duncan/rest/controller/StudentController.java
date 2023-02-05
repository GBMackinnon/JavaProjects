package com.duncan.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.duncan.rest.bean.Student;

@RestController
@RequestMapping("Students")
public class StudentController {
	
	/*
	// http://localhost:8080/student
	@GetMapping("/student")
	public Student getStudent() {
		Student student = new Student(1,"Duncan", "Mackinnon");
		return student;	
	}
	*/
	
	// http://localhost:8080/student
	@GetMapping("/student")
	public ResponseEntity<Student> getStudent() {
		Student student = new Student(1,"Duncan", "Mackinnon");
		// return new ResponseEntity<>(student, HttpStatus.Ok)
		return ResponseEntity.ok().header("custom-header", "HeaderValue").body(student);
	}
	
	
	// http://localhost:8080/students
	@GetMapping
	public List<Student> getStudents() {
		List<Student> students = new ArrayList<Student>();
		students.add(new Student(1,"Duncan", "Mackinnon"));
		students.add(new Student(2,"Iona", "Mackinnon"));
		students.add(new Student(2,"Euan", "Mackinnon"));
		return students;	
	}
	
	// Spring BOOT API with Path Variable
	// {id} - uri template variable
	// http://localhost:8080/students/1/billy/bob
	@GetMapping("/{id}/{first-name}/{second-name}")
	public Student studentPathVariable(@PathVariable("id") int StudentId,
									   @PathVariable("first-name") String firstName,
									   @PathVariable("second-name") String SecondName) {
		return new Student(StudentId, firstName, SecondName);
	}
	
	// Spring BOOT REST API with Request Param
	// http://localhost:8080/students/query?id=1&firstName=Big&lastName=Ben
	@GetMapping("/query")
	public Student studentRequestVariable(@RequestParam int id,
										  @RequestParam String firstName,
										  @RequestParam String SecondName) {
		return new Student(id, firstName, SecondName);
	}
	
	// Spring BOOT REST API that handles HTTP Post Request - Create new Resource
	// @PostMapping and @RequestBody
	// http://localhost:8080/students/create
	// Use PostMan to create JSON student in HTTP Request Body
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Student createStudent(@RequestBody Student student) {
		System.out.println(student.getId());
		System.out.println(student.getFirstName());
		System.out.println(student.getLastName());
		return student;
	}
	
	// Spring BOOT REST API that handles HTTP PUT Request - Update Resource
	// http://localhost:8080/students/3/update
	// Use PostMan to create JSON student in HTTP Request Body
	@PutMapping("/{id}/update")
	public Student updateStudent(@RequestBody Student student, @PathVariable("id") int studentId) {
		System.out.println(student.getFirstName());
		System.out.println(student.getLastName());
		return student;
	}
	
	// Spring BOOT REST API that handles HTTP Delete Request - Update Resource
	// http://localhost:8080/students/3/delete
	// Use PostMan to create JSON student in HTTP Request Body
	@DeleteMapping("/{id}/delete")
	public String deleteStudent(@PathVariable("id") int studentId) {
		return "Student Succesfuly Deleted";
	}
	
	
	
	

	
}
