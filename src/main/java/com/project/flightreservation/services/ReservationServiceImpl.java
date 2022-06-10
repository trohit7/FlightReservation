package com.project.flightreservation.services;

import com.project.flightreservation.controllers.FightController;
import com.project.flightreservation.dto.ReservationRequest;
import com.project.flightreservation.entities.Flight;
import com.project.flightreservation.entities.Passenger;
import com.project.flightreservation.entities.Reservation;
import com.project.flightreservation.repository.FlightRepository;
import com.project.flightreservation.repository.PassengerRepository;
import com.project.flightreservation.repository.ReservationRepository;
import com.project.flightreservation.util.EmailUtil;
import com.project.flightreservation.util.PDFGenerator;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Slf4j
@Service
public class ReservationServiceImpl implements ReservationService{



    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    ReservationRepository reservationRepository;


    @Autowired
    PDFGenerator pdfGenerator;

    @Autowired
    EmailUtil emailUtil;

    private static final Logger LOGGER =  LoggerFactory.getLogger(ReservationServiceImpl.class);

    @Override
    @Transactional
    public Reservation bookFlight(ReservationRequest request) {
        Long flightId = request.getFlightId();
        LOGGER.info("Fetching flight for flight id:"+ flightId);
        Flight flight = flightRepository.findById(flightId).orElseThrow();
        log.info("fetched  flights in ResvationServiceImpl {}",flight.toString());


        Passenger passenger = new Passenger();
        passenger.setFirstName(request.getPassengerFirstName());
        passenger.setLastName(request.getPassengerLastName());
        passenger.setPhone(request.getPassengerPhone());
        passenger.setEmail(request.getPassengerEmail());

        LOGGER.info("Saving the passenger:"+ passenger);
        Passenger savedPassenger = passengerRepository.save(passenger);
        log.info("Saved Passenger deatails {}",savedPassenger.toString());

        Reservation reservation = new Reservation();
        reservation.setFlight(flight);
        reservation.setPassenger(savedPassenger);
        reservation.setCheckedIn(false);

        LOGGER.info("Saving the reservation:"+ reservation);

        Reservation savedReservation = reservationRepository.save(reservation);

        log.info("reservation details "+ savedReservation);

        String filePath = "/home/rohit/Documents/reservation/reservation" + savedReservation.getId() + ".pdf";


        LOGGER.info("Generating the pdf and it will be saved in the filePath");
        pdfGenerator.generateItinerary(savedReservation,filePath);
       LOGGER.info("Emailing the itinerary");
        emailUtil.sendItinerary(passenger.getEmail(),filePath);

        LOGGER.info("email has sent to the user entered mailId"+passenger.getEmail());

        return savedReservation;
    }
}
