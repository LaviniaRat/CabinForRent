package com.exemple.cabin.customer;

import com.exemple.cabin.booking.Booking;
import com.exemple.cabin.cabin.Cabin;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

import java.util.Set;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name="customers")
@Data
public class Customer {
    @Id
    @SequenceGenerator(
            name="customer_sequence",
            sequenceName ="customer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy= SEQUENCE,
            generator = "customer_sequence"

    )
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;
    @Column(name="email")
    private String email;
    @Column(name="phone")
    private int phone;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name="customer_id")
    private Set<Booking> bookings;

}
