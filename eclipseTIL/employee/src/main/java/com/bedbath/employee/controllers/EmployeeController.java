package com.bedbath.employee.controllers;

import com.bedbath.employee.model.ReportingEmployees;
import com.bedbath.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public String newEmployee(@RequestBody ReportingEmployees reportingEmployees) {
        employeeRepository.save(reportingEmployees);
        System.out.println("employees Data i/p " + reportingEmployees.toString());
        return ("userSaved");
    }

    @RequestMapping(value = "/getAllEmployee")
    public String getEmployee(ReportingEmployees reportingEmployees) {
        return employeeRepository.findAll().toString();
    }

    @RequestMapping(value = "/getEmployee/{id}", produces = "application/json")
    public Optional<ReportingEmployees> getEmployee(@PathVariable Long id) {
        return employeeRepository.findById(id);
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome() {
        System.out.println("in welcome mapping");
        return "Hello , Welcome to Employee Application";
    }


}
