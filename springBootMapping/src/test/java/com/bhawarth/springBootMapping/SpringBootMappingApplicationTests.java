package com.bhawarth.springBootMapping;

import com.bhawarth.springBootMapping.services.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootMappingApplicationTests {

    @Autowired
    private EmployeeService service;

//    @Test
//    void contextLoads() {
//        this.service.getAllEmployee();
//    }

    @Test
	void contextLoads() {
        this.service.getEmployeeById(10L);
	}

}
