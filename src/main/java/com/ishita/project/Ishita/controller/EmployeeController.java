package com.ishita.project.Ishita.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ishita.project.Ishita.entity.Admin;
import com.ishita.project.Ishita.entity.Employee;
import com.ishita.project.Ishita.repository.AdminRepository;
import com.ishita.project.Ishita.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@Autowired
	AdminRepository admin_repo;

	@GetMapping("/test")
	public String testingApplication() {
		return "Testing is working";
	}
	
//	@GetMapping("/getAllEmployees")
//	public List<Employee> getEmployees() 
//	{
//		return service.getEmployees();
//	}
	
	//OR

	@SuppressWarnings("rawtypes")
	@GetMapping("/getAllEmployees")
	public ResponseEntity getEmployees() 
	{
		return ResponseEntity.ok(service.getEmployees());
	}
	
	@SuppressWarnings("rawtypes")
	@GetMapping("/checkEmployeeNamePresent/{name}")
	public ResponseEntity checkEmployeeNamePresent(@PathVariable("name")String employee) 
	{
		Boolean check = service.checkEmployeeNamePresent(employee);
		
		if(check==true)
		{
			return ResponseEntity.ok("Employee is available");
		}
		return ResponseEntity.badRequest().body("Employee not available");
	}
	
	@PostMapping("/saveAllEmployees")
	public ResponseEntity saveEmployees(@RequestBody List<Employee> employee)
	{
		service.saveEmplpoyees(employee);
		return ResponseEntity.ok().body(service.getEmployees());
	}
	
	@PutMapping("/updateEmployeeInfo")
	public ResponseEntity updateEmployeeInfo(@RequestBody Employee employee)
	{
		if(service.employeeIdExist(employee.getId()))
		{
			return ResponseEntity.ok(service.updateEmployeeData(employee));	
		}
		
		return ResponseEntity.ok("Employee id doesn't exist");
	}
	
	@DeleteMapping("/deleteEmployeeById/{id}")
	public ResponseEntity deleteEmployee(@PathVariable("id") int emp_id)
	{
		if(service.employeeIdExist(emp_id))
		{
			service.deleteEmployeebyId(emp_id);
			return ResponseEntity.ok("Employee deleted");
		}
		
		return ResponseEntity.ok("Employee id doesn't exist");
	}
	
	@GetMapping("/fetchAdminDetails")
	public List<Admin> fetchAdminDetails()
	{
		return admin_repo.findAll();
	}
	
}
