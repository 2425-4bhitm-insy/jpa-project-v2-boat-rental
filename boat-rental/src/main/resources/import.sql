/*insert into customer (name, address, telephoneNumber, email)
values ('Doe', 'Bakerstreet', '0202', 'doe@gmail.com')*/
-- Customers
INSERT INTO br_customer (customer_id, firstname, lastname, address, telephonenumber, email) VALUES
                                                                                                (1, 'John', 'Doe', '123 Main St', '123-456-7890', 'john.doe@example.com'),
                                                                                                (2, 'Jane', 'Smith', '456 Oak St', '987-654-3210', 'jane.smith@example.com');

-- Employees
INSERT INTO br_employee (employee_id, firstname, lastname, role, telephonenumber) VALUES
                                                                                      (1, 'Alice', 'Johnson', 'Manager', '555-123-4567'),
                                                                                      (2, 'Bob', 'Williams', 'Staff', '555-987-6543');

-- Boats (Boat extends RentalItems)
INSERT INTO br_boat (id, name, isrented, description, price, capacity) VALUES
                                                                           (1, 'Sea Breeze', false, 'Small sailboat, perfect for beginners.', 100.0, 4),
                                                                           (2, 'Wave Rider', true, 'Fast motorboat for watersports.', 250.0, 6),
                                                                           (3, 'Ocean Queen', false, 'Luxury yacht with many rooms.', 1000.0, 12);

-- Sailboat (extends Boat)
INSERT INTO br_sailboat (id, sails) VALUES
    (1, 2);

-- Motorboat (extends Boat)
INSERT INTO br_motorboat (id, motors, material) VALUES
    (2, 2, 'Fiberglass');

-- Yacht (extends Boat)
INSERT INTO br_yacht (id, rooms, extraBoats) VALUES
    (3, 5, 1);

-- Extras (also extends RentalItems)
INSERT INTO br_extras (id, name, description, price) VALUES
                                                         (4, 'Snorkel Set', 'Complete snorkel gear for rent.', 20.0),
                                                         (5, 'Life Jackets', 'Life jackets for all ages.', 15.0);

-- Reservations
INSERT INTO br_reservation (id, customer_customer_id, employee_employee_id, startdate, enddate) VALUES
                                                                                                    (1, 1, 1, '2025-05-01', '2025-05-05'),
                                                                                                    (2, 2, 2, '2025-06-10', '2025-06-15');

-- Lease
INSERT INTO br_lease (id, reservation_id, rentalitems_id) VALUES
                                                              (1, 1, 1), -- John leases Sea Breeze
                                                              (2, 1, 4), -- John leases Snorkel Set
                                                              (3, 2, 2), -- Jane leases Wave Rider
                                                              (4, 2, 5); -- Jane leases Life Jackets

-- Payment
INSERT INTO br_payment (id, amount, paymentdate, reservation_id) VALUES
                                                                     (1, 140.0, '2025-05-01', 1),
                                                                     (2, 265.0, '2025-06-10', 2);