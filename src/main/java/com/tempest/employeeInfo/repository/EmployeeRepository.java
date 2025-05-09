package com.tempest.employeeInfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tempest.employeeInfo.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>  {

}
