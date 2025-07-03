package com.example.bookmyshow.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="Seat")
public class Seat extends BaseModel{
    @Column(name="Seat_row")
    private int row;
    @Column(name="Seat_col")
    private int col;
    @Enumerated
    private SeatType seatType;
    @ManyToOne
    @JoinColumn(name="hall_id")
    private Hall hall;



}
