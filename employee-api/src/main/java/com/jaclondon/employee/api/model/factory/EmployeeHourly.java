package com.jaclondon.employee.api.model.factory;

import static com.jaclondon.employee.api.util.AnualSalaryFunction.WORK_MONTH_IN_HOURS;
import static com.jaclondon.employee.api.util.AnualSalaryFunction.YEAR_S_MONTHS;

import com.jaclondon.employee.api.model.ContractType;
import com.jaclondon.employee.api.model.Employee;
import com.jaclondon.employee.api.util.AnualSalaryFunction;

public class EmployeeHourly extends Employee{
	
	private static final AnualSalaryFunction ANUAL_SALARY_FUNCTION = (float salary) -> WORK_MONTH_IN_HOURS * salary * YEAR_S_MONTHS;

	public EmployeeHourly() {
		super(ContractType.HOURLY, ANUAL_SALARY_FUNCTION);
	}
	
}
