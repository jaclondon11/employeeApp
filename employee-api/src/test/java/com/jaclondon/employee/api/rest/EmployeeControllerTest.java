package com.jaclondon.employee.api.rest;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.jaclondon.employee.api.config.TestConfig;
import com.jaclondon.employee.api.model.ContractType;
import com.jaclondon.employee.api.model.Employee;
import com.jaclondon.employee.api.model.builder.EmployeeBuilder;
import com.jaclondon.employee.api.service.EmployeeService;

@AutoConfigureMockMvc
@ContextConfiguration(classes = { TestConfig.class, EmployeeController.class })
@WebMvcTest
public class EmployeeControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext wac;
	@Autowired
	private EmployeeService employeeService;

	@BeforeEach
	public void before() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	
	@Test
	public void shouldRespondStatusOKWhenGetAllEmployee() throws Exception {
		List<Employee> employeeListMock = new ArrayList<>();
		when(employeeService.getAll()).thenReturn(employeeListMock);
		
		mockMvc.perform(get("/api/employee"))
			.andExpect(status().isOk());
	}
	
	@Test
	public void shouldRespondEmployeeListWhenIdRequested() throws Exception {
		List<Employee> employeeListMock = createEmployeeListExpected();
		when(employeeService.get(1l)).thenReturn(employeeListMock);
		
		mockMvc.perform(get("/api/employee/1"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$", hasSize(1)))
			.andExpect(
					jsonPath("$[0].fullName",
							is(employeeListMock.get(0).getFullName())));
	}
	
	@Test
	public void shouldRespondEmployeeListEmptyAndStatusNotFoundWhenIdRequestedNotExist() throws Exception {
		List<Employee> employeeListMock = new ArrayList<>();
		when(employeeService.get(1l)).thenReturn(employeeListMock);
		
		mockMvc.perform(get("/api/employee/99"))
			.andExpect(status().isNotFound())
			.andExpect(jsonPath("$", hasSize(0)));
	}
	
	
	

	private List<Employee> createEmployeeListExpected() {
		List<Employee> employeeList = new ArrayList<>();
		
		Employee employee = EmployeeBuilder
				.createEmployeeWithContract(null)
				.withId(1l)
				.withFullName("John Doe")
				.withSalary(2_500f)
				.getResult();
		employeeList.add(employee);
		
		return employeeList;
	}



}
