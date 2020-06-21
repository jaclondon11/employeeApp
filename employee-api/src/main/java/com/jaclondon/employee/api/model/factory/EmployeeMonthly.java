package com.jaclondon.employee.api.model.factory;

import static com.jaclondon.employee.api.util.AnualSalaryFunction.YEAR_S_MONTHS;

import com.jaclondon.employee.api.model.ContractType;
import com.jaclondon.employee.api.model.Employee;
import com.jaclondon.employee.api.util.AnualSalaryFunction;

public class EmployeeMonthly extends Employee {

	private static final AnualSalaryFunction ANUAL_SALARY_FUNCTION = (float salary) -> salary * YEAR_S_MONTHS;

	public EmployeeMonthly() {
		super(ContractType.MONTHLY, ANUAL_SALARY_FUNCTION);
	}

}
