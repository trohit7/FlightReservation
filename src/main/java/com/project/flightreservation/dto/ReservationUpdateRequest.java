package com.project.flightreservation.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReservationUpdateRequest {

    private  Long id;
    private  boolean checkedIn;
    private int numberOfBags;
}
