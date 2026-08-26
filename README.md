# EduTrack: Advanced Student Score Management System

Welcome to **EduTrack**, a modern, full-stack web application built for efficiently managing, calculating, and securely sharing student academic records. 

This project simulates a real-world enterprise application with a robust Java Spring Boot backend, a responsive Vanilla JS frontend, and integrations with email services and REST APIs.

## 🌟 Key Features

1. **Native Mock API Integration (Fetch Result):**
   - Simulates fetching live student results from university servers (like AKTU and CCSU) using a native REST endpoint.
   - **Magic Auto-Fill:** Fetched data can be imported into the calculator with a single click, filling out all subject marks and details automatically.
   
2. **Dynamic Score Calculation:**
   - Real-time calculation of Total Marks, Percentage, and Grades based on university standards.
   - Dynamic UI progress bars and grade indicators.

3. **Email Notification System:**
   - Integrated JavaMailSender to send official result marksheets directly to the student's email inbox.
   
4. **PDF Report Generation:**
   - One-click export of the student's marksheet to a professionally formatted PDF file using `html2pdf.js`.

5. **External API Usage:**
   - Integrates with the public Hipolabs API to provide a live search and auto-complete feature for thousands of global universities.

6. **Secure Local Database:**
   - Uses SQLite to persistently store calculated records, ensuring data remains safe even after the server restarts.

## 🛠️ Technology Stack

**Frontend (Client-Side):**
- **HTML5 & CSS3:** Custom, modern, glassmorphism-inspired UI without heavy CSS frameworks.
- **JavaScript (ES6):** Handles API calls (`fetch`), DOM manipulation, dynamic charts (Chart.js), and PDF generation.

**Backend (Server-Side):**
- **Java 17:** Core programming language.
- **Spring Boot 3:** Framework for building the RESTful backend.
- **Spring Data JPA & Hibernate:** ORM for managing database operations.
- **JavaMailSender:** For sending SMTP emails.

**Database:**
- **SQLite:** Lightweight, serverless relational database for local storage.

## 🚀 How to Run the Project

### Prerequisites
- **Java Development Kit (JDK 17 or higher)**
- **Maven** (to build the Java project)
- A modern web browser (Chrome/Edge/Firefox)

### Steps to Start

1. **Build and Run the Backend Server:**
   Open your terminal/command prompt, navigate to the `backend` folder, and run:
   ```bash
   cd backend
   mvn clean install -DskipTests
   java -jar target\student-score-backend-0.0.1-SNAPSHOT.jar
   ```
   *The server will start on `http://localhost:8080`.*

2. **Access the Application:**
   Open your browser and navigate to:
   ```
   http://localhost:8080/dashboard.html
   ```

3. **Login:**
   Enter any Name and Roll Number to enter the dashboard.

## 📂 Project Structure

```
StudentScoreManagement_Enhanced/
├── backend/                   # Java Spring Boot Backend
│   ├── src/main/java/com/edutrack/
│   │   ├── controller/        # REST API Endpoints (Result, Email, Score)
│   │   ├── model/             # JPA Entities (Database tables)
│   │   ├── repository/        # SQLite Database operations
│   │   └── service/           # Business logic (Email sending, etc.)
│   └── src/main/resources/
│       └── application.properties # Server configs (Port, Database, SMTP)
└── StudentScoreManagement/    # Static Frontend Files
    ├── index.html             # Login Page
    ├── dashboard.html         # Main Application UI
    ├── style.css              # Custom Styling
    └── script.js              # Auth & Navigation logic
```

## 🔒 Security & Email Configuration
The Email feature requires a real Gmail account and an "App Password" to work. 

**How to enable the Email Feature:**
1. Open the file `backend/src/main/resources/application.properties`.
2. Find the following lines:
   ```properties
   spring.mail.username=your_email@gmail.com
   spring.mail.password=your_16_digit_app_password
   ```
3. Replace `your_email@gmail.com` with your real Gmail address.
4. Replace `your_16_digit_app_password` with a 16-letter **App Password**.
   - *Note: Do NOT use your normal Google login password.*
   - *To get an App Password: Go to Google Account -> Security -> 2-Step Verification -> App Passwords -> Generate a new password for "Mail".*
5. Save the file, restart the Java backend (`mvn clean install` then `java -jar...`), and the "Email Result" button will start sending real emails!
