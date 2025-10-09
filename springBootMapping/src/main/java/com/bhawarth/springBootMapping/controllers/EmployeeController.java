package com.bhawarth.springBootMapping.controllers;

import com.bhawarth.springBootMapping.entities.EmployeeEntity;
import com.bhawarth.springBootMapping.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Get all employees
    @GetMapping
    public ResponseEntity<List<EmployeeEntity>> getAllEmployees() {
        List<EmployeeEntity> employees = employeeService.getAllEmployee();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeEntity> getEmpById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id)
                .stream().map(employee -> new ResponseEntity<>(employee, HttpStatus.OK))
                .findAny().orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<EmployeeEntity> createEmployee(@RequestBody EmployeeEntity employeeEntity) {
        EmployeeEntity createdEmployee = employeeService.createEmployee(employeeEntity);
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeEntity> updateEmployee(@PathVariable Long id, @RequestBody EmployeeEntity employeeEntity) {
        if (!employeeService.getEmployeeById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        employeeEntity.setEmployeeId(id);
        EmployeeEntity updatedEntity = employeeService.updateEmployee(id, employeeEntity);
        return new ResponseEntity<>(updatedEntity, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        if (!employeeService.getEmployeeById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/multiple")
    public ResponseEntity<List<EmployeeEntity>> getEmployeesByIds(@RequestParam List<Long> ids) {
        List<EmployeeEntity> employees = employeeService.findEmployeesByIds(ids);
        if (employees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/multiple/{ids}")
    public ResponseEntity<List<EmployeeEntity>> getEmployeesByIdsPath(@PathVariable String ids) {
        List<Long> idList = Arrays.stream(ids.split(",")).map(Long::parseLong).toList();
        List<EmployeeEntity> employees = employeeService.findEmployeesByIds(idList);
        if (employees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

}
