package com.tempest.employeeInfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Main class for the Employee Info Application.
 */
@SpringBootApplication
@EnableScheduling
@EnableJpaRepositories(basePackages = "com.tempest.employeeInfo.repository")
public class EmployeeInfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeInfoApplication.class, args);
    }
}
