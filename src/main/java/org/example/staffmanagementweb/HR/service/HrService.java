package org.example.staffmanagementweb.HR.service;

import org.example.staffmanagementweb.HR.entity.Department;
import org.example.staffmanagementweb.HR.entity.Employee;
import org.example.staffmanagementweb.HR.entity.User;
import org.example.staffmanagementweb.HR.repository.DepartmentRepository;
import org.example.staffmanagementweb.HR.repository.EmployeeRepository;
import org.example.staffmanagementweb.HR.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HrService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private UserRepository userRepository;

    // Existing methods
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    // Method to fetch all departments
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    // Method to fetch all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // New method to get total staff count
    public long getStaffCount() {
        return employeeRepository.count();
    }

    public long getPendingLeavesCount() {
        return employeeRepository.count();
    }
    public long getAttendanceOverview() {
        return employeeRepository.count();
    }

    public Department getDepartmentById(Integer id) {
        return departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Department not found"));
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }


    // Optional: Add getPendingLeavesCount() if needed (requires LeaveRequests entity/repository)
    // public long getPendingLeavesCount() {
    //     return leaveRequestsRepository.countByStatus("Pending");
    // }
}