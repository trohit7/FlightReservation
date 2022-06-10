package com.project.flightreservation.repository;

import com.project.flightreservation.entities.Passenger;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger,Long> {
}
