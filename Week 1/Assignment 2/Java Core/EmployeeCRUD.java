import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    private int id;
    private String name;
    private String department;

    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}

public class EmployeeCRUD {
    private ArrayList<Employee> employeeList = new ArrayList<>();

    public void addEmployee(Employee emp) {
        employeeList.add(emp);
        System.out.println("Employee added successfully!");
    }

    public void viewEmployees() {
        if (employeeList.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            System.out.println("Employee List:");
            for (Employee emp : employeeList) {
                System.out.println(emp);
            }
        }
    }

    public void updateEmployee(int id, String newName, String newDepartment) {
        boolean found = false;
        for (Employee emp : employeeList) {
            if (emp.getId() == id) {
                emp.setName(newName);
                emp.setDepartment(newDepartment);
                System.out.println("Employee updated successfully!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    public void deleteEmployee(int id) {
        boolean removed = employeeList.removeIf(emp -> emp.getId() == id);
        if (removed) {
            System.out.println("Employee deleted successfully!");
        } else {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeCRUD crudApp = new EmployeeCRUD();
        int choice;

        do {
            System.out.println("\n==== Employee CRUD Menu ====");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Department: ");
                    String department = sc.nextLine();
                    Employee emp = new Employee(id, name, department);
                    crudApp.addEmployee(emp);
                    break;
                case 2:
                    crudApp.viewEmployees();
                    break;
                case 3:
                    System.out.print("Enter Employee ID to Update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter New Department: ");
                    String newDept = sc.nextLine();
                    crudApp.updateEmployee(updateId, newName, newDept);
                    break;
                case 4:
                    System.out.print("Enter Employee ID to Delete: ");
                    int deleteId = sc.nextInt();
                    crudApp.deleteEmployee(deleteId);
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}
