package htl.leonding.rental;

import htl.leonding.rental.entity.Customer;
import htl.leonding.rental.entity.Employee;
import htl.leonding.rental.entity.Reservation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReservationTest {

        static class DummyCustomer extends Customer {
        }

        static class DummyEmployee extends Employee {
        }

        DummyCustomer customer = new DummyCustomer();
        DummyEmployee employee = new DummyEmployee();
        Reservation reservation = new Reservation(customer, employee, LocalDate.of(2025, 5, 1), LocalDate.of(2025, 5, 10));

        @Test
        void testConstructorAndGetters() {
            assertEquals(customer, reservation.getCustomer());
            assertEquals(employee, reservation.getEmployee());
            assertEquals(LocalDate.of(2025, 5, 1), reservation.getStartDate());
            assertEquals(LocalDate.of(2025, 5, 10), reservation.getEndDate());
        }

        @Test
        void testSetCustomer() {
            DummyCustomer newCustomer = new DummyCustomer();
            reservation.setCustomer(newCustomer);
            assertEquals(newCustomer, reservation.getCustomer());
        }

        @Test
        void testSetEmployee() {
            DummyEmployee newEmployee = new DummyEmployee();
            reservation.setEmployee(newEmployee);
            assertEquals(newEmployee, reservation.getEmployee());
        }

        @Test
        void testSetStartDate() {
            LocalDate newStart = LocalDate.of(2025, 6, 1);
            reservation.setStartDate(newStart);
            assertEquals(newStart, reservation.getStartDate());
        }

        @Test
        void testSetEndDate() {
            LocalDate newEnd = LocalDate.of(2025, 6, 15);
            reservation.setEndDate(newEnd);
            assertEquals(newEnd, reservation.getEndDate());
        }
}
