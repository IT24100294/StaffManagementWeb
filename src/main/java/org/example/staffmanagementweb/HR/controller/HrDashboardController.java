package org.example.staffmanagementweb.HR.controller;

import org.example.staffmanagementweb.HR.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hr")
public class HrDashboardController {
    @Autowired
    private HrService hrService;

    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        model.addAttribute("staffCount", hrService.getStaffCount());
        model.addAttribute("pendingLeavesCount", hrService.getPendingLeavesCount());
        return "hr/hr-dashboard";
    }

}
