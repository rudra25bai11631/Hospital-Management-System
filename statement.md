# Problem Statement

Right now, a lot of smaller hospitals still use paper to keep track of patients and appointments. This takes up a lot of time, and sometimes records get lost or people double-book a doctor by mistake. We need a simple computer system to store this information in a database instead, making it faster and easier to manage.

# Scope of the project

This project is a Java console application that connects to a MySQL database. It handles the basic operations of a hospital, such as:
- Adding and storing patient details.
- Showing a list of doctors.
- Booking appointments (and making sure the doctor isn't double-booked on that date).
- Creating bills for patients and keeping track of paid/unpaid status.

# Target users

- **Receptionists**: To register patients and book their appointments.
- **Billing Staff**: To manage bills and update payment status.

# High-level features

1. **Patient Management**: Add new patients and view all patients.
2. **Doctor Details**: View a list of available doctors.
3. **Appointment Booking**: Securely book appointments by checking if the doctor is available.
4. **Billing System**: Generate patient bills and mark them as paid.
