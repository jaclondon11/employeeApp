package com.jaclondon.employee.api.config;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jaclondon.employee.api.service.EmployeeService;

/**
 * Spring context configuration for Testing purposes
 */
@Configuration
public class TestConfig {
	
	@Bean
	public EmployeeService employeeService() {
		return Mockito.mock(EmployeeService.class);
	}

}
