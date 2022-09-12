package com.exemple.cabin.owner;

import com.exemple.cabin.cabin.Cabin;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

import java.util.Set;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name="owners")
@Data
public class Owner {
    @Id
    @SequenceGenerator(
            name="owner_sequence",
            sequenceName ="owner_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy= SEQUENCE,
            generator = "owner_sequence"

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
    @JoinColumn(name="owner_id")
    private Set<Cabin> cabins;
}
