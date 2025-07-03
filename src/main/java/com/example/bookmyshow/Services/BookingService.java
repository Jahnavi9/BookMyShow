package com.example.bookmyshow.Services;

import com.example.bookmyshow.Exceptions.SeatsInvalidException;
import com.example.bookmyshow.Repository.BookingRepository;
import com.example.bookmyshow.Repository.ShowSeatRepository;
import com.example.bookmyshow.models.Booking;
import com.example.bookmyshow.models.Seat;
import com.example.bookmyshow.models.ShowSeat;
import jakarta.transaction.Transactional;
import lombok.Builder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

import static com.example.bookmyshow.models.ShowSeatStatus.FREE;
import static com.example.bookmyshow.models.ShowSeatStatus.RESERVED;

@Service
public class BookingService {
    BookingRepository bookingRepo;
    ShowSeatRepository showSeatRepo;
    BookingService(BookingRepository bookingRepo, ShowSeatRepository showSeatRepo) {
        this.bookingRepo = bookingRepo;
        this.showSeatRepo = showSeatRepo;
    }
   // @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking BookTicket(List<Long> seats)
    {
        List<ShowSeat> seatsbooked= showSeatRepo.findAllByIdIn(seats);
        if (seatsbooked.isEmpty() || (seatsbooked.size() != seats.size()))
            throw new SeatsInvalidException();

        int price=0;
        for(ShowSeat seat:seatsbooked)
        {
            if(seat.getShowSeatStatus()!=FREE)
                throw new IllegalArgumentException("Something went wrong,someone else already booked");

            seat.setShowSeatStatus(RESERVED);
            price+= seat.getPrice();

        }
        Booking booking = Booking.builder().show(seatsbooked.get(0).getShow())
                .price(price)
                .showseats(seatsbooked)
                .bookingtime(Date.from(LocalDate.now().atStartOfDay().toInstant(ZoneOffset.UTC)))
                        .build();

        booking=bookingRepo.save(booking);
        showSeatRepo.saveAll(seatsbooked);

        return booking;

    }



    }

