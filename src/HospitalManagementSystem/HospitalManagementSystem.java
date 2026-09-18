package HospitalManagementSystem;

import java.sql.*;
import java.util.Scanner;

public class HospitalManagementSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Connection connection = DatabaseConnection.getConnection();
        
        if (connection == null) {
            System.out.println("Failed to connect to the database. Exiting...");
            return;
        }

        try {
            Patient patient = new Patient(connection, scanner);
            Doctor doctor = new Doctor(connection);
            Appointment appointment = new Appointment(connection, scanner, patient, doctor);
            Billing billing = new Billing(connection, scanner, patient);

            while (true) {
                System.out.println("====== HOSPITAL MANAGEMENT SYSTEM ======");
                System.out.println("1. Add Patient");
                System.out.println("2. View Patients");
                System.out.println("3. View Doctors");
                System.out.println("4. Book Appointment");
                System.out.println("5. View Appointments");
                System.out.println("6. Generate Bill");
                System.out.println("7. Pay Bill");
                System.out.println("8. View Bills");
                System.out.println("9. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        patient.addPatient();
                        System.out.println();
                        break;
                    case 2:
                        patient.viewPatients();
                        System.out.println();
                        break;
                    case 3:
                        doctor.viewDoctors();
                        System.out.println();
                        break;
                    case 4:
                        appointment.bookAppointment();
                        System.out.println();
                        break;
                    case 5:
                        appointment.viewAppointments();
                        System.out.println();
                        break;
                    case 6:
                        billing.generateBill();
                        System.out.println();
                        break;
                    case 7:
                        billing.payBill();
                        System.out.println();
                        break;
                    case 8:
                        billing.viewBills();
                        System.out.println();
                        break;
                    case 9:
                        System.out.println("THANK YOU! FOR USING HOSPITAL MANAGEMENT SYSTEM!!");
                        connection.close();
                        return;
                    default:
                        System.out.println("Enter valid choice!!!");
                        break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
