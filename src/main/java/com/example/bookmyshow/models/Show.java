package com.example.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity(name="Movie_show")
public class Show extends BaseModel {
    @ManyToOne
    @JoinColumn(name="movie_id")
    private Movie movie;

    @ManyToOne
    private Hall hall;
    @Temporal(TemporalType.TIME)
    private Date start_time;
    private int duration;

}
