package com.edutrack.model;

import jakarta.persistence.*;

@Entity
@Table(name = "mark_records")
public class MarkRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String studentName;
    private String rollNumber;
    private String course;
    private String semester;
    private String department;
    
    private double math;
    private double science;
    private double english;
    private double social;
    private double computer;
    private double hindi;

    private double total;
    private double percentage;
    private String grade;
    private String status;

    public MarkRecord() {}

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    public String getRollNumber() { return rollNumber; }
    public void setRollNumber(String rollNumber) { this.rollNumber = rollNumber; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }

    public String getSemester() { return semester; }
    public void setSemester(String semester) { this.semester = semester; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public double getMath() { return math; }
    public void setMath(double math) { this.math = math; }

    public double getScience() { return science; }
    public void setScience(double science) { this.science = science; }

    public double getEnglish() { return english; }
    public void setEnglish(double english) { this.english = english; }

    public double getSocial() { return social; }
    public void setSocial(double social) { this.social = social; }

    public double getComputer() { return computer; }
    public void setComputer(double computer) { this.computer = computer; }

    public double getHindi() { return hindi; }
    public void setHindi(double hindi) { this.hindi = hindi; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    public double getPercentage() { return percentage; }
    public void setPercentage(double percentage) { this.percentage = percentage; }

    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
