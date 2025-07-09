import java.sql.*;
import java.util.Scanner;

public class EmployeeJDBC {
    private static final String URL = "jdbc:mysql://localhost:3000/company";
    private static final String USER = "root";
    private static final String PASSWORD = "harshit12";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: addEmployee(); break;
                case 2: viewEmployees(); break;
                case 3: updateEmployee(); break;
                case 4: deleteEmployee(); break;
                case 5: System.exit(0);
                default: System.out.println("Invalid choice!");
            }
        }
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private static void addEmployee() {
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO employee VALUES (?, ?, ?)")) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine(); // Consume newline
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Department: ");
            String dept = sc.nextLine();

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, dept);

            int rows = ps.executeUpdate();
            System.out.println(rows + " Employee(s) added.");
        } catch (SQLException e) {
            System.out.println("Error adding employee: " + e.getMessage());
        }
    }

    private static void viewEmployees() {
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM employee")) {
            System.out.println("\nEmployee List:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                                   ", Name: " + rs.getString("name") +
                                   ", Department: " + rs.getString("department"));
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving employees: " + e.getMessage());
        }
    }

    private static void updateEmployee() {
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement("UPDATE employee SET name=?, department=? WHERE id=?")) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter ID of Employee to Update: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter New Name: ");
            String name = sc.nextLine();
            System.out.print("Enter New Department: ");
            String dept = sc.nextLine();

            ps.setString(1, name);
            ps.setString(2, dept);
            ps.setInt(3, id);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Employee updated.");
            } else {
                System.out.println("Employee not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error updating employee: " + e.getMessage());
        }
    }

    private static void deleteEmployee() {
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement("DELETE FROM employee WHERE id=?")) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter ID of Employee to Delete: ");
            int id = sc.nextInt();

            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Employee deleted.");
            } else {
                System.out.println("Employee not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting employee: " + e.getMessage());
        }
    }
}
