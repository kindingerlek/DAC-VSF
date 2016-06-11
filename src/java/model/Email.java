/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 *
 * @author Bruno
 */
public class Email {

    public static void sendEmail(String receiver, String message) throws EmailException {

        SimpleEmail email = new SimpleEmail();

        try {
            email.setHostName("smtp.googlemail.com");
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator("brunofaczz2@gmail.com", "misterios"));
            email.setSSLOnConnect(true);
            email.setFrom("brunofaczz2@gmail.com");
            email.setSubject("Token de autentificação");
            email.setMsg(message);
            email.addTo("bruno.braga@tuntscorp.com");
            email.send();

        } catch (EmailException e) {
            System.out.println("euaheuahueahuaeh");
            System.out.println(e.getMessage());

        }

    }
}
