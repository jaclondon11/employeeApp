package com.jaclondon.employee.api.model.builder;

import com.jaclondon.employee.api.model.ContractType;
import com.jaclondon.employee.api.model.Employee;
import com.jaclondon.employee.api.model.factory.EmployeeHourly;
import com.jaclondon.employee.api.model.factory.EmployeeMonthly;

/**
 * Builder utility to instantiate an {@link EmployeeHourly} or {@link EmployeeMonthly} 
 * depending on {@link ContractType}
 * @author Jhoel
 *
 */
public class EmployeeBuilder {

	private Employee employee;

	private EmployeeBuilder() {
		super();
	}

	/**
	 * Create an {@link EmployeeBuilder} with a specific {@link ContractType} if contractType is not specified then
	 * contractType will be assigned as MONTHLY
	 * @param contractType
	 * @return
	 */
	public static EmployeeBuilder createEmployeeWithContract(ContractType contractType) {
		EmployeeBuilder builder = new EmployeeBuilder();
		if (contractType == null) {
			builder.employee = new EmployeeMonthly();
		}else {
			switch (contractType) {
			case HOURLY:
				builder.employee = new EmployeeHourly();
				break;
			case MONTHLY:
				builder.employee = new EmployeeMonthly();
				break;
			default:
				builder.employee = new EmployeeMonthly();
			}
		}
		
		return builder;
	}

	public EmployeeBuilder withFullName(String fullName) {
		employee.setFullName(fullName);
		return this;
	}

	public EmployeeBuilder withSalary(float partialSalaray) {
		employee.setPartialSalary(partialSalaray);
		return this;
	}
	
	public EmployeeBuilder withId(Long id) {
		employee.setId(id);
		return this;
	}

	/**
	 * Return the employee builded with its attributes 
	 * @return employee
	 */
	public Employee getResult() {
		return employee;
	}

}
