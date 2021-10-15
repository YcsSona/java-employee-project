package utils;

import java.text.ParseException;
import java.util.Date;

import com.app.core.Employee;
import com.app.exceptions.EmpHandlingException;
import static com.app.core.Employee.sdf;

public class ValidationRules {

	public static final int MIN_LEN;
	public static final int MAX_LEN;
	public static Date threshold_date;

	static {
		MIN_LEN = 4;
		MAX_LEN = 15;
		try {
			threshold_date = sdf.parse("1/4/2021");
		} catch (ParseException e) {
			System.out.println("Error in static init block " + e);
		}
	}

	// Add a static method to validate: email
	// Rule: must contain "@" and must end with ".com"
	public static String validateEmail(String email) throws EmpHandlingException {
		if (email.contains("@") && email.endsWith(".com"))
			return email;
		throw new EmpHandlingException("Invalid email!!!"); // will throw checked exc so we have 2 ways to handle it
	}

	// Validate: FirstName and LastName
	// Rule: Min len = 4 and Max len = 15
	public static String validateName(String name, String mesg) throws EmpHandlingException {
		if (name.length() >= MIN_LEN && name.length() <= MAX_LEN)
			return name;
		throw new EmpHandlingException("Invalid " + mesg + " Name: Must be within 4-15 characters");
	}

	// Validate: Dept name
	// Rule: RnD, Finance, Marketing, HR
	public static String validateDept(String dept) throws EmpHandlingException {
		switch (dept) {
		case "Rnd":
		case "Finance":
		case "HR":
		case "Marketing":
			return dept;

		default:
			throw new EmpHandlingException("Invalid department.");
		}
	}

	// Parsing and validation of Join date
	public static Date parseValidateJoinDate(String joinDate) throws ParseException, EmpHandlingException {
		// parsing: String --> Date
		Date date = sdf.parse(joinDate);
		// validate
		if (date.after(threshold_date))
			return date;
		// validation failure
		throw new EmpHandlingException("Invalid join date.");
	}

	// Validate empId
	public static int validateEmpId(int empId, Employee[] empData) throws EmpHandlingException {

		Employee newEmp = new Employee(empId);

		for (Employee e : empData) {
			if (e != null) {
				if (e.equals(newEmp)) {
					throw new EmpHandlingException("Duplicate record found.");
				}
			}
		}
		return empId;
	}
}