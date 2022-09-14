package com.exemple.cabin.booking;

import com.exemple.cabin.facility.Facility;
import com.exemple.cabin.facility.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Controller
public class BookingController {
    @Autowired
    BookingService bookingService;

    @GetMapping("/bookings")
    public List<Booking> getAllBookings(){
        return bookingService.getAllBookings();
    }

    @GetMapping("/booking")
    public Booking getBooking(int id){
        return bookingService.getBookingById(id);
    }

    @PostMapping("/booking")
    public Booking saveBooking(Booking entity){
        return bookingService.saveBooking(entity);
    }

    @DeleteMapping("/booking")
    public void deleteBooking(int id){
        bookingService.deleteBookingById(id);
    }

    @PutMapping("/booking")
    public Booking updateBooking(Booking entity){
        return bookingService.updateBooking(entity);
    }
}
