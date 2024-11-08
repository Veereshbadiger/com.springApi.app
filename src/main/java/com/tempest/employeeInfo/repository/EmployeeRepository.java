package com.tempest.employeeInfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tempest.employeeInfo.model.Employee;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Optional<Employee> findByEmployeeName(String employeeName);

    List<Employee> findByEmployeeAddressContaining(String addressPart);

    List<Employee> findByEmployeePhNumber(Long employeePhNumber);
}
