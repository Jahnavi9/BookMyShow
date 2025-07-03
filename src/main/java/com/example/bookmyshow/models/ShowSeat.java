package com.example.bookmyshow.models;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeat extends BaseModel {

@ManyToOne
private Seat seat;
private int price;
@ManyToOne
private Show show;
private ShowSeatStatus showSeatStatus;



}
