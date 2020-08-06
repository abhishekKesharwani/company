package com.bedbath.employee.controllers;

import com.bedbath.employee.model.Manager;
import com.bedbath.employee.repository.EmployeeRepository;
import com.bedbath.employee.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ManagerController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ManagerRepository managerRepository;

    @RequestMapping(value = "/addManager", method = RequestMethod.POST)
    public Manager addManager(@RequestBody Manager manager) {
        System.out.println("Manager Data i/p " + manager.toString());
        return managerRepository.save(manager);
    }

    @RequestMapping(value = "/getAllManager", produces = "application/json")
    public List<Manager> getAllManager(Manager manager) {
        System.out.println("Manager Data o/p " + managerRepository.findAll().toString());
        return managerRepository.findAll();
    }

    @RequestMapping(value = "/getManager/{id}", produces = "application/json")
    public Optional<Manager> getManager(@PathVariable Integer id) {
        return managerRepository.findById(id);
    }
}
