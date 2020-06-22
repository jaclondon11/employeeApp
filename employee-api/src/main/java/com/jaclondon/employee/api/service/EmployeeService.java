package com.jaclondon.employee.api.service;

import java.util.List;

import com.jaclondon.employee.api.model.Employee;

public interface EmployeeService {

	List<Employee> getAll();

	List<Employee> get(Long id);

}
