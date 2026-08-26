package com.edutrack.controller;

import com.edutrack.model.MarkRecord;
import com.edutrack.repository.MarkRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marks")
@CrossOrigin(origins = "*") // Allow requests from any origin for now
public class MarkController {

    @Autowired
    private MarkRecordRepository repository;

    @PostMapping
    public ResponseEntity<MarkRecord> saveMarks(@RequestBody MarkRecord record) {
        MarkRecord saved = repository.save(record);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MarkRecord> updateMarks(@PathVariable Long id, @RequestBody MarkRecord recordDetails) {
        return repository.findById(id).map(record -> {
            record.setStudentName(recordDetails.getStudentName());
            record.setRollNumber(recordDetails.getRollNumber());
            record.setCourse(recordDetails.getCourse());
            record.setSemester(recordDetails.getSemester());
            record.setDepartment(recordDetails.getDepartment());
            record.setMath(recordDetails.getMath());
            record.setScience(recordDetails.getScience());
            record.setEnglish(recordDetails.getEnglish());
            record.setSocial(recordDetails.getSocial());
            record.setComputer(recordDetails.getComputer());
            record.setHindi(recordDetails.getHindi());
            record.setTotal(recordDetails.getTotal());
            record.setPercentage(recordDetails.getPercentage());
            record.setGrade(recordDetails.getGrade());
            record.setStatus(recordDetails.getStatus());
            return ResponseEntity.ok(repository.save(record));
        }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<MarkRecord>> getAllMarks() {
        return ResponseEntity.ok(repository.findAll());
    }
}
