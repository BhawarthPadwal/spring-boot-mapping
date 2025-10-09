package com.bhawarth.springBootMapping.repositories;

import com.bhawarth.springBootMapping.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    // Fetch only non-deleted employees
    @Query("SELECT e FROM EmployeeEntity e WHERE e.deleted = false")
    List<EmployeeEntity> findAllActiveEmployees();

    // Optional: find by id
    @Query("SELECT e FROM EmployeeEntity e WHERE e.employeeId = :id AND e.deleted = false")
    Optional<EmployeeEntity> findActiveById(@Param("id") Long id);
}
