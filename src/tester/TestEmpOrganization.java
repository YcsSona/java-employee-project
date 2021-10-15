package tester;

import java.util.Scanner;

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
				System.out.println("2. Display employee details.");
				System.out.println("3. Press 0 to exit.");
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
							Employee employee = new Employee(validateEmpId(sc.nextInt(), employees),
									validateName(sc.next(), "First"), validateName(sc.next(), "Last"),
									validateEmail(sc.next()), validateDept(sc.next()), parseValidateJoinDate(sc.next()),
									sc.nextDouble());

							employees[counter++] = employee;
							System.out.println("Emp hired.");
						} else {
							throw new EmpHandlingException("Recruitment over.");
						}
						break;

					case 2:
						for (Employee emp : employees) {
							if (emp != null) {
								System.out.println(emp.toString());
							}
						}

						break;

					default:
						System.out.println("Invalid choice");
						break;
					}
				} catch (Exception e) {
					System.out.println("Error: " + e);
				}
				// clear off all pending inputs from scanner buffer till next line
				sc.nextLine();
			}
		}
	}

}
