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
4. Run the main application (including the MySQL connector in the classpath):
   ```bash
   java -cp "src;mysql-connector-j-8.1.0.jar" HospitalManagementSystem.HospitalManagementSystem
   ```
5. The console menu will appear and you can start interacting with the system!
