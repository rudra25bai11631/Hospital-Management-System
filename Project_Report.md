# Project Report: Hospital Management System

## 1. Cover Page
**Project Title**: Hospital Management System  
**Course Name**: Programming-in-java 
**Student Name**: RUDRA RAI  
**Registration Number**: 25BAI11631  
**Date of Submission**: 18/09/2026  

---

## 2. Introduction
This project is a simple Hospital Management System built using Java and MySQL. The idea is to move away from keeping paper records and instead use a database to keep track of patients, doctors, appointments, and bills. It's a console-based application that uses basic Object-Oriented Programming and JDBC to connect to the database.

---

## 3. Problem Statement
Many small clinics and hospitals still use manual registers to manage patient details and appointments. This can cause problems like losing data, duplicating entries, or accidentally booking two patients for the same doctor on the same day. This project solves that by storing everything centrally in a MySQL database.

---

## 4. Functional Requirements
The system has these main modules:
1. **Patient Module**: Add new patients to the database and view the list of patients.
2. **Appointment Module**: Book appointments for patients and check if the doctor is actually free on that date.
3. **Billing Module**: Generate a bill amount for a patient and update it when they pay.

---

## 5. Non-functional Requirements
1. **Reliability**: Uses primary and foreign keys in the database so we don't end up with an appointment for a patient that doesn't exist.
2. **Usability**: Has a simple menu in the console where the user just types a number to pick an option.
3. **Maintainability**: The code is split into different classes (like Patient, Doctor, Billing) instead of putting everything in one huge main file.
4. **Performance**: Uses standard JDBC queries which fetch data quickly for small to medium clinic sizes.

---

## 6. System Architecture
The project uses a basic Two-Tier Architecture:
- **Client Side**: The Java console application where the user interacts with the menu.
- **Database Side**: The MySQL server where all the tables are stored.
- **Connection**: JDBC (Java Database Connectivity) is used to send SQL queries from Java to MySQL.

---

## 7. Design Diagrams

- **Use Case Diagram**: Shows the admin interacting with the different menu options.
- **Workflow Diagram**: Menu -> Pick Option -> Enter Data -> Database updates -> Back to Menu.
- **Class Diagram**: Shows classes like Main, Patient, Doctor, Appointment, and Billing.
- **ER Diagram**: Shows the relationship between Patients, Doctors, Appointments, and Billing tables.
 


---

## 8. Design Decisions & Rationale
- I decided to make a separate `DatabaseConnection.java` class. This way, I don't have to write the MySQL username and password in every single file, which makes it much easier to change later.
- I used `Scanner` for inputs because it's simple to use for console applications.

---

## 9. Implementation Details
The project was coded in Java using standard libraries like `java.sql` for the database connection. 
Some key points about the code:
- I used `PreparedStatement` to run SQL queries. Our professor mentioned this is better than normal `Statement` because it prevents SQL injection.
- I used foreign keys in MySQL so that an appointment must have a valid `patient_id` and `doctor_id`.

---

## 10. Screenshots / Results
1. Adding a New Patient
<img width="1024" height="348" alt="media_1789741704330" src="https://github.com/user-attachments/assets/91c77b35-d219-4fbb-83f1-d22528365605" />

2. Viewing Available Doctors
<img width="1024" height="504" alt="media_1789741696979" src="https://github.com/user-attachments/assets/112c6f31-07be-42ed-8d23-c9fa03610a83" />


3. Booking an Appointment
<img width="1024" height="317" alt="media_1789741697023" src="https://github.com/user-attachments/assets/e62df6d3-bbc4-4c44-a421-9faa231e9060" />


4. Viewing Scheduled Appointments
<img width="887" height="345" alt="media_1789741697024" src="https://github.com/user-attachments/assets/13bd0dc2-d415-4921-a319-744c764022a0" />


5. Generating a Bill
<img width="910" height="337" alt="media_1789741696967" src="https://github.com/user-attachments/assets/bc5fc692-1c8a-4d5f-8f32-fd22f3595dbf" />

---

## 11. Testing Approach
- **Wrong ID test**: I tried to book an appointment with a patient ID that isn't in the database, and the system correctly showed an error message.
- **Double-booking test**: I tried to book an appointment with the same doctor on the same date twice, and the system blocked the second one.

---

## 12. Challenges Faced
- Getting the JDBC driver to work in my IDE took some time. I had to figure out how to add the `mysql-connector-java` jar file to my project libraries.
- `Scanner` sometimes skipped lines when I mixed `nextInt()` and `nextLine()`, so I had to be careful with how I took user inputs.
-I got stuck for an hour trying to get the mysql-connector jar to work in Eclipse, but finally figured out the Build Path settings.

---

## 13. Learnings & Key Takeaways
- I learned how to connect a Java application to a real database using JDBC.
- I got better at writing SQL queries (INSERT, SELECT, UPDATE) and running them from inside Java code.
- I learned how to split a big program into smaller, logical classes.

---

## 14. Future Enhancements
- Instead of a black console screen, I want to build a real Graphical User Interface (GUI) using Java Swing or JavaFX.
- I want to add a login system so only authorized admins can access the data.

---

## 15. References
- Java JDBC documentation
- W3Schools SQL Tutorial
- My class lecture notes
