package com.edutrack.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/api/university")
@CrossOrigin(origins = "*") // Allows dashboard.html to call it
public class UniversityController {

    @GetMapping("/fetch-result")
    public ResponseEntity<Map<String, Object>> fetchResult(
            @RequestParam String univ,
            @RequestParam String rollNumber) {

        // We simulate fetching a real university result here
        Map<String, Object> result = new HashMap<>();
        Random random = new Random();

        // Basic Info
        result.put("university", univ.toUpperCase());
        result.put("rollNumber", rollNumber);
        result.put("studentName", "Student " + rollNumber.substring(0, Math.min(rollNumber.length(), 4)));
        result.put("course", "B.Tech Computer Science");
        result.put("semester", "6th Semester");
        result.put("department", "Engineering");

        // Mock Marks (out of 100)
        Map<String, Integer> marks = new HashMap<>();
        marks.put("Mathematics", 60 + random.nextInt(40)); // 60 to 99
        marks.put("Science", 55 + random.nextInt(40));
        marks.put("English", 70 + random.nextInt(25));
        marks.put("Social Science", 65 + random.nextInt(30));
        marks.put("Computer Science", 75 + random.nextInt(25));
        marks.put("Hindi", 80 + random.nextInt(15));
        result.put("marks", marks);

        // Status logic
        int total = marks.values().stream().mapToInt(Integer::intValue).sum();
        double pct = (double) total / 600 * 100;
        result.put("totalMarks", total);
        result.put("percentage", Math.round(pct * 100.0) / 100.0);
        result.put("status", pct >= 40 ? "PASS" : "FAIL");

        // Artificial delay to simulate network/university processing time
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok(result);
    }
}
