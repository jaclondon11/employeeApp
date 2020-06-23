package com.jaclondon.employee.service;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.hamcrest.text.IsEmptyString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jaclondon.employee.api.model.ContractType;
import com.jaclondon.employee.api.model.Employee;
import com.jaclondon.employee.api.model.builder.EmployeeBuilder;
import com.jaclondon.employee.api.repository.EmployeeRepository;
import com.jaclondon.employee.api.service.EmployeeServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeServiceImplTest {

	private EmployeeRepository employeeRepository = new EmployeeRepository();
	
	private EmployeeServiceImpl service;
	
	@BeforeEach
	public void init() {
 		service = new EmployeeServiceImpl(employeeRepository);
	}
	
	@Test
	public void shouldReturnAllEmployees() {
		List<Employee> employeeListExpected = createEmployeeListExpected();
		
		List<Employee> employeeList = service.getAll();
		
		assertTrue(CollectionUtils.isNotEmpty(employeeList));
		assertEquals(employeeListExpected.size(), employeeList.size());
		assertThat(employeeList, everyItem(hasProperty("id", notNullValue())));
		assertThat(employeeList, everyItem(hasProperty("contract")));
		assertThat(employeeList, everyItem(hasProperty("partialSalary")));
		assertThat(employeeList, everyItem(hasProperty("fullName", is(not(IsEmptyString.isEmptyOrNullString())))));
		assertThat(employeeList, everyItem(hasProperty("annualSalary", is(greaterThan(0f)))));
	}
	
	

	private List<Employee> createEmployeeListExpected() {
		List<Employee> employeeList = new ArrayList<>();
		
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
		
		return employeeList;
	}

}
