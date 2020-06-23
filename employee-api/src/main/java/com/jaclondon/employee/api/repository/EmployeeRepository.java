package com.jaclondon.employee.api.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.jaclondon.employee.api.model.Employee;
import com.jaclondon.employee.api.repository.mocks.DBEmployeeMock;

@Repository
public class EmployeeRepository extends DBEmployeeMock{
	
	public EmployeeRepository() {
		super();
	}

	/**
	 * This method will return all elements ordered by ID
	 * <p>Time Complexity: O(log(n))
	 * Obviously this method and findById are not the most optimal because we are working with a hashset
	 * in the DBMock. Those Operations are made by a real DB and it have most optimum algorithms
	 *  to sort and find elements
	 * </a>
	 * @return
	 */
	public List<Employee> findAll() {
		return super.employeeSet.stream().sorted().collect(Collectors.toList());
	}
	

	/**
	 * This method will return the element if is found an element in the set with the same ID 
	 * <p>Time Complexity: 
	 * - Best Case: O(1);
	 * - Expected Case: O(n);
	 * - Worst Case: O(n).
	 * Because the stream will loop over all elements in the set, and it will validate if the ID of the element
	 * is the same, else the loop will continue until n element
	 * </a>
	 * @param id
	 * @return a list with the element found or empty if it's not found
	 */
	public List<Employee> findById(Long id) {
		Optional<Employee> optional = super.employeeSet.stream()
		.filter(emp -> id.equals(emp.getId()))
		.findFirst();
		
		List<Employee> result = new ArrayList<>();
		if (optional.isPresent()) {
			result.add(optional.get());
		}
		return result;		
	}

}
