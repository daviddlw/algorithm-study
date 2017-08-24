package com.david.algorithm_study;

public class Department {

	private String chargeCode;

	private Person manager;

	public String getChargeCode() {
		return chargeCode;
	}

	public void setChargeCode(String chargeCode) {
		this.chargeCode = chargeCode;
	}

	public Person getManager() {
		return manager.getDepartment().getManager();
	}

	public void setManager(Person manager) {
		this.manager = manager;
	}

	@Override
	public String toString() {
		return "Department [chargeCode=" + chargeCode + ", manager=" + manager + "]";
	}

}
