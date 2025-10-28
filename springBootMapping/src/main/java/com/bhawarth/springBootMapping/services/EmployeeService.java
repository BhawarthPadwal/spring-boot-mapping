package com.bhawarth.springBootMapping.services;

import com.bhawarth.springBootMapping.annotations.LogExecutionTime;
import com.bhawarth.springBootMapping.entities.EmployeeEntity;
import com.bhawarth.springBootMapping.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeEntity createEmployee(EmployeeEntity employeeEntity) {
        return employeeRepository.save(employeeEntity);
    }

//    @Cacheable(value = "employees", key = "#emp")
    @LogExecutionTime
    @Cacheable(value = "employees")
    public List<EmployeeEntity> getAllEmployee() {
        return employeeRepository.findAll();
    }
    @LogExecutionTime
    public List<EmployeeEntity> findEmployeesByIds(List<Long> ids) {
        return employeeRepository.findAllById(ids);
    }
    @LogExecutionTime
    public Optional<EmployeeEntity> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }
    @LogExecutionTime
    public EmployeeEntity updateEmployee(Long id, EmployeeEntity employeeEntity) {
        EmployeeEntity employeeEntity1 = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        if (employeeEntity1 != null) {
            employeeEntity1.setEmployeeName(employeeEntity.getEmployeeName());
            employeeEntity1.setEmployeeDepartment(employeeEntity.getEmployeeDepartment());
            employeeEntity1.setEmployeeContact(employeeEntity.getEmployeeContact());
            employeeEntity1.setEmployeeAge(employeeEntity.getEmployeeAge());
            employeeEntity1.setEmployeeSalary(employeeEntity.getEmployeeSalary());

            return employeeRepository.save(employeeEntity);
        } else {
            return null;
        }
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

}
