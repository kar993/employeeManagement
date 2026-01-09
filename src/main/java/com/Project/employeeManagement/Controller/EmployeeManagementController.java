package com.Project.employeeManagement.Controller;

import com.Project.employeeManagement.Dto.ApiResponse;
import com.Project.employeeManagement.Entity.Employee;
import com.Project.employeeManagement.Service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/employees")
public class EmployeeManagementController {
    private final EmployeeService employeeService;

    EmployeeManagementController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ApiResponse<Employee> createEmployee(@Valid @RequestBody Employee employeeEntry) {
        Employee saved = employeeService.createEmployee(employeeEntry);
        return new ApiResponse<>(true, saved, "Employee created successfully");
    }

    @GetMapping
    public ApiResponse<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        if(employees.isEmpty()) return new ApiResponse<>(true, employees, "No Employees in the database");
        return new ApiResponse<>(true, employees, "Employees retrieved successfully");
    }

    @GetMapping("/{id}")
    public ApiResponse<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        return new ApiResponse<>(true, employee, "Employee retrieved successfully");
    }

    @PutMapping("/{id}")
    public ApiResponse<Employee> updateEmployeeById(@PathVariable Long id, @Valid @RequestBody Employee employeeEntry) {
        Employee updated = employeeService.updateEmployeeById(id, employeeEntry);
        return new ApiResponse<>(true, updated, "Employee updated successfully");
    }

    @DeleteMapping("/{id}") public ApiResponse<Void> deleteEmployeeById(@PathVariable Long id) {
        employeeService.deleteEmployeeById(id);
        return new ApiResponse<>(true, null, "Employee deleted successfully");
    }
}