package com.tempest.employeeInfo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee_info") 
public class Employee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;
    
    private String employeeName;
    
    private String employeeAddress;
    
    private long employeePhNumber;

    // Default constructor
    public Employee() {
    }

    // Parameterized constructor
    public Employee(String employeeName, String employeeAddress, long employeePhNumber) {
        this.employeeName = employeeName;
        this.employeeAddress = employeeAddress;
        this.employeePhNumber = employeePhNumber;
    }

    // Getter and Setter methods
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public long getEmployeePhNumber() {
        return employeePhNumber;
    }

    public void setEmployeePhNumber(long employeePhNumber) {
        this.employeePhNumber = employeePhNumber;
    }
}
