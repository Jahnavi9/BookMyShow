package com.example.bookmyshow.Services;

import com.example.bookmyshow.Repository.ShowRepository;
import com.example.bookmyshow.Repository.ShowSeatRepository;
import com.example.bookmyshow.controllers.ShowSeatController;
import com.example.bookmyshow.models.Show;
import com.example.bookmyshow.models.ShowSeat;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShowSeatService {

    private ShowSeatRepository repo;
    private ShowRepository showRepo;
    ShowSeatService(ShowSeatRepository repo, ShowRepository showRepo) {
        this.repo = repo;
        this.showRepo = showRepo;
    }
    public List<ShowSeat> showseat(Long showId)
    {
         Optional<Show> show = showRepo.findById(showId);
         if(!show.isPresent())
             throw new IllegalArgumentException("Show not found");

         List<ShowSeat> showSeats = repo.findAllByShow(show);

         return showSeats;


    }
}
