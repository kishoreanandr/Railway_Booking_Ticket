# Railway Ticket Booking System

## Overview
The Railway Ticket Booking System is a console-based Java application designed to manage ticket bookings, cancellations, and the display of available tickets efficiently. It ensures proper allocation of berths based on user preferences, age, and other conditions (e.g., senior citizens and passengers with children).

### Features
- **Ticket Booking:** Supports booking based on berth preferences (Lower, Middle, Upper) and availability.
- **Special Preferences:** 
  - Senior citizens are prioritized for lower berths.
  - Passengers with children are also prioritized for lower berths.
- **Waitlist and RAC Management:** Automatically places passengers in RAC or waitlist if no confirmed berths are available.
- **Ticket Cancellation:** Cancelling a ticket adjusts berth and waitlist allocations dynamically.
- **Display Available Tickets:** Shows real-time availability of all berths, RAC, and waitlist slots.
- **Display Booked Tickets:** Lists all booked tickets with passenger details.

### Benefits
- Dynamic berth allocation ensures fairness and optimal seat usage.
- Simple command-line interface (CLI) for ease of use.
- Automatic handling of RAC and waitlist adjustments during cancellations.

---

## Prerequisites

### Software Requirements
- **Java Development Kit (JDK):** Version 8 or later.
- **IDE (Optional):** IntelliJ IDEA, Eclipse, or any text editor.

### Installation Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/railway-ticket-booking.git
   ```
2. Open the project in your favorite IDE or text editor.
3. Compile the Java files:
   ```bash
   javac Railway_Booking_Main.java Ticket_Book.java Passenger.java
   ```
4. Run the application:
   ```bash
   java Railway_Booking_Main
   ```

---

## How to Use

1. Run the program and choose from the main menu:
   - **1. Book:** Enter passenger details to book tickets.
   - **2. Cancel:** Enter a passenger ID to cancel their ticket.
   - **3. Available Tickets:** View the number of tickets available for each berth type, RAC, and waitlist.
   - **4. Booked Tickets:** View details of all booked tickets.
   - **5. Exit:** Quit the application.

2. The program automatically handles berth allocation, RAC, and waitlist based on user input and seat availability.

---

## Project Structure

```plaintext
src/
├── Railway_Booking_Main.java  // Main class to handle the user interface and menu options
├── Ticket_Book.java           // Manages ticket booking, cancellation, and RAC/waitlist allocations
└── Passenger.java             // Passenger data model with relevant attributes
```

---

## Contribution

Contributions are welcome! If you'd like to improve the system or add new features, follow these steps:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Commit your changes.
4. Push to your branch.
5. Open a pull request.

---


---

## Contact
For any queries or feedback, feel free to reach out at kishoreanand.r@gmail.com.
