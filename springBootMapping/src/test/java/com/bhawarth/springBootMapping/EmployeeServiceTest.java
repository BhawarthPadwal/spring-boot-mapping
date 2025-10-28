package com.bhawarth.springBootMapping;

import com.bhawarth.springBootMapping.entities.EmployeeEntity;
import com.bhawarth.springBootMapping.repositories.EmployeeRepository;
import com.bhawarth.springBootMapping.services.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @InjectMocks
    private EmployeeService employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    @Test
    void findEmployeesByIdsTest() {

        List<EmployeeEntity> mockEmployees = Arrays.asList(
                new EmployeeEntity(1L, "abc", "1234567890", "IT", 34,10000L,false),
                new EmployeeEntity(2L, "abc", "1234567890", "IT", 34,10000L,false),
                new EmployeeEntity(3L, "abc", "1234567890", "IT", 34,10000L,false)
        );

        when(employeeRepository.findAllById(Arrays.asList(1L,2L,3L))).thenReturn(mockEmployees);

        // Step 3: Call the service method
        List<EmployeeEntity> employees = employeeService.findEmployeesByIds(Arrays.asList(1L, 2L, 3L));

        // Step 4: Assert results
        assertEquals(3, employees.size());
        assertEquals("abc", employees.get(0).getEmployeeName());
    }
}
