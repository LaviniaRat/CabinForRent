package com.exemple.cabin.cabin;

import com.exemple.cabin.owner.Owner;
import lombok.Data;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Cabin")
@Table(name = "cabins")
@Data
public class Cabin {
    @Id
    @SequenceGenerator(
            name="cabin_sequence",
            sequenceName ="cabin_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy= SEQUENCE,
            generator = "cabin_sequence"

    )
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="price")
    private int price;

    @Column(name="location")
    private String location;

    @ManyToOne
    @JoinColumn(name="owner_id")
    private Owner owner;
}
