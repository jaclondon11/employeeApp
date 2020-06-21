package com.jaclondon.employee.api.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.jaclondon.employee.api.config.TestConfig;
import com.jaclondon.employee.api.model.ContractType;
import com.jaclondon.employee.api.model.Employee;
import com.jaclondon.employee.api.model.builder.EmployeeBuilder;
import com.jaclondon.employee.api.service.EmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
@WebAppConfiguration
public class EmployeeControllerTest {
	
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext wac;
	@Autowired
	private EmployeeService employeeService;

	@Before
	public void before() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		MockitoAnnotations.initMocks(this);
	}
	
//	@Test
	public void shouldReturnEmployeeListWhenNoIdRequested() {
//		List<Employee> employeeListMock = createEmployeeListExpected();
		
//		when(employeeService.getAll()).thenReturn(employeeListMock);
		
//		mockMvc.perform(get("/employees"));
	}
	
	

	private List<Employee> createEmployeeListExpected() {
		List<Employee> employeeList = new ArrayList<>();
		
		Employee employee = EmployeeBuilder
				.createEmployeeWithContract(ContractType.HOURLY)
				.withFullName("Jhoel Acosta Londono")
				.withSalary(30f)
				.getResult();
		employeeList.add(employee);
		
		employee = EmployeeBuilder
				.createEmployeeWithContract(ContractType.MONTHLY)
				.withFullName("Jane Roe")
				.withSalary(4_200f)
				.getResult();
		employeeList.add(employee);
		
		employee = EmployeeBuilder
				.createEmployeeWithContract(null)
				.withFullName("John Doe")
				.withSalary(2_500f)
				.getResult();
		employeeList.add(employee);
		
		employee = EmployeeBuilder
				.createEmployeeWithContract(ContractType.HOURLY)
				.withFullName("Joe Public")
				.withSalary(25.5f)
				.getResult();
		employeeList.add(employee);
		
		return employeeList;
	}



}
