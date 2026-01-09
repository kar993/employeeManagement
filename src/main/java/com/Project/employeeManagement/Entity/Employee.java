package com.Project.employeeManagement.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employeeId;

    @NotBlank(message = "Name is required.")
    @Size(min = 3, message = "Name must be at least 3 characters.")
    @Pattern(regexp = "[A-Za-z ]+$", message = "Name should not contain special characters.")
    private String employeeName;

    @NotBlank(message = "Email address is required.")
    @Email(message = "Email must be of valid format.")
    private String employeeEmailAddress;

    @NotBlank(message = "Department is required.")
    private String employeeDepartment;

    @Positive(message = "Salary must be above 0.")
    private double employeeSalary;


    public long getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }


    public String getEmployeeName() {
        return employeeName;
    }
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }


    public String getEmployeeEmailAddress() {
        return employeeEmailAddress;
    }
    public void setEmployeeEmailAddress(String employeeEmailAddress) {
        this.employeeEmailAddress = employeeEmailAddress;
    }


    public String getEmployeeDepartment() {
        return employeeDepartment;
    }
    public void setEmployeeDepartment(String employeeDepartment) {
        this.employeeDepartment = employeeDepartment;
    }


    public double getEmployeeSalary() {
        return employeeSalary;
    }
    public void setEmployeeSalary(double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }
}
