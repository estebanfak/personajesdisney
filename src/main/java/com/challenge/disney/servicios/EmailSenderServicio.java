package com.challenge.disney.servicios;

public interface EmailSenderServicio {
    void sendEmail(String toEmail, String subject, String body);
}
