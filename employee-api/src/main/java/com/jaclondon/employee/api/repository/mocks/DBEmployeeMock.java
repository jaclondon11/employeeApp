package com.jaclondon.employee.api.repository.mocks;

import java.util.HashSet;
import java.util.Set;

import com.jaclondon.employee.api.model.ContractType;
import com.jaclondon.employee.api.model.Employee;
import com.jaclondon.employee.api.model.builder.EmployeeBuilder;

public class DBEmployeeMock {

	protected Set<Employee> employeeSet = new HashSet<>();

	public DBEmployeeMock() {
		
		Employee employee = EmployeeBuilder
				.createEmployeeWithContract(ContractType.HOURLY)
				.withId(1L)
				.withFullName("Jhoel Acosta Londono")
				.withSalary(30f)
				.getResult();
		employeeSet.add(employee);
		
		employee = EmployeeBuilder
				.createEmployeeWithContract(ContractType.MONTHLY)
				.withId(2L)
				.withFullName("Jane Roe")
				.withSalary(4_200f)
				.getResult();
		employeeSet.add(employee);
		
		employee = EmployeeBuilder
				.createEmployeeWithContract(null)
				.withId(3L)
				.withFullName("John Doe")
				.withSalary(2_500f)
				.getResult();
		employeeSet.add(employee);
		
		employee = EmployeeBuilder
				.createEmployeeWithContract(ContractType.HOURLY)
				.withId(4L)
				.withFullName("Joe Public")
				.withSalary(25.5f)
				.getResult();
		employeeSet.add(employee);
	}

}
