package com.exemple.cabin.booking;

import com.exemple.cabin.cabin.Cabin;
import com.exemple.cabin.customer.Customer;
import com.exemple.cabin.owner.Owner;
import lombok.Data;

import javax.persistence.*;

import java.util.Date;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Data
@Table(name="bookings")
public class Booking {
    @Id
    @SequenceGenerator(
            name="booking_sequence",
            sequenceName ="booking_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy= SEQUENCE,
            generator = "booking_sequence"

    )
    @Column(name="id")
    private int id;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="cabin_id", referencedColumnName = "id")
    private Cabin cabin;

    @Column (name="ckeckin")
    private Date checkIn;

    @Column (name="checkout")
    private Date checkOut;

}
