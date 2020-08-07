package com.bedbath.employee.controllers;

import com.bedbath.employee.model.Manager;
import com.bedbath.employee.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ManagerController {

    @Autowired
    ManagerRepository managerRepository;

    @RequestMapping(value = "/addManager", method = RequestMethod.POST)
    public Manager addManager(@RequestBody Manager manager) {
        System.out.println("Manager Data i/p " + manager.toString());
        return managerRepository.save(manager);
    }

    @PutMapping("/updateManagerEmalId/{id}")
    Manager updateManagerEmalId(@RequestBody Manager newManager, @PathVariable Integer id) {
        if (managerRepository.findById(id).isPresent()){
            Manager existingManager = managerRepository.findById(id).get();
            existingManager.setEmail(newManager.getEmail());
            return managerRepository.save(existingManager);
        }
        else{
            return null;
        }
    }

    @RequestMapping(value = "/deleteManager/{id}", method = RequestMethod.GET)
    void deleteManager(@PathVariable Integer id) {
        System.out.println("Manager Data i/p which needs to be deleted " + id);
        managerRepository.deleteById(id);
    }

    @RequestMapping(value = "/getAllManager", produces = "application/json")
    List<Manager> getAllManager(Manager manager) {
        System.out.println("Manager Data o/p " + managerRepository.findAll().toString());
        return managerRepository.findAll();
    }

    @RequestMapping(value = "/getManager/{id}", produces = "application/json")
    Optional<Manager> getManager(@PathVariable Integer id) {
        return managerRepository.findById(id);
    }
}
