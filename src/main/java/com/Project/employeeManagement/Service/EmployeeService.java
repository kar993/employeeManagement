package com.Project.employeeManagement.Service;

import com.Project.employeeManagement.Entity.Employee;

import java.util.*;

public interface EmployeeService {
    Employee createEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    Employee updateEmployeeById(Long id, Employee employee);
    void deleteEmployeeById(Long id);
}