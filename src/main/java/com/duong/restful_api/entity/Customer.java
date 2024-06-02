package com.duong.restful_api.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Collection;
import java.util.Date;

@Data
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;

    private String firstName;

    private String lastName;

    private String phone;

    private String email;

    private String address;

    private Date registrationDate;


    @OneToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("customers")
    private User user;

    @OneToMany(mappedBy = "customer")
    private Collection<Booking> bookings;

//    @OneToMany
//    @JoinColumn(name="pet_id")
//    private Collection<Pet> pets;

    @OneToMany(targetEntity = Pet.class) // specify the target entity
    @JoinColumn(name = "customer_id")
    @JsonIgnoreProperties("customer")
    private Collection<Pet> pets; // change to Collection<Pet> or any suitable collection type
}
