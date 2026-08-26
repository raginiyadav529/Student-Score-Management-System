package com.edutrack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendResultEmail(String toEmail, String studentName, String status, String percentage) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("dummy@gmail.com");
            message.setTo(toEmail);
            message.setSubject("EduTrack: Your Academic Result is Ready");
            message.setText("Dear " + studentName + ",\n\n" +
                    "Your academic result has been generated on EduTrack.\n" +
                    "Status: " + status + "\n" +
                    "Percentage: " + percentage + "%\n\n" +
                    "Please login to the portal to view your detailed graph and download the PDF report.\n\n" +
                    "Regards,\nEduTrack Administration");
            
            mailSender.send(message);
        } catch (Exception e) {
            System.err.println("Failed to send email. Check SMTP configuration: " + e.getMessage());
        }
    }
}
