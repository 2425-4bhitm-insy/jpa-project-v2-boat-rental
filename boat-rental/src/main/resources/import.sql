INSERT INTO br_customer (customer_id, firstname, lastname, address, telephonenumber, email) VALUES
                                                                                                (1, 'John', 'Doe', '123 Main St', '123-456-7890', 'john.doe@example.com'),
                                                                                                (2, 'Jane', 'Smith', '456 Oak St', '987-654-3210', 'jane.smith@example.com');

INSERT INTO br_employee (employee_id, firstname, lastname, role, telephonenumber) VALUES
                                                                                      (1, 'Alice', 'Johnson', 'Manager', '555-123-4567'),
                                                                                      (2, 'Bob', 'Williams', 'Staff', '555-987-6543');

INSERT INTO br_rentalitems (id) VALUES
                                    (1), (2), (3), (4), (5);

INSERT INTO br_boat (id, name, isRented, description, price, capacity) VALUES
                                                                           (1, 'Sea Breeze', false, 'Small sailboat, perfect for beginners.', 100.0, 4),
                                                                           (2, 'Wave Rider', true, 'Fast motorboat for watersports.', 250.0, 6),
                                                                           (3, 'Ocean Queen', false, 'Luxury yacht with many rooms.', 1000.0, 12);

INSERT INTO br_sailboat (id, sails) VALUES
    (1, 2);

INSERT INTO br_motorboat (id, motors, material) VALUES
    (2, 2, 'Fiberglass');

INSERT INTO br_yacht (id, rooms, extraBoats) VALUES
    (3, 5, 1);

INSERT INTO br_extras (id, name, description, price) VALUES
                                                         (4, 'Snorkel Set', 'Complete snorkel gear for rent.', 20.0),
                                                         (5, 'Life Jackets', 'Life jackets for all ages.', 15.0);

INSERT INTO br_reservation (id, customer_customer_id, employee_employee_id, startdate, enddate) VALUES
                                                                                                    (1, 1, 1, '2025-05-01', '2025-05-05'),
                                                                                                    (2, 2, 2, '2025-06-10', '2025-06-15'),
                                                                                                    (3, 1, 1, '2025-04-28', '2025-05-09');


INSERT INTO br_lease (id, reservation_id, rentalitems_id) VALUES
                                                              (1, 1, 1), -- John leases Sea Breeze (Boat)
                                                              (2, 1, 4), -- John leases Snorkel Set (Extra)
                                                              (3, 2, 2), -- Jane leases Wave Rider (Boat)
                                                              (4, 2, 5), -- Jane leases Life Jackets (Extra)
                                                              (5, 3, 1); -- John leases Sea Breeze (Boat) right now

INSERT INTO br_payment (id, amount, paymentdate, reservation_id) VALUES
                                                                     (1, 140.0, '2025-05-01', 1),
                                                                     (2, 265.0, '2025-06-10', 2);

SELECT setval('br_customer_customer_id_seq', (SELECT max(customer_id) FROM br_customer));
SELECT setval('br_employee_employee_id_seq', (SELECT max(employee_id) FROM br_employee));
SELECT setval('br_rentalitems_id_seq', (SELECT max(id) FROM rentalitems));
SELECT setval('br_reservation_id_seq', (SELECT max(id) FROM br_reservation));
SELECT setval('br_lease_id_seq', (SELECT max(id) FROM br_lease));
SELECT setval('br_payment_id_seq', (SELECT max(id) FROM br_payment));