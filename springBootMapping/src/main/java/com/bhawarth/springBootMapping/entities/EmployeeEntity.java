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

    private boolean deleted = false;

    public EmployeeEntity() {
    }

    public EmployeeEntity(Long employeeId, String employeeName, String employeeContact, String employeeDepartment, int employeeAge, Long employeeSalary, boolean deleted) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeContact = employeeContact;
        this.employeeDepartment = employeeDepartment;
        this.employeeAge = employeeAge;
        this.employeeSalary = employeeSalary;
        this.deleted = deleted;
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

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
