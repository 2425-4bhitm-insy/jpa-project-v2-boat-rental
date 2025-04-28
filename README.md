# Boat Rental Service

Welcome to our Boat Rental Service! Whether you're looking for a relaxing day on the water or an exciting adventure,
we have the perfect boat for you. Our rental service offers a variety of boats to suit your needs, whether it's for
fishing, sightseeing, or simply unwinding with family and friends. Enjoy the beauty of the water at your own pace with
our easy and hassle-free rental process.

# What We Offer
* Motorboats
* Sailboats
* Yacht

# Datenbank starten
*  docker run --restart unless-stopped --name boatRentalPostgres -e POSTGRES_PASSWORD=postgres -d -p 5432:5432 -v $HOME/database/postgres:/var/lib/postgresql/data postgres


# Functionality

The Boat Rental Management System is a database-driven application designed to manage the rental operations of a boat 
rental company.
It handles customers, employees, boats (with various types like sailboats, motorboats, and yachts), extras (such as 
snorkel sets or life jackets), reservations, leases, and payments.

This system provides a structured and organized way to keep track of all rental activities, ensuring smooth operations 
and easy access to important data.


# Core Functionality

### Customers Management
- Store personal details such as name, address, phone number, and email.
- Easily identify and manage existing customers.
- Support a growing customer base with unique IDs.

### Employees Management
- Maintain employee records including name, role (e.g., Manager, Staff), and contact details.
- Track who assisted with which reservation.

### Rental Items
- Manage all rentable items through a unified rental system.
- Support multiple item types:
- Sailboats (with specific attributes like number of sails)
- Motorboats (number of motors and material)
- Yachts (number of rooms and extra boats)
- Extras (e.g., snorkel gear, life jackets)
- Keep track of each item’s status (available, rented).

### Reservations
- Customers can create reservations for a set period (start and end dates).
- Each reservation is linked to a customer and an employee.
- Reservations can include one or multiple rental items.

### Leases
- A lease links specific rental items to a reservation.
- Support multiple leases under a single reservation (e.g., renting both a boat and extra equipment).

### Payments

- Record payments made for reservations.
- Store payment amounts, dates, and associated reservations.


# Technical Structure

## Database tables:
- br_customer
- br_employee
- br_rentalitems
- br_boat
- br_sailboat
- br_motorboat
- br_yacht
- br_extras
- br_reservation
- br_lease
- br_payment

## Inheritance Structure:
- RentalItems is the base entity.
- Boat extends RentalItems, and Sailboat, Motorboat, and Yacht extend Boat.


# Data Handling:
- Auto-increment sequences ensure ID management across tables.
- Relationships between customers, employees, rental items, reservations, leases, and payments are maintained through foreign keys.


## Functionalities:
- View, add, or update customer and employee information.
- Manage the entire rental inventory (boats and extras).
- Create new reservations and assign boats and equipment to customers.
- Track which items are currently rented and which are available.
