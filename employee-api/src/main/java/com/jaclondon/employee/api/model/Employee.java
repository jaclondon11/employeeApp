package com.jaclondon.employee.api.model;

import com.jaclondon.employee.api.util.AnualSalaryFunction;

public abstract class Employee{

	private Long id;
	private String fullName;
	private ContractType contract;
	private float anualSalary;
	private float partialSalary;
	
	private AnualSalaryFunction anualSalaryMethod;
	
	public Employee() {
		super();
	}

	public Employee(ContractType contract, AnualSalaryFunction anualSalaryMethod) {
		super();
		this.contract = contract;
		addCalculateAnualSalaryMethod(anualSalaryMethod);
	}
	
	protected void addCalculateAnualSalaryMethod(AnualSalaryFunction anualSalaryMethod) {
		this.anualSalaryMethod = anualSalaryMethod;
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

	public void setContract(ContractType contract) {
		this.contract = contract;
	}

	public float getAnualSalary() {
		return anualSalary;
	}
	
	protected void setAnualSalary(float anualSalary) {
		this.anualSalary = anualSalary;
	}
	
	public float getPartialSalary() {
		return partialSalary;
	}

	public void setPartialSalary(float partialSalary) {
		this.partialSalary = partialSalary;
		calculatedAnualSalary();
	}

	private void calculatedAnualSalary() {
		this.anualSalary = anualSalaryMethod.function(partialSalary);
	}

}
