# Project Report: EduTrack (Student Score Management System)

## 1. Introduction
EduTrack is a comprehensive, full-stack academic management solution designed to streamline the process of fetching, calculating, storing, and communicating student results. It was built to demonstrate proficiency in both backend system design and modern frontend development.

## 2. Objective
The primary goal of this project is to create an end-to-end web application that:
- Fetches student data dynamically (Mock API simulation).
- Calculates academic performance (Grades, Percentages).
- Stores the processed data persistently in a database.
- Communicates the results to the student via Email and PDF.

## 3. System Architecture (Internal vs. External Parts)

The project follows a standard **Client-Server (3-Tier) Architecture**.

### A. The External Part (Frontend / Client-Side)
The frontend is the interface that the user (Teacher/Admin) interacts with. It runs entirely in the user's web browser.

- **UI/UX Design:** Built using plain HTML and custom CSS. It features a modern dark theme with glassmorphism effects, ensuring a premium feel.
- **Client Logic:** JavaScript handles all client-side logic.
  - **Data Fetching:** Makes HTTP `GET` and `POST` requests to the Java Backend.
  - **Dynamic Rendering:** Updates the UI (progress bars, charts, tables) dynamically without reloading the page (Single Page Application behavior).
  - **Third-Party Libraries:** Uses `Chart.js` for plotting performance graphs and `html2pdf.js` for converting the DOM elements into a downloadable PDF file.
- **External Public API (Hipolabs):** The frontend directly connects to an external public API (`http://universities.hipolabs.com/search`) to search for real university names globally as the user types.

### B. The Internal Part (Backend / Server-Side)
The backend is the brain of the application. It runs on a server (locally via Tomcat embedded in Spring Boot) and processes all business logic.

- **Framework:** Developed using Java **Spring Boot**.
- **Controllers (REST APIs):**
  1. **`UniversityController`:** Acts as a Mock API. When the frontend requests a result for AKTU/CCSU, this controller generates realistic JSON data (Name, Course, Subject Marks) and sends it back. This simulates how a real university server would respond, bypassing their strict Cloudflare/Captcha security.
  2. **`ScoreController`:** Handles saving the calculated results into the database and fetching previous records for the "Calculated Records" storage tab.
  3. **`EmailController`:** Receives the student's email and calculated marks, constructs an HTML email template, and triggers the `EmailService`.
- **Services:**
  - **`EmailService`:** Uses `JavaMailSender` and SMTP protocols to connect to Gmail's servers. It authenticates using an App Password and dispatches the actual email over the internet.
- **Database Layer (SQLite):**
  - Uses **Spring Data JPA** & **Hibernate** to map Java objects (Models) directly to database tables.
  - SQLite was chosen because it stores the entire database in a single local file (`student_scores.db`), requiring no complex database server installation.

## 4. Workflow Example: "Check Result to Email"

1. **User Action:** The user enters a Roll Number in the "Check Result" tab and clicks Fetch.
2. **API Call:** Frontend JS sends a `GET` request to `/api/university/fetch-result`.
3. **Backend Processing:** `UniversityController` receives the request, generates mock JSON data, and returns it.
4. **Auto-Fill:** The user clicks "Import to Calculation Form". Frontend JS parses the JSON and populates the input fields.
5. **Calculation:** JS calculates the percentage and grade locally.
6. **Save to DB:** User clicks "Save Record". JS sends a `POST` request to `/api/scores`. The `ScoreController` saves it via JPA to SQLite.
7. **Email Generation:** User clicks "Email Result". JS sends a `POST` request to `/api/email/send-result`. The Java server logs into Gmail and sends the marksheet.

## 5. Security & Limitations
- **Security:** Passwords (like the Google App Password) are stored securely in `application.properties` and are never exposed to the frontend browser.
- **Limitation (Web Scraping):** Initially, the project attempted to embed or scrape real university sites (AKTU/CCSU). However, due to enterprise-grade security (Cloudflare Bot Protection and Image Captchas) used by these universities, direct automated data extraction is illegal and technically blocked. Thus, the robust Mock API approach was implemented to demonstrate the data flow architecture perfectly without violating third-party security policies.

## 6. Conclusion
EduTrack successfully integrates multiple complex components—RESTful APIs, Database Management, SMTP Email protocols, and dynamic Frontend rendering—into a cohesive, high-performance application. It serves as an excellent demonstration of full-stack software engineering principles.
