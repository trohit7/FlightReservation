package com.project.flightreservation.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@ToString
public class Passenger extends AbstractEntity{

    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String phone;
}
