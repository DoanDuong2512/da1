package com.duong.restful_api.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;

@Data
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;

    private String firstName;

    private String lastName;

    private String position;

    private String phone;

    private String email;

    private java.util.Date hireDate;

    private java.math.BigDecimal salary;


    @OneToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("employees")
    private User user;

    @OneToMany
    @JoinColumn(name="log_id")
    private Collection<PetCareLog> log;

}
