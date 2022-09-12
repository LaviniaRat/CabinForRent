package com.exemple.cabin.facility;

import lombok.Data;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name="facilities")
@Data
public class Facility {
    @Id
    @SequenceGenerator(
            name="facility_sequence",
            sequenceName ="facility_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy= SEQUENCE,
            generator = "facility_sequence"

    )
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;
}
