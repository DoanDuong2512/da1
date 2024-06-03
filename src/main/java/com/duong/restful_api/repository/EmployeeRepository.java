package com.duong.restful_api.repository;

import com.duong.restful_api.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("SELECT e FROM Employee e WHERE UPPER(e.firstName) LIKE UPPER(CONCAT('%', :keyword, '%')) OR UPPER(e.lastName) LIKE UPPER(CONCAT('%', :keyword, '%'))")
    List<Employee> findByFirstNameContainingOrLastNameContaining(@Param(value = "keyword") String keyword);
}