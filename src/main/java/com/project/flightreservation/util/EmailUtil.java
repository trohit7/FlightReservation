package com.project.flightreservation.util;

import com.project.flightreservation.services.ReservationServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Component
public class EmailUtil {



    private static final Logger LOGGER =  LoggerFactory.getLogger(EmailUtil.class);

    @Autowired
    private JavaMailSender sender;

    public void sendItinerary(String toAddress, String filepath)
    {
        MimeMessage message = sender.createMimeMessage();
        try {
            MimeMessageHelper messageHelper = new MimeMessageHelper(message,true);
            messageHelper.setTo(toAddress);
            messageHelper.setSubject("Itinerary for your flight");
            messageHelper.setText("please find your Itinerary attached");
            messageHelper.addAttachment("Itenerary", new File(filepath));
            sender.send(message);
        } catch (MessagingException e) {
            LOGGER.error("Exception inside the sendItinerary" + e);
            throw new RuntimeException(e);
        }
    }

}
