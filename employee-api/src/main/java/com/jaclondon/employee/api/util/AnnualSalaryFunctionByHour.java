package com.jaclondon.employee.api.util;

@FunctionalInterface
public interface AnnualSalaryFunctionByHour {
	
	public static final int WORK_MONTH_IN_HOURS = 120;
	public static final int YEAR_S_MONTHS = 12;
	
	float function(float partialSalary);

}
