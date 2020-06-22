package com.jaclondon.employee.api.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.jaclondon.employee.api.model.ContractType;
import com.jaclondon.employee.api.model.Employee;
import com.jaclondon.employee.api.model.builder.EmployeeBuilder;

@Repository
public class EmployeeRepository {
	
	private static List<Employee> employeeList = null;

	public EmployeeRepository() {
		employeeList = new ArrayList<>();
		
		Employee employee = EmployeeBuilder
				.createEmployeeWithContract(ContractType.HOURLY)
				.withId(1L)
				.withFullName("Jhoel Acosta Londono")
				.withSalary(30f)
				.getResult();
		employeeList.add(employee);
		
		employee = EmployeeBuilder
				.createEmployeeWithContract(ContractType.MONTHLY)
				.withId(2L)
				.withFullName("Jane Roe")
				.withSalary(4_200f)
				.getResult();
		employeeList.add(employee);
		
		employee = EmployeeBuilder
				.createEmployeeWithContract(null)
				.withId(3L)
				.withFullName("John Doe")
				.withSalary(2_500f)
				.getResult();
		employeeList.add(employee);
		
		employee = EmployeeBuilder
				.createEmployeeWithContract(ContractType.HOURLY)
				.withId(4L)
				.withFullName("Joe Public")
				.withSalary(25.5f)
				.getResult();
		employeeList.add(employee);
	}

	public List<Employee> findAll() {
		return employeeList;
	}

	public List<Employee> findById(Long id) {
		return employeeList.stream()
			.filter(emp -> id.equals(emp.getId()))
			.collect(Collectors.toList());		
	}

}
