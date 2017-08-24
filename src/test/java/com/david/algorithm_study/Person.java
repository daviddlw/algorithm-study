package com.david.algorithm_study;

public class Person {
	private Department department;

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Person [department=" + department + "]";
	}

	
}
