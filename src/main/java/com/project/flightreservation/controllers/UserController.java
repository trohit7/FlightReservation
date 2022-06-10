package com.project.flightreservation.controllers;

import com.project.flightreservation.entities.User;
import com.project.flightreservation.repository.UserRepository;
import com.project.flightreservation.services.SecurityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private  SecurityService securityService;

    @Autowired
    private BCryptPasswordEncoder encoder;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);


    @RequestMapping("/showReg")
    public String ShowRegistrationPage(){
        LOGGER.info("Inside showRegistrationPage(): where user can create new account to book flight tickets");
        return "login/registerUser";
    }

    @RequestMapping(value = "registerUser", method = RequestMethod.POST)
    public String register(@ModelAttribute("user") User user){
        LOGGER.info("Inside register(): saving user details"+ user);
        user.setPassword(encoder.encode(user.getPassword()));
        LOGGER.info("Inside register(): password encoded ");
        userRepository.save(user);
        LOGGER.info("Inside register():  user details saved in encoded format "+ user);

        return "login/login";
    }

    @RequestMapping("/showLogin")
    public String ShowLoginPage(){
        LOGGER.info("Inside showLoginPage(): enter your login details");
        return "login/login";
    }



    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(@RequestParam("email") String email, @RequestParam("password") String password, ModelMap modelMap){
        LOGGER.info("Inside login(): checking your entered password of the email"+ email);
        boolean loginRespose  = securityService.login(email,password);
        if (loginRespose){

            return "findFlights";
        }  else{
            modelMap.addAttribute("msg", "Invalid user name or password . please try again");
        }
        return "login/login";

    }


}
