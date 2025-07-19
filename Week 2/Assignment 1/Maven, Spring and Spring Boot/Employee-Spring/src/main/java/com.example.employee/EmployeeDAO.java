package com.example.employee;

import java.util.List;

public interface EmployeeDAO {
    void save(Employee employee);
    Employee getById(int id);
    List<Employee> getAll();
    void update(Employee employee);
    void delete(int id);
}
