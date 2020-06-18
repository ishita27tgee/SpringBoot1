package com.ishita.project.Ishita.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ishita.project.Ishita.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	@Query(value="select count(*) from employee where employee_name=?1", nativeQuery = true)
	public int checkEmployeeNamePresent(String employee);
	
}
