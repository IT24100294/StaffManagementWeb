package org.example.staffmanagementweb.HR.controller;

import org.example.staffmanagementweb.HR.service.HrService;
import org.example.staffmanagementweb.HR.entity.Department;
import org.example.staffmanagementweb.HR.entity.Employee;
import org.example.staffmanagementweb.HR.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hr/staff")
public class StaffController {

    @Autowired
    private HrService hrService;

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("departments", hrService.getAllDepartments());
        model.addAttribute("users", hrService.getAllUsers());
        return "HR/add-staff";
    }

    @PostMapping("/add")
    public String addStaff(@ModelAttribute Employee employee,
                           @RequestParam(required = false) Integer departmentId,
                           @RequestParam(required = false) Integer userId,
                           Model model) {
        try {
            // Assign Department if chosen
            if (departmentId != null) {
                Department dept = hrService.getDepartmentById(departmentId);
                employee.setDepartment(dept);
            }

            // Assign User if chosen
            if (userId != null) {
                User user = hrService.getUserById(userId);
                employee.setUser(user);
            }

            hrService.saveEmployee(employee);
            model.addAttribute("message", "Staff added successfully!");
        } catch (Exception e) {
            model.addAttribute("error", "Error adding staff: " + e.getMessage());
            return "HR/add-staff";
        }
        return "redirect:/hr-dashboard";
    }

}