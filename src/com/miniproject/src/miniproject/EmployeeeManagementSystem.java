package miniproject;

import java.util.List;
import java.util.Scanner;

public class EmployeeeManagementSystem {

    private static final EmployeeDAO employeeDAO = new EmployeeDAO();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Employee Management System");
            System.out.println("1. Show Employee Details");
            System.out.println("2. Add Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    showEmployeeDetails();
                    break;
                case 2:
                    addEmployee();
                    break;
                case 3:
                    updateEmployee();
                    break;
                case 4:
                    deleteEmployee();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void showEmployeeDetails() {
        List<Employee> employees = employeeDAO.getAllEmployees();
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }

    private static void addEmployee() {
        System.out.print("Enter employee id: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline after int input

        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();

        System.out.print("Enter employee position: ");
        String position = scanner.nextLine();

        System.out.print("Enter employee salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();  // Consume newline after double input

        Employee employee = new Employee(id, name, position, salary);
        if (employeeDAO.addEmployee(employee)) {
            System.out.println("Employee added successfully.");
        } else {
            System.out.println("Failed to add employee.");
        }
    }

    private static void updateEmployee() {
        System.out.print("Enter employee ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.print("Enter new employee name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new employee position: ");
        String position = scanner.nextLine();
        System.out.print("Enter new employee salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();  // Consume newline

        Employee employee = new Employee(id, name, position, salary);
        if (employeeDAO.updateEmployee(employee)) {
            System.out.println("Employee updated successfully.");
        } else {
            System.out.println("Failed to update employee.");
        }
    }

    private static void deleteEmployee() {
        System.out.print("Enter employee ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        if (employeeDAO.deleteEmployee(id)) {
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("Failed to delete employee.");
        }
    }
}
