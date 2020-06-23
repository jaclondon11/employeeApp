package com.jaclondon.employee.api.model.builder;

import static com.jaclondon.employee.api.util.AnnualSalaryFunctionByHour.WORK_MONTH_IN_HOURS;
import static com.jaclondon.employee.api.util.AnnualSalaryFunctionByHour.YEAR_S_MONTHS;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jaclondon.employee.api.model.ContractType;
import com.jaclondon.employee.api.model.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeBuilderTest {
	
	@Test
	public void shouldCalculatedHourlyFunctionWhenContractIsHourly() {
		float partialSalary = 30f;
		Employee employee = EmployeeBuilder
				.createEmployeeWithContract(ContractType.HOURLY)
				.withId(1L)
				.withFullName("John Doe")
				.withSalary(partialSalary)
				.getResult();
		float annualSalaryExpected = annualySalaryFunctionByHour(partialSalary);
		
		float annualSalaryResult = employee.getAnnualSalary();
		
		assertThat(new Double(annualSalaryResult), closeTo(annualSalaryExpected, 0));
		
	}
	
	@Test
	public void shouldCalculatedMonthlyFunctionWhenContractIsMontly() {
		float partialSalary = 4_200f;
		Employee employee = EmployeeBuilder
				.createEmployeeWithContract(ContractType.MONTHLY)
				.withId(1L)
				.withFullName("John Doe")
				.withSalary(partialSalary)
				.getResult();
		float annualSalaryExpected = annualSalaryFunctionByMontly(partialSalary);
		
		float annualSalaryResult = employee.getAnnualSalary();
		
		assertThat(new Double(annualSalaryResult), closeTo(annualSalaryExpected, 0));
		
	}
	
	@Test
	public void shouldCalculatedMonthlyFunctionWhenContractIsNull() {
		float partialSalary = 4_200f;
		Employee employee = EmployeeBuilder
				.createEmployeeWithContract(null)
				.withId(1L)
				.withFullName("John Doe")
				.withSalary(partialSalary)
				.getResult();
		float annualSalaryExpected = annualSalaryFunctionByMontly(partialSalary);
		
		float annualSalaryResult = employee.getAnnualSalary();
		
		assertThat(new Double(annualSalaryResult), closeTo(annualSalaryExpected, 0));
		
	}
	
	@Test
	public void shouldBuilderBuildCorrectlyEachField() {
		float partialSalary = 4_200f;
		Employee employee = EmployeeBuilder
				.createEmployeeWithContract(ContractType.MONTHLY)
				.withId(1L)
				.withFullName("John Doe")
				.withSalary(partialSalary)
				.getResult();
		
		assertThat(employee.getId(), is(1L));
		assertThat(employee.getFullName(), is("John Doe"));
		assertThat(employee.getContract(), is(ContractType.MONTHLY));
		assertThat(employee.getPartialSalary(), is(partialSalary));
		
	}
	
	private float annualySalaryFunctionByHour(float hourSalary) {
		return WORK_MONTH_IN_HOURS * hourSalary
				* YEAR_S_MONTHS;
	}
	
	private float annualSalaryFunctionByMontly(float monthSalary) {
		return monthSalary * YEAR_S_MONTHS;
	}

}
