package com.edutrack.controller;

import com.edutrack.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/email")
@CrossOrigin(origins = "*")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send-result")
    public ResponseEntity<?> sendEmail(@RequestBody Map<String, String> payload) {
        String toEmail = payload.get("email");
        String studentName = payload.get("name");
        String status = payload.get("status");
        String percentage = payload.get("percentage");

        if (toEmail == null || toEmail.isEmpty()) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "Email address is required");
            return ResponseEntity.badRequest().body(error);
        }

        emailService.sendResultEmail(toEmail, studentName, status, percentage);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Email sent successfully (or attempted with dummy config).");
        return ResponseEntity.ok(response);
    }
}
