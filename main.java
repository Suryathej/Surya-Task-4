import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Employee {
    private String id;
    private String name;
    private String position;
    private double salary;

    public Employee(String id, String name, String position, double salary) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }
}

public class Main {
    private static Map<String, Employee> employees = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Employee Management Application!");

        int choice;
        do {
            System.out.println("\nMenu Options:");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. View All Employees");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    viewEmployee();
                    break;
                case 3:
                    updateEmployee();
                    break;
                case 4:
                    deleteEmployee();
                    break;
                case 5:
                    viewAllEmployees();
                    break;
                case 6:
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 6.");
            }
        } while (choice != 6);
    }

    private static void addEmployee() {
        System.out.println("\nAdding Employee:");
        System.out.print("Enter Employee ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Employee Position: ");
        String position = scanner.nextLine();
        System.out.print("Enter Employee Salary: ");
        double salary = scanner.nextDouble();
        employees.put(id, new Employee(id, name, position, salary));
        System.out.println("Employee added successfully!");
    }

    private static void viewEmployee() {
        System.out.println("\nViewing Employee:");
        System.out.print("Enter Employee ID: ");
        String id = scanner.nextLine();
        Employee employee = employees.get(id);
        if (employee != null) {
            System.out.println("Employee ID: " + employee.getId());
            System.out.println("Employee Name: " + employee.getName());
            System.out.println("Employee Position: " + employee.getPosition());
            System.out.println("Employee Salary: " + employee.getSalary());
        } else {
            System.out.println("Employee not found with ID: " + id);
        }
    }

    private static void updateEmployee() {
        System.out.println("\nUpdating Employee:");
        System.out.print("Enter Employee ID: ");
        String id = scanner.nextLine();
        Employee employee = employees.get(id);
        if (employee != null) {
            System.out.print("Enter new Employee Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new Employee Position: ");
            String position = scanner.nextLine();
            System.out.print("Enter new Employee Salary: ");
            double salary = scanner.nextDouble();
            employee = new Employee(id, name, position, salary);
            employees.put(id, employee);
            System.out.println("Employee updated successfully!");
        } else {
            System.out.println("Employee not found with ID: " + id);
        }
    }

    private static void deleteEmployee() {
        System.out.println("\nDeleting Employee:");
        System.out.print("Enter Employee ID: ");
        String id = scanner.nextLine();
        Employee removedEmployee = employees.remove(id);
        if (removedEmployee != null) {
            System.out.println("Employee deleted successfully!");
        } else {
            System.out.println("Employee not found with ID: " + id);
        }
    }

    private static void viewAllEmployees() {
        System.out.println("\nAll Employees:");
        for (Employee employee : employees.values()) {
            System.out.println("Employee ID: " + employee.getId());
            System.out.println("Employee Name: " + employee.getName());
            System.out.println("Employee Position: " + employee.getPosition());
            System.out.println("Employee Salary: " + employee.getSalary());
            System.out.println();
        }
    }
}
