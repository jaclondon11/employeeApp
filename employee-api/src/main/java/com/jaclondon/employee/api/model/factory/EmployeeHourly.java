package com.jaclondon.employee.api.model.factory;

import static com.jaclondon.employee.api.util.AnnualSalaryFunctionByHour.WORK_MONTH_IN_HOURS;
import static com.jaclondon.employee.api.util.AnnualSalaryFunctionByHour.YEAR_S_MONTHS;

import com.jaclondon.employee.api.model.ContractType;
import com.jaclondon.employee.api.model.Employee;
import com.jaclondon.employee.api.util.AnnualSalaryFunctionByHour;

/**
 * Represents an employee with an hourly contract type
 * with its yearly salary function
 * 
 * @author Jhoel
 *
 */
public class EmployeeHourly extends Employee {

	private static final AnnualSalaryFunctionByHour YEARLY_SALARY_FUNCTION = (float salary) -> WORK_MONTH_IN_HOURS
			* salary * YEAR_S_MONTHS;

	public EmployeeHourly() {
		super(ContractType.HOURLY, YEARLY_SALARY_FUNCTION);
	}

}
