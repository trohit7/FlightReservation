package com.project.flightreservation.controllers;

import com.project.flightreservation.dto.ReservationRequest;
import com.project.flightreservation.entities.Flight;
import com.project.flightreservation.entities.Reservation;
import com.project.flightreservation.repository.FlightRepository;
import com.project.flightreservation.services.ReservationService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;
@Slf4j
@Controller
public class ReservationController {
    @Autowired
    FlightRepository flightRepository;
    @Autowired
    ReservationService reservationService;

    private  static  final Logger LOGGER = LoggerFactory.getLogger(ReservationController.class);


    @RequestMapping("/showCompleteReservation")
    public  String showCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap modelMap){

        LOGGER.info("showCompleteReservation() invoked with the Flight id:"+ flightId);
        log.info("retrieving selected filght id:"+ flightId);
        Optional<Flight> flight = flightRepository.findById(flightId);

        LOGGER.info("Flights is :"+ flight);
        log.info(" retireving flight details from filght id:"+ flight);
        modelMap.addAttribute("flight",flight.get());
        return "completeReservation";
    }

    @RequestMapping(value = "/completeReservation", method = RequestMethod.POST)
    public String completeReservation(ReservationRequest request,ModelMap modelMap){
        LOGGER.info("completeReservation(): confirming your request" + request);
        log.info("Reservation Request: {}",request.toString());
        Reservation reservation = reservationService.bookFlight(request);
        modelMap.addAttribute("msg","Reservation created successful and the id is" + reservation.getId());
        return "reservationConfirmation";
    }
}
