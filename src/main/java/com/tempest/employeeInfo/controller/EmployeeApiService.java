package com.tempest.employeeInfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tempest.employeeInfo.model.Employee;
import com.tempest.employeeInfo.service.EmployeeService;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/employee")
public class EmployeeApiService {

    private static final Logger logger = Logger.getLogger(EmployeeApiService.class.getName());

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getEmployeeDetails(@PathVariable int employeeId) {
        Optional<Employee> employee = employeeService.getEmployeeById(employeeId);
        if (employee.isPresent()) {
            return new ResponseEntity<>(employee.get(), HttpStatus.OK);
        } else {
            logger.warning("Employee with ID " + employeeId + " not found.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployeeDetails() {
        List<Employee> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createEmployeeDetails(@RequestBody Employee employee) {
        if (employee == null) {
            logger.warning("Invalid employee data.");
            return new ResponseEntity<>("Invalid employee data", HttpStatus.BAD_REQUEST);
        }
        employeeService.createEmployee(employee);
        return new ResponseEntity<>("Employee created", HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<String> updateEmployeeDetails(@RequestBody Employee employee) {
        if (employee == null) {
            logger.warning("Invalid employee data.");
            return new ResponseEntity<>("Invalid employee data", HttpStatus.BAD_REQUEST);
        }
        try {
            employeeService.updateEmployee(employee);
            return new ResponseEntity<>("Employee updated", HttpStatus.OK);
        } catch (RuntimeException e) {
            logger.severe("Error updating employee: " + e.getMessage());
            return new ResponseEntity<>("Error updating employee", HttpStatus.INTERNAL_SERVER_ERROR);
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
