package com.jaclondon.employee.api.model;

import com.jaclondon.employee.api.util.AnnualSalaryFunctionByHour;

/**
 * Represents the template fields of an employee
 * which AnnualSalaryMethod must be implemented by extended classes
 *
 * 
 * @author Jhoel
 *
 */
public abstract class Employee implements Comparable<Employee>{

	private Long id;
	private String fullName;
	private ContractType contract;
	private float annualSalary;
	private float partialSalary;
	
	private AnnualSalaryFunctionByHour annualSalaryMethod;
	
	public Employee(ContractType contract, AnnualSalaryFunctionByHour annualSalaryMethod) {
		super();
		this.contract = contract;
		addCalculateAnnualSalaryMethod(annualSalaryMethod);
	}
	
	protected void addCalculateAnnualSalaryMethod(AnnualSalaryFunctionByHour annualSalaryMethod) {
		this.annualSalaryMethod = annualSalaryMethod;
	}
	
	@Override
	public int compareTo(Employee o) {
		return this.getId().compareTo( o.getId() );
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public ContractType getContract() {
		return contract;
	}

	protected void setContract(ContractType contract) {
		this.contract = contract;
	}

	public float getAnnualSalary() {
		return annualSalary;
	}
	
	protected void setAnnualSalary(float annualSalary) {
		this.annualSalary = annualSalary;
	}
	
	public float getPartialSalary() {
		return partialSalary;
	}

	public void setPartialSalary(float partialSalary) {
		this.partialSalary = partialSalary;
		calculatedAnnualSalary();
	}

	private void calculatedAnnualSalary() {
		this.annualSalary = annualSalaryMethod.function(partialSalary);
	}

}
