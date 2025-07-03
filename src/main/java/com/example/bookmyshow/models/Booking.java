package com.example.bookmyshow.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Booking extends BaseModel{
    @OneToMany
    private List<ShowSeat> showseats;
    private int price;
    @ManyToOne
    private Show show;
    @Temporal(TemporalType.TIME)
    private Date bookingtime;


}
