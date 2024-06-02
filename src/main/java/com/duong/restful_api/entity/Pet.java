package com.duong.restful_api.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;
import java.util.List;

@Data
@Entity
@Table(name = "pets")
public class Pet {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;

    private String name;

    private String species;

    private String breed;

    private int age;

    private String healthInfo;

//    @OneToOne(mappedBy = "pet", cascade = CascadeType.ALL)
//    private PetProfile petProfile;

    @OneToMany(mappedBy = "pet")
    private List<PetCareLog> logs;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "pet")
    private Collection<Booking> bookings;
}
