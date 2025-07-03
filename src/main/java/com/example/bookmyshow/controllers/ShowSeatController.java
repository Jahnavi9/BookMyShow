package com.example.bookmyshow.controllers;

import com.example.bookmyshow.DTO.seatmap;
import com.example.bookmyshow.Services.ShowSeatService;
import com.example.bookmyshow.models.ShowSeat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/seats")
public class ShowSeatController{


   private ShowSeatService showSeatService;
   ShowSeatController(ShowSeatService showSeatService) {
       this.showSeatService = showSeatService;

   }
    @GetMapping("/showid")
    public seatmap getseatmap(@PathVariable(name="showid") Long showid)
    {
        return new seatmap(showSeatService.showseat(showid));



    }


}
