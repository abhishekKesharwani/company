package com.bedbath.employee.model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@Entity
@DynamicUpdate
public class Manager {
    @Id
//    @GeneratedValue
    private Integer managerId;
    private String managerFirstName;
    private String managerLastName;
    private String email;
    private String salary;
    private String joiningDateTime;
    private String dept;
    private String address;

    @OneToMany(targetEntity = ReportingEmployees.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "ManagerId_fk", referencedColumnName = "managerId")
    private List<ReportingEmployees> ReportingEmployees;

    @Override
    public String toString() {
        return "Manager{" +
                "ManagerId=" + managerId +
                ", ManagerFirstName='" + managerFirstName + '\'' +
                ", ManagerLastName='" + managerLastName + '\'' +
                ", email='" + email + '\'' +
                ", Salary='" + salary + '\'' +
                ", JoiningDateTime='" + joiningDateTime + '\'' +
                ", Dept='" + dept + '\'' +
                ", Address='" + address + '\'' +
                ", ReportingEmployees='" + ReportingEmployees + '\'' +
                '}';
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public String getManagerFirstName() {
        return managerFirstName;
    }

    public void setManagerFirstName(String managerFirstName) {
        this.managerFirstName = managerFirstName;
    }

    public String getManagerLastName() {
        return managerLastName;
    }

    public void setManagerLastName(String managerLastName) {
        this.managerLastName = managerLastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getJoiningDateTime() {
        return joiningDateTime;
    }

    public void setJoiningDateTime(String joiningDateTime) {
        this.joiningDateTime = joiningDateTime;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<ReportingEmployees> getReportingEmployees() {
        return ReportingEmployees;
    }

    public void setReportingEmployees(List<ReportingEmployees> reportingEmployees) {
        this.ReportingEmployees = reportingEmployees;
    }
}
