package com.project.flightreservation.controllers;

import com.project.flightreservation.dto.ReservationRequest;
import com.project.flightreservation.entities.Flight;
import com.project.flightreservation.repository.FlightRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;


@Controller
@Slf4j
public class FightController {
    @Autowired
    FlightRepository flightRepository;

    private  static  final Logger LOGGER = LoggerFactory.getLogger(FightController.class);

    @RequestMapping("findFlights")
    public String findFlights(@RequestParam("from") String from, @RequestParam("to") String to, @RequestParam("departureDate")@DateTimeFormat(pattern = "yyyy-MM-dd")Date departureDate, ModelMap modelMap){

        LOGGER.info("Inside findFlights() From:"+from + "To:"+to + "Departure Date:" + departureDate);
        log.info("retrieving flights data from database- From city: {}, toCity: {}, On date: {}",from,to,departureDate.toString());
        List<Flight> flights = flightRepository.findFlights(from,to,departureDate);

        modelMap.addAttribute("flights", flights );

        LOGGER.info("Flights which are available"+flights);
        return "displayFlights";

    }

    @RequestMapping("admin/showAddFlight")
    public String showAddFlight(){
        return "addFlight";
    }

}

