package com.tempest.employeeInfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tempest.employeeInfo.model.Employee;
import com.tempest.employeeInfo.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeApiService {

    @Autowired
    private EmployeeService employeeService;
    
    @GetMapping("/{employeeId}")
    public Employee getEmployeeDetails(@PathVariable int employeeId) {
        return employeeService.getEmployeeById(employeeId).orElse(null);
    }

    @GetMapping
    public List<Employee> getAllEmployeeDetails() {
        return employeeService.getAllEmployees();
    }
    
    @PostMapping
    public String createEmployeeDetails(@RequestBody Employee employee) {
        employeeService.createEmployee(employee);
        return "Employee created";
    }
    
    @PutMapping
    public String updateEmployeeDetails(@RequestBody Employee employee) {
        try {
            employeeService.updateEmployee(employee);
            return "Employee updated";
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }
    
    @DeleteMapping("/{employeeId}")
    public String deleteEmployeeDetails(@PathVariable int employeeId) {
        try {
            employeeService.deleteEmployeeById(employeeId);
            return "Employee deleted";
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }
}
