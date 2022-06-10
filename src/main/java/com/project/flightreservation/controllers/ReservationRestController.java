package com.project.flightreservation.controllers;

import com.project.flightreservation.dto.ReservationUpdateRequest;
import com.project.flightreservation.entities.Reservation;
import com.project.flightreservation.repository.ReservationRepository;
import com.project.flightreservation.services.ReservationServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@Slf4j
@RestController
@CrossOrigin
public class ReservationRestController {


    private static final Logger LOGGER =  LoggerFactory.getLogger(ReservationRestController.class);
    @Autowired
    ReservationRepository reservationRepository;

    @RequestMapping("/reservations/{id}")
    public Reservation findReservation(@PathVariable("id") Long id){
        log.info("get the reservation id" + id);
        Optional<Reservation> reservation = reservationRepository.findById(id);

        log.info("get reservation details by id  "+ reservation);
        return reservation.get();

    }

    @RequestMapping("/reservations")
    public Reservation updateReservation(@RequestBody ReservationUpdateRequest request){
        LOGGER.info("Inside updateReservation() for "+ request);
        Optional<Reservation> reservation = reservationRepository.findById((request.getId()));
        reservation.get().setNumberOfBags(request.getNumberOfBags());
        reservation.get().setCheckedIn(request.isCheckedIn());
        LOGGER.info("saving the updated reservation checkin status");
        return reservationRepository.save(reservation.get());
    }

}
