package com.jaclondon.employee.api.rest;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jaclondon.employee.api.model.Employee;
import com.jaclondon.employee.api.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/employee")
@Api(tags = "employee")
public class EmployeeController {

	private final EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@ApiOperation(value = "Get all Employees info", notes = "Service used to get all employees info")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "data fetched sucessfully")})
	@RequestMapping(method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Employee>> getEmployees() {
		List<Employee> employeeList = employeeService.getAll();
		return ResponseEntity.status(HttpStatus.OK).body(employeeList);
	}
	
	@ApiOperation(value = "Get an employee info by id", notes = "Service used to get an employee info by id")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "employee found"),
			@ApiResponse(code = 404, message = "employee not found with requested id")})
	@RequestMapping(value = "{id}", method = GET,
            produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {
		Employee employee = employeeService.get(id);
		if (employee != null) {
			return ResponseEntity.status(HttpStatus.OK).body(employee);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(employee);
		}
		
    }

}
