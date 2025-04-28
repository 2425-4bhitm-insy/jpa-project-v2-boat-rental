
-- ================================
-- Customers
-- ================================

INSERT INTO br_customer (customer_id, firstname, lastname, address, telephonenumber, email) VALUES
(1, 'John', 'Doe', '123 Main St', '123-456-7890',
 'john.doe@example.com'),
(2, 'Jane', 'Smith', '456 Oak St', '987-654-3210',
 'jane.smith@example.com'),
(3, 'Emily', 'Clark', '789 Pine St', '555-678-1234',
 'emily.clark@example.com'),
(4, 'Michael', 'Brown', '321 Maple Ave', '555-321-6789',
 'michael.brown@example.com'),
(5, 'Olivia', 'Taylor', '654 Cedar Rd', '555-111-2222',
 'olivia.taylor@example.com'),
(6, 'William', 'Davis', '987 Birch Blvd', '555-333-4444',
 'william.davis@example.com'),
(7, 'Sophia', 'Martinez', '135 Elm St', '555-555-6666',
 'sophia.martinez@example.com'),
(8, 'James', 'Garcia', '246 Spruce Ln', '555-777-8888',
 'james.garcia@example.com'),
(9, 'Isabella', 'Rodriguez', '369 Poplar Dr', '555-999-0000',
 'isabella.rodriguez@example.com'),
(10, 'Benjamin', 'Lee', '147 Cypress St', '555-112-3344',
 'benjamin.lee@example.com'),
(11, 'Mia', 'Walker', '258 Chestnut Ave', '555-556-7788',
 'mia.walker@example.com'),
(12, 'Lucas', 'Hall', '369 Walnut Blvd', '555-889-9900',
 'lucas.hall@example.com'),
(13, 'Charlotte', 'Allen', '159 Redwood Way', '555-123-4321',
 'charlotte.allen@example.com'),
(14, 'Henry', 'Young', '753 Willow Rd', '555-654-9870',
 'henry.young@example.com'),
(15, 'Amelia', 'Hernandez', '852 Aspen St', '555-321-1234',
 'amelia.hernandez@example.com'),
(16, 'Lukas', 'Fischer', 'Hauptstraße 23, Berlin', '030-1112233',
 'lukas.fischer@example.com'),
(17, 'Anna', 'Weber', 'Lindenweg 12, Nürnberg', '0911-4455667',
 'anna.weber@example.com'),
(18, 'Jonas', 'Schulz', 'Mozartstraße 45, Köln', '0221-7788990',
 'jonas.schulz@example.com'),
(19, 'Laura', 'Schneider', 'Parkallee 7, Bremen', '0421-9988776',
 'laura.schneider@example.com'),
(20, 'Leon', 'Meyer', 'Am Ring 17, Düsseldorf', '0211-5566778',
 'leon.meyer@example.com'),
(21, 'Clara', 'Hoffmann', 'Bahnstraße 5, Hamburg', '040-6677889',
 'clara.hoffmann@example.com'),
(22, 'Paul', 'Klein', 'Feldstraße 19, München', '089-4455778',
 'paul.klein@example.com');



-- ================================
-- Employees
-- ================================

INSERT INTO br_employee (employee_id, firstname, lastname, role, telephonenumber) VALUES
(1, 'Alice', 'Johnson', 'Manager', '555-123-4567'),
(2, 'Bob', 'Williams', 'Staff', '555-987-6543'),
(3, 'Clara', 'Evans', 'Technician', '555-333-2222'),
(4, 'Daniel', 'Scott', 'Manager', '555-444-1111'),
(5, 'Eva', 'Turner', 'Staff', '555-666-7777');



-- ================================
-- Rental Items
-- ================================

INSERT INTO br_rentalitems (id) VALUES
(1), (2), (3), (4), (5), (6), (7), (8);



-- ================================
-- Boats
-- ================================

INSERT INTO br_boat (id, name, isRented, description, price, capacity) VALUES
(1, 'Sea Breeze', false, 'Small sailboat, perfect for beginners.', 100.0, 4),
(2, 'Wave Rider', true, 'Fast motorboat for watersports.', 250.0, 6),
(3, 'Ocean Queen', false, 'Luxury yacht with many rooms.', 1000.0, 12),
(6, 'Storm Breaker', false, 'Speedboat, agile and fast.', 180.0, 5),
(7, 'Sun Chaser', true, 'Pleasure cruiser with sundeck.', 500.0, 10);


-- ================================
-- Sailboats
-- ================================

INSERT INTO br_sailboat (id, sails) VALUES
(1, 2),
(6, 1);



-- ================================
-- Motorboats
-- ================================

INSERT INTO br_motorboat (id, motors, material) VALUES
(2, 2, 'Fiberglass'),
(7, 1, 'Aluminium');



-- ================================
-- Yachts
-- ================================

INSERT INTO br_yacht (id, rooms, extraBoats) VALUES
(3, 5, 1);



-- ================================
-- Extras
-- ================================

INSERT INTO br_extras (id, name, description, price) VALUES
(4, 'Snorkel Set', 'Complete snorkel gear for rent.', 20.0),
(5, 'Life Jackets', 'Life jackets for all ages.', 15.0),
(8, 'Fishing Equipment', 'Fishing rods and bait.', 30.0);



-- ================================
-- Reservations
-- ================================

INSERT INTO br_reservation (id, customer_customer_id, employee_employee_id, startdate, enddate) VALUES
(1, 1, 1, '2025-05-01', '2025-05-05'),
(2, 2, 2, '2025-06-10', '2025-06-15'),
(3, 3, 3, '2025-07-01', '2025-07-04'),
(4, 4, 4, '2025-08-05', '2025-08-10'),
(5, 5, 5, '2025-09-15', '2025-09-20');



-- ================================
-- Leases
-- ================================

INSERT INTO br_lease (id, reservation_id, rentalitems_id) VALUES
(1, 1, 1), -- John leases Sea Breeze
(2, 1, 4), -- John leases Snorkel Set
(3, 2, 2), -- Jane leases Wave Rider
(4, 2, 5), -- Jane leases Life Jackets
(5, 3, 6), -- Emily leases Storm Breaker
(6, 4, 7), -- Michael leases Sun Chaser
(7, 5, 8); -- Olivia leases Fishing Equipment



-- ================================
-- Payments
-- ================================

INSERT INTO br_payment (id, amount, paymentdate, reservation_id) VALUES
 (1, 140.0, '2025-05-01', 1),
 (2, 265.0, '2025-06-10', 2),
 (3, 180.0, '2025-07-01', 3),
 (4, 500.0, '2025-08-05', 4),
 (5, 30.0, '2025-09-15', 5);



-- ================================
-- Sequence Updates
-- ================================

SELECT setval('br_customer_customer_id_seq', (SELECT max(customer_id) FROM br_customer));
SELECT setval('br_employee_employee_id_seq', (SELECT max(employee_id) FROM br_employee));
SELECT setval('br_rentalitems_id_seq', (SELECT max(id) FROM br_rentalitems));
SELECT setval('br_reservation_id_seq', (SELECT max(id) FROM br_reservation));
SELECT setval('br_lease_id_seq', (SELECT max(id) FROM br_lease));
SELECT setval('br_payment_id_seq', (SELECT max(id) FROM br_payment));
