package com.challenge.disney.servicios.implementacion;

import com.challenge.disney.servicios.EmailSenderServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderServicioImplementacion implements EmailSenderServicio {
    @Autowired
    private JavaMailSender javaMailSender;


    @Override
    public void sendEmail(String toEmail, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply.webprojects@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);


        javaMailSender.send(message);

        System.out.println("Correo enviado");
    }
}
