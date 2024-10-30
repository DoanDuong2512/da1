package com.duong.restful_api.repository;

import com.duong.restful_api.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query("SELECT c FROM Customer c WHERE UPPER(c.phone) LIKE UPPER(CONCAT('%', :keyword, '%')) OR UPPER(c.phone) LIKE UPPER(CONCAT('%', :keyword, '%'))")
    List<Customer> findByFirstNameContainingOrLastNameContaining(@Param(value = "keyword") String keyword);
}
