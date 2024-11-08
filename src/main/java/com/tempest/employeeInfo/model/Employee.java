package com.tempest.employeeInfo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "employee_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;

    @NotBlank(message = "Employee name is mandatory")
    @Size(max = 100, message = "Employee name should not exceed 100 characters")
    private String employeeName;

    @NotBlank(message = "Employee address is mandatory")
    @Size(max = 255, message = "Employee address should not exceed 255 characters")
    private String employeeAddress;

    @NotNull(message = "Employee phone number is mandatory")
    private Long employeePhNumber;
}
