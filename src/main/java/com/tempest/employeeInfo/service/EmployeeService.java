package com.tempest.employeeInfo.service;

import java.util.List;
import java.util.Optional;

import com.tempest.employeeInfo.model.Employee;

public interface EmployeeService {
    Employee createEmployee(Employee employee);
    Optional<Employee> getEmployeeById(int employeeId);
    List<Employee> getAllEmployees();
    Employee updateEmployee(Employee employee);
    void deleteEmployeeById(int employeeId);
}