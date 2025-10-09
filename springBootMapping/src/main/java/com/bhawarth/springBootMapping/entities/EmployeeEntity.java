package com.bhawarth.springBootMapping.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "employeeTb")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    private String employeeName;

    private String employeeContact;

    private String employeeDepartment;

    private int employeeAge;

    private Long employeeSalary;

    public EmployeeEntity() {
    }

    public EmployeeEntity(Long employeeId, String employeeName, String employeeContact, String employeeDepartment, int employeeAge, Long employeeSalary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeContact = employeeContact;
        this.employeeDepartment = employeeDepartment;
        this.employeeAge = employeeAge;
        this.employeeSalary = employeeSalary;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeContact() {
        return employeeContact;
    }

    public void setEmployeeContact(String employeeContact) {
        this.employeeContact = employeeContact;
    }

    public String getEmployeeDepartment() {
        return employeeDepartment;
    }

    public void setEmployeeDepartment(String employeeDepartment) {
        this.employeeDepartment = employeeDepartment;
    }

    public int getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(int employeeAge) {
        this.employeeAge = employeeAge;
    }

    public Long getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(Long employeeSalary) {
        this.employeeSalary = employeeSalary;
    }
}
