package com.exemple.cabin.booking;

import com.exemple.cabin.facility.Facility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    BookingRepository bookingRepository;

    public List<Booking> getAllBookings() {
        List<Booking> allBookingList =bookingRepository.findAll();
        if (allBookingList.size() > 0) {
            return allBookingList;
        } else {
            return new ArrayList<>();
        }
    }

    public Booking getBookingById(int id) throws NoSuchElementException {
        Optional<Booking> booking = bookingRepository.findById(id);
        if (booking.isPresent()) {
            return booking.get();
        } else {
            throw new NoSuchElementException("No booking record exist or given id");
        }
    }

    public Booking updateBooking(Booking entity) throws NoSuchElementException {
        Optional<Booking> booking = bookingRepository.findById(entity.getId());
        if (booking.isPresent()) {
            Booking newBooking = booking.get();
            newBooking.setCheckIn(entity.getCheckIn());
            newBooking.setCheckOut(entity.getCheckOut());
            return newBooking;
        } else {
            throw new NoSuchElementException("No booking record exist or given id");
        }
    }

    public Booking saveBooking(Booking entity) {
        return bookingRepository.save(entity);
    }

    public void deleteBookingById(int id) {
        Optional<Booking> booking = bookingRepository.findById(id);
        if (booking.isPresent()) {
            bookingRepository.deleteById(id);
        } else {
            throw new NoSuchElementException("No booking record exist or given id");
        }
    }

}
