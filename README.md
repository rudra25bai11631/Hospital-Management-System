# Hospital Management System

This is a simple Hospital Management System project built using Java and MySQL. It's my submission for the Build Your Own Project assignment.

## Features
- Add and view patients
- View doctors in the hospital
- Book appointments (checks if doctor is free)
- Generate and pay patient bills

## What I Used
- **Language**: Java
- **Database**: MySQL
- **Connection**: JDBC (MySQL Connector 8.1.0 included in repo)

## How to Set Up and Run the Project (Command Line)

This project is fully executable via the command line terminal.

### 1. Database Setup
1. Ensure you have MySQL running locally (e.g., via XAMPP or standalone MySQL Server).
2. Open your MySQL command line or phpMyAdmin and run the following queries to create the database and tables:
   ```sql
   CREATE DATABASE hospital;
   USE hospital;
   
   CREATE TABLE patients (
       id INT AUTO_INCREMENT PRIMARY KEY,
       name VARCHAR(255) NOT NULL,
       age INT NOT NULL,
       gender VARCHAR(10) NOT NULL
   );
   
   CREATE TABLE doctors (
       id INT AUTO_INCREMENT PRIMARY KEY,
       name VARCHAR(255) NOT NULL,
       specialization VARCHAR(255) NOT NULL
   );
   
   CREATE TABLE appointments (
       id INT AUTO_INCREMENT PRIMARY KEY,
       patient_id INT NOT NULL,
       doctor_id INT NOT NULL,
       appointment_date DATE NOT NULL,
       FOREIGN KEY (patient_id) REFERENCES patients(id),
       FOREIGN KEY (doctor_id) REFERENCES doctors(id)
   );
   
   CREATE TABLE billing (
       id INT AUTO_INCREMENT PRIMARY KEY,
       patient_id INT NOT NULL,
       amount DECIMAL(10, 2) NOT NULL,
       status VARCHAR(50) NOT NULL,
       FOREIGN KEY (patient_id) REFERENCES patients(id)
   );
   
   INSERT INTO doctors (name, specialization) VALUES 
   ('Dr. Ramesh Verma', 'Orthopedic (Bones)'),
   ('Dr. Priya Reddy', 'Pediatrician (Kids)');
   ```

### 2. Configuration
Open `src/HospitalManagementSystem/DatabaseConnection.java` and ensure the `USERNAME` and `PASSWORD` variables match your local MySQL configuration. (By default, password is set to empty for XAMPP compatibility).

### 3. Execution via Terminal (Windows)
1. Open your command prompt (cmd) or PowerShell.
2. Navigate to the root directory of this repository:
   ```bash
   cd path/to/Hospital-Management-System
   ```
3. Compile all Java files:
   ```bash
   javac src/HospitalManagementSystem/*.java
   ```

## Instructions for Testing

This project does not rely on automated framework testing (like JUnit). Instead, all modules are designed to be tested manually through the interactive console interface. 

Below is the step-by-step workflow and formal test-case table to verify that the application and database are functioning correctly.

### Step-by-Step Manual Testing Workflow

To fully test the system's core requirements, follow this exact user journey once the application is running:

1. **Verify Database Connection:**
   - Launch the application. You should immediately see the main menu without any SQL exceptions, confirming the JDBC connection to MySQL is active.
2. **Test Patient Module (Create & Read):**
   - Press `1` to Add a Patient. Enter sample data (e.g., Name: `Rahul`, Age: `25`, Gender: `Male`).
   - Press `2` to View Patients. Verify that the console prints a formatted table containing the patient you just added. Take note of their `Patient ID` (likely `1`).
3. **Test Doctor Module (Read):**
   - Press `3` to View Doctors. Verify that the console prints the 3 pre-inserted doctors from the `schema.sql` script (Dr. Ramesh Verma, Dr. Priya Reddy, Dr. Sanjay Patel).
4. **Test Appointment Module:**
   - Press `4` to Book an Appointment. 
   - Enter your Patient ID (`1`), a Doctor ID (`1`), and a future date (`2024-12-01`). 
   - Press `5` to View Appointments to confirm the booking was saved to the database.
5. **Test Billing Module:**
   - Press `6` to Generate a Bill. Enter your Patient ID (`1`) and an amount (`500`).
   - Press `7` to Pay the Bill. Enter the Patient ID (`1`) again, and verify the success message.

---

### Formal Test Cases Table

| Test ID | Module | Action / Input Provided | Expected Result | Status |
| :--- | :--- | :--- | :--- | :--- |
| **TC-01** | **System** | Start the application via command line. | Main menu loads; no JDBC connection errors thrown. | ✅ Pass |
| **TC-02** | **Patient** | Select `1`. Input: Name: `Rahul`, Age: `25`, Gender: `Male` | Console prints "Patient Added Successfully" and data is saved to MySQL. | ✅ Pass |
| **TC-03** | **Patient** | Select `2`. | Console retrieves data from DB and prints Rahul's details in a formatted table. | ✅ Pass |
| **TC-04** | **Doctor** | Select `3`. | Application successfully queries the `doctors` table and lists available staff. | ✅ Pass |
| **TC-05** | **Appt** | Select `4`. Input: Patient ID `1`, Doctor ID `1`, Date `2024-12-01` | Console prints "Appointment Booked Successfully". | ✅ Pass |
| **TC-06** | **Appt** | Select `4` (Invalid ID). Input: Patient ID `999` (Non-existent) | Booking fails or SQL constraint prevents insertion due to invalid Foreign Key. | ✅ Pass |
| **TC-07** | **Billing** | Select `6`. Input: Patient ID `1`, Amount `500` | Console prints "Bill Generated Successfully". | ✅ Pass |
| **TC-08** | **Billing** | Select `7`. Input: Patient ID `1` | System finds the pending bill and updates status to "Paid". | ✅ Pass |

*(Note: For the best testing experience, please ensure inputs match the expected data types—e.g., entering numbers for IDs and Ages—as basic `Scanner` methods are used for console input).*
4. Run the main application (including the MySQL connector in the classpath):
   ```bash
   java -cp "src;mysql-connector-j-8.1.0.jar" HospitalManagementSystem.HospitalManagementSystem
   ```
5. The console menu will appear and you can start interacting with the system!
