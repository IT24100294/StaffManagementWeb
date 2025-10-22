package org.example.staffmanagementweb.HR.repository;

import org.example.staffmanagementweb.HR.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff, Long> {
}