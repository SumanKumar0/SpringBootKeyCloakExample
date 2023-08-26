package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Employee;

public interface EmployeeService {
	
	void initilizeEmployee();
	Employee getEmployee(int id);
	List<Employee> getEmployee();

}
