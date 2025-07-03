package com.example.bookmyshow.Repository;

import com.example.bookmyshow.models.Show;
import com.example.bookmyshow.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ShowSeatRepository extends JpaRepository<ShowSeat, Integer> {


    List<ShowSeat> findAllByIdIn(List<Long> seats);
    List<ShowSeat> findAllByShow(Optional<Show> show);


}
