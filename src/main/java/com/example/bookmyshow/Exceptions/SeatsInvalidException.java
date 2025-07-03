package com.example.bookmyshow.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class SeatsInvalidException extends RuntimeException {
    public SeatsInvalidException() {
        super("Someone else booked the seats");
    }
}
