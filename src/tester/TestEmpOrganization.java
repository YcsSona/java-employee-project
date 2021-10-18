package tester;

import java.util.Scanner;

import com.app.core.Department;
import com.app.core.Employee;
import com.app.exceptions.EmpHandlingException;
import static utils.ValidationRules.*;
import static com.app.core.Employee.sdf;

public class TestEmpOrganization {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			boolean exit = false;
			int counter = 0;

			System.out.println("Enter total number of employees");
			Employee[] employees = new Employee[sc.nextInt()];

			while (!exit) {
				System.out.println("1. Hire employee");
				System.out.println("2. Update employee salary & dept(Promotion)");
				System.out.println("3. Display employee details.");
				System.out.println("4. Link Aadhar card.");
				System.out.println("5. Press 0 to exit.");
				System.out.println("Enter your choice: ");

				try {
					switch (sc.nextInt()) {
					case 0:
						exit = true;
						break;

					case 1:

						boolean found = false;
						if (counter < employees.length) {
							System.out.println(
									"Enter employee: Id, Firstname, Lastname, Email, DeptId, Join Date(dd/MM/yyyy), Salary");

							Employee employee = validateAllInputs(sc.nextInt(), employees, sc.next(), sc.next(),
									sc.next(), sc.next(), sc.next(), sc.nextDouble());

							employees[counter++] = employee;
							System.out.println("Emp hired.");
						} else {
							throw new EmpHandlingException("Recruitment over.");
						}
						break;

					case 2:
						System.out.println("Enter employee Id to be searched.");
						Employee empById = getEmployeeDetailsById(sc.nextInt(), employees);

						System.out.println("Enter deptId to be shifted.");
						Department dept = validateDept(sc.next());
						empById.setDeptId(dept);

						System.out.println("Enter salary to be incremented.");
						double incrementedSalary = empById.getSalary() + sc.nextDouble();
						empById.setSalary(incrementedSalary);

						break;

					case 3:
						getEmployeeDetails(employees);
						break;

					case 4:
						System.out.println("Enter emp ID to link Aadhar card.");
						empById = getEmployeeDetailsById(sc.nextInt(), employees);
						System.out.println("Enter Aadhar card details: cardNumber, creationDate,location");
						empById.linkAadharCard(sc.next(), sdf.parse(sc.next()), sc.next());
						System.out.println("Aadhar card linked for employee!!!");
						break;

					default:
						System.out.println("Invalid choice");
						break;
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				// clear off all pending inputs from scanner buffer till next line
				sc.nextLine();
			}
		}
	}

}
