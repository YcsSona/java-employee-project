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
		return "Employee: EmpId=" + empId + ", FirstName=" + firstName + ", LastName=" + lastName + ", Email=" + email
				+ ", Dept=" + deptId + ", Join Date=" + sdf.format(joinDate) + ", Salary=" + salary;
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("In emp equals");
		if (obj instanceof Employee)
			return empId == ((Employee) obj).empId;
		return false;
	}

}
