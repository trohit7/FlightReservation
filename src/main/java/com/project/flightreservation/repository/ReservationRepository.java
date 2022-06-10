package com.project.flightreservation.repository;

import com.project.flightreservation.entities.Reservation;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
}
