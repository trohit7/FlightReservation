package com.project.flightreservation.entities;

import lombok.Getter;
import lombok.Setter;

import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.sql.Timestamp;
import java.util.Date;
@Entity
@Getter
@Setter
@ToString

public class Flight extends AbstractEntity{

    private String flightNumber;
    private String operatingAirlines;
    private String departureCity;
    private String arrivalCity;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dateOfDeparture;
    private Timestamp estimatedDepartureTime;
}
