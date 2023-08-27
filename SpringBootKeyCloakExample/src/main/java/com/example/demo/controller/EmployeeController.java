package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/Employee/get/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable int  id)
	{
	return	ResponseEntity.ok(employeeService.getEmployee(id));
	}
	
	@GetMapping("/Employee")
	public ResponseEntity<List<Employee>> getEmployee()
	{
	return	ResponseEntity.ok(employeeService.getEmployee());
	}
}
