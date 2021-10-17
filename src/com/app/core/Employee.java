package com.app.core;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {

	private int empId;
	private String firstName;
	private String lastName;
	private String email;
	private Department deptId;
	private Date joinDate;
	private double salary;

	// add additional state: to establish HAS-A, Employee HAS-A Aadhar card
	private AadharCard card;

	// Add SDF for pasrsing(String --> Date) and format(Date --> String)
	public static SimpleDateFormat sdf;

	// Static init block
	static {
		sdf = new SimpleDateFormat("dd/MM/yyyy");
	}

	public Employee(int empId, String firstName, String lastName, String email, Department deptId, Date joinDate,
			double salary) {
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.deptId = deptId;
		this.joinDate = joinDate;
		this.salary = salary;
	}

	public Employee(int empId) {
		this.empId = empId;
	}

	public void setDeptId(Department deptId) {
		this.deptId = deptId;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {

		String mesg = card == null ? "Aadhar card not yet linked." : card.toString();

		return "Employee {EmpId=" + empId + ", FirstName=" + firstName + ", LastName=" + lastName + ", Email=" + email
				+ ", Dept=" + deptId + ", Join Date=" + sdf.format(joinDate) + ", Salary=" + salary
				+ "\n               " + mesg + "}\n";
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("In emp equals");
		if (obj instanceof Employee)
			return empId == ((Employee) obj).empId;
		return false;
	}

	// add a method to link aadhar card details to the current employee
	public void linkAadharCard(String cardNumber, Date creationDate, String location) {
		this.card = new AadharCard(cardNumber, creationDate, location);
	}

}
