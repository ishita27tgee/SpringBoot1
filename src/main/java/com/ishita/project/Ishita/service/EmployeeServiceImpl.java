package com.ishita.project.Ishita.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ishita.project.Ishita.entity.Employee;
import com.ishita.project.Ishita.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository repo;
	
	@Override
	public List<Employee> getEmployees() {
		return repo.findAll();
	}

	@Override
	public Boolean checkEmployeeNamePresent(String employee) {

		int check = repo.checkEmployeeNamePresent(employee);
		
		if(check>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void saveEmplpoyees(List<Employee> employees) {

		repo.saveAll(employees);
	}

	@Override
	public Boolean employeeIdExist(int emp_id) {

		return repo.existsById(emp_id);
	}

	@Override
	public Employee updateEmployeeData(Employee emp_info) {

		return repo.save(emp_info);
	}

	@Override
	public void deleteEmployeebyId(int emp_id) 
	{
		repo.deleteById(emp_id);
	}
	
	

}
