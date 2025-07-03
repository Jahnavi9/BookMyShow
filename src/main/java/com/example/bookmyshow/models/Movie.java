package com.example.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;

@Data
@Entity
@Table(name="Movie")
public class Movie extends BaseModel{
    private String name;
    private int duration;




}
