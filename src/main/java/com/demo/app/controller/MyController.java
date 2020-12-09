package com.demo.app.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.demo.app.dto.Department;
import com.demo.app.dto.Employee;

import comdemo.app.exception.RecordFoundException;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "employee")
public class MyController {
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Object> getEmployeeDetails(@PathVariable(value = "id") Integer id)
			throws MalformedURLException, RecordFoundException {
		if(id <= 0) {
			throw new RecordFoundException("Employee not found for id "+id);
		}
		Employee employee = new Employee();
		employee.setName(id.toString());
		URI locaUrl = ServletUriComponentsBuilder.fromCurrentRequest().path("{/{id}").buildAndExpand(id).toUri();
		return ResponseEntity.created(locaUrl).body(employee);
	}
	
	@GetMapping
	public ResponseEntity<Object> getAllEmployeeDetails(){
		Employee employee = new Employee();
		employee.setName("Ajinkya Ranade");
		List<Employee> list = new ArrayList<Employee>();
		list.add(employee);
		URI locaUrl = ServletUriComponentsBuilder.fromCurrentRequest().path("{/{id}").buildAndExpand(1).toUri();
		return ResponseEntity.created(locaUrl).body(employee);
	}
	
	@GetMapping(value = "/department/{departmentId}")
	public ResponseEntity<Department> getDepartment(@PathVariable(value = "departmentId") Integer id) {

		Department department = new Department();
		department.setDepId(id);
		 Link withSelfRel = linkTo(methodOn(this.getClass()).getAllDepartment()).withSelfRel();
		 department.add(withSelfRel);
		return new ResponseEntity<Department>(department, HttpStatus.OK);

	}
	
	@GetMapping(value = "/departments")
	public ResponseEntity<List<Department>> getAllDepartment() {

		Department department = new Department();
		department.setDepId(1);
		ArrayList<Department> list = new ArrayList<Department>();
		list.add(department);
		return new ResponseEntity<List<Department>>(list, HttpStatus.OK);

	}
	

}
