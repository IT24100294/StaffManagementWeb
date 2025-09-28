package org.example.staffmanagementweb.HR.controller;

import org.example.staffmanagementweb.HR.entity.Employee;
import org.example.staffmanagementweb.HR.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/hr-dashboard")
public class HrDashboardController {

    @Autowired
    private HrService hrService;

    @GetMapping("")
    public String showDashboard(Model model) {
        // Fetch data from service
        long staffCount = hrService.getStaffCount();
        long pendingLeavesCount = hrService.getPendingLeavesCount();
        Object attendanceOverview = hrService.getAttendanceOverview(); // Adjust type if needed
        List<Employee> staffList = hrService.getAllEmployees();

        // Send to Thymeleaf template
        model.addAttribute("staffCount", staffCount);
        model.addAttribute("pendingLeavesCount", pendingLeavesCount);
        model.addAttribute("attendanceOverview", attendanceOverview);
        model.addAttribute("staffList", staffList);

        return "HR/hr-dashboard"; // must match templates/HR/hr-dashboard.html
    }
}
