package com.example.bookmyshow.DTO;

import com.example.bookmyshow.models.ShowSeat;
import org.springframework.data.util.Pair;

import java.util.List;

public class seatmap {

    List<Pair<Integer,Integer>> seats;
    public seatmap(List<ShowSeat> showSeats) {
        for(ShowSeat showSeat : showSeats) {
            seats.add(Pair.of(showSeat.getSeat().getRow(),showSeat.getSeat().getRow()));
        }
    }


}
