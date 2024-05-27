package com.tempest.employeeInfo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tempest.employeeInfo.model.Employee;
import com.tempest.employeeInfo.repository.EmployeeRepository;
import com.tempest.employeeInfo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> getEmployeeById(int employeeId) {
        return employeeRepository.findById(employeeId);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        if (employeeRepository.existsById(employee.getEmployeeId())) {
            return employeeRepository.save(employee);
        } else {
            throw new RuntimeException("Employee not found with id: " + employee.getEmployeeId());
        }
    }

    @Override
    public void deleteEmployeeById(int employeeId) {
        if (employeeRepository.existsById(employeeId)) {
            employeeRepository.deleteById(employeeId);
        } else {
            throw new RuntimeException("Employee not found with id: " + employeeId);
        }
    }
}
