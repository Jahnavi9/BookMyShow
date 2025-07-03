package com.example.bookmyshow.DTO;

import com.example.bookmyshow.models.Seat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateBooking {
    int bookingID;
    List<Long> seatList;


}
