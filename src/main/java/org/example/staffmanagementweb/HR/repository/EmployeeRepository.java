package org.example.staffmanagementweb.HR.repository;

import org.example.staffmanagementweb.HR.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}