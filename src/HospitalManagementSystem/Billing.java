package HospitalManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Billing {
    private Connection connection;
    private Scanner scanner;
    private Patient patient;

    public Billing(Connection connection, Scanner scanner, Patient patient) {
        this.connection = connection;
        this.scanner = scanner;
        this.patient = patient;
        
        // Ensure billing table exists
        createBillingTableIfNotExists();
    }

    private void createBillingTableIfNotExists() {
        String query = "CREATE TABLE IF NOT EXISTS billing (" +
                       "id INT AUTO_INCREMENT PRIMARY KEY, " +
                       "patient_id INT NOT NULL, " +
                       "amount DECIMAL(10, 2) NOT NULL, " +
                       "status VARCHAR(50) NOT NULL, " +
                       "FOREIGN KEY (patient_id) REFERENCES patients(id))";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Error ensuring billing table exists: " + e.getMessage());
        }
    }

    public void generateBill() {
        System.out.print("Enter Patient Id: ");
        int patientId = scanner.nextInt();
        
        if (patient.getPatientById(patientId)) {
            System.out.print("Enter Bill Amount: ");
            double amount = scanner.nextDouble();
            String status = "UNPAID";

            String query = "INSERT INTO billing(patient_id, amount, status) VALUES(?, ?, ?)";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, patientId);
                preparedStatement.setDouble(2, amount);
                preparedStatement.setString(3, status);
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Bill Generated Successfully!");
                } else {
                    System.out.println("Failed to Generate Bill!");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Patient does not exist!");
        }
    }

    public void payBill() {
        System.out.print("Enter Bill ID to Pay: ");
        int billId = scanner.nextInt();

        String query = "UPDATE billing SET status = 'PAID' WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, billId);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Bill Paid Successfully!");
            } else {
                System.out.println("Failed to Pay Bill! Bill ID might not exist.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewBills() {
        String query = "SELECT * FROM billing";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Billing Records: ");
            System.out.println("+---------+------------+----------+----------+");
            System.out.println("| Bill ID | Patient ID | Amount   | Status   |");
            System.out.println("+---------+------------+----------+----------+");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int patientId = resultSet.getInt("patient_id");
                double amount = resultSet.getDouble("amount");
                String status = resultSet.getString("status");
                System.out.printf("| %-7s | %-10s | %-8.2f | %-8s |\n", id, patientId, amount, status);
                System.out.println("+---------+------------+----------+----------+");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
