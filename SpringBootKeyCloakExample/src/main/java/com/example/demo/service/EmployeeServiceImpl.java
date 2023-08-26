package com.example.demo.service;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.Employee;
import com.example.demo.repo.EmployeeRepository;

import jakarta.annotation.PostConstruct;

public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
EmployeeRepository empRepo;
	@PostConstruct
	@Override
	public void initilizeEmployee() {
		empRepo.saveAll(
				Stream.of(new Employee("suman",100),
				new Employee("dipu",200),
				new Employee("golu",900)).toList()
				);

	}

	@Override
	public Employee getEmployee(int id) {
		return empRepo.findById(id).orElse(null);
	}

	@Override
	public List<Employee> getEmployee() {
		
		return empRepo.findAll();
	}

}
