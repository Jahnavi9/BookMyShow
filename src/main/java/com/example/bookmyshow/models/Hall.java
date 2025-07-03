package com.example.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Hall extends BaseModel{
    @ManyToOne
    @JoinColumn(name="venue_id")
    private Venue venue;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "hall")
    private List<Seat> seats;
    String screenType;




}
