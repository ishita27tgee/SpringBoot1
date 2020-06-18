package com.ishita.project.Ishita.service;

import java.util.List;

import com.ishita.project.Ishita.entity.Employee;


public interface EmployeeService {
	
	public List<Employee> getEmployees(); 
	
	public Boolean checkEmployeeNamePresent(String employee);
	
	public void saveEmplpoyees(List<Employee> employees);
	
	public Boolean employeeIdExist(int emp_id);
	
	public Employee updateEmployeeData(Employee emp_info);
	
	public void deleteEmployeebyId(int emp_id);

}
