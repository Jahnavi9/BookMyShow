package com.example.bookmyshow.controllers;

import com.example.bookmyshow.DTO.CreateBooking;
import com.example.bookmyshow.Services.BookingService;
import com.example.bookmyshow.models.Booking;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")
public class BookingController {
    private final BookingService bookingService;
   BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/create")
    public Booking createBooking(@RequestBody CreateBooking booking) {

       return bookingService.BookTicket(booking.getSeatList());

    }

}
