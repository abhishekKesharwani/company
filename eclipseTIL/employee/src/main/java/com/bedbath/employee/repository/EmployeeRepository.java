package com.bedbath.employee.repository;

import com.bedbath.employee.model.ReportingEmployees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<ReportingEmployees, Long> {

}
