package com.Project.employeeManagement.Service;

import com.Project.employeeManagement.Entity.Employee;
import com.Project.employeeManagement.Exceptions.EmployeeAlreadyExistsException;
import com.Project.employeeManagement.Exceptions.EmployeeNotFoundException;
import com.Project.employeeManagement.Exceptions.EmptyDatabaseException;
import com.Project.employeeManagement.Repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImplementation implements EmployeeService{
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImplementation(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee createEmployee(Employee employee){
        if(employeeRepository.findByEmployeeEmailAddress(employee.getEmployeeEmailAddress()).isPresent()){
            throw new EmployeeAlreadyExistsException("Employee with email address: "+employee.getEmployeeEmailAddress()+" already exists.");
        }
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        List<Employee> employees = employeeRepository.findAll();
        if(employees.isEmpty()){
            throw new EmptyDatabaseException("Employee database is empty");
        }
        return employeeRepository.findById(id).orElseThrow(()->new EmployeeNotFoundException("Employee with id: "+id+" not found."));
    }

    @Override
    public Employee updateEmployeeById(Long id, Employee employee) {
        employeeRepository.findById(id).orElseThrow(()->new EmployeeNotFoundException("Employee with id: "+id+" not found."));
        employee.setEmployeeId(id);
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepository.findById(id).orElseThrow(()->new EmployeeNotFoundException("Employee with id: "+id+" not found."));
        employeeRepository.deleteById(id);
    }

}
