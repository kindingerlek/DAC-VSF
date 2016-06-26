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

    public static void sendConfirmation(String receiver, String token, PersonalAccount account) throws EmailException {

        SimpleEmail email = new SimpleEmail();
        String message = "Sua conta foi criada com sucesso, porém ainda está inativa.\n";
        message += "Número da conta: " + account.getNumber() + "\n";
        message += "Agência: " + account.getAgency().getNumber() + "\n";
        message += "Token de autentificação: " + token + "\n";
        message += "Com este token você é capaz de definir uma senha para sua conta para, então, utilizá-la.\n";
        message += "\nCaso você perca este token, entre novamente com as informações para abrir conta,";
        message +=" e um novo token será gerado e reenviado à você.";

        try {
            email.setHostName("smtp.googlemail.com");
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator("brunofaczz2@gmail.com", "misterios"));
            email.setSSLOnConnect(true);
            email.setFrom("brunofaczz2@gmail.com");
            email.setSubject("Token de autentificação");
            email.setMsg(message);
            email.addTo(receiver);
            email.send();

        } catch (EmailException e) {
            System.out.println(e.getMessage());
        }

    }
    
    public static void sendToken(String receiver, String token) throws EmailException {

        SimpleEmail email = new SimpleEmail();
        String message = "Para sua segurança, você precisa colocar o código abaixo para continar a transação.\n";
        message += "Token: " + token + "\n";
        message += "\nO sistema de token é para sua segurança, sempre ao realizar uma transação, um novo token é gerado ";
        message +=" e enviado à você.";

        try {
            email.setHostName("smtp.googlemail.com");
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator("brunofaczz2@gmail.com", "misterios"));
            email.setSSLOnConnect(true);
            email.setFrom("brunofaczz2@gmail.com");
            email.setSubject("Token para realizar transação");
            email.setMsg(message);
            email.addTo(receiver);
            email.send();

        } catch (EmailException e) {
            System.out.println(e.getMessage());
        }

    }
}
