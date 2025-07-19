package com.example.employee;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeDAO employeeDAO;

    public EmployeeService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public void addEmployee(Employee employee) {
        employeeDAO.save(employee);
    }

    public Employee getEmployee(int id) {
        return employeeDAO.getById(id);
    }

    public List<Employee> getAllEmployees() {
        return employeeDAO.getAll();
    }

    public void updateEmployee(Employee employee) {
        employeeDAO.update(employee);
    }

    public void deleteEmployee(int id) {
        employeeDAO.delete(id);
    }
}
