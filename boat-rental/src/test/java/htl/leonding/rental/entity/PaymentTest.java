package htl.leonding.rental.entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaymentTest {

    static class DummyReservation extends Reservation {
    }

    DummyReservation reservation = new DummyReservation();
    Payment payment = new Payment(LocalDate.of(2025, 4, 15), 99.99, reservation);


    @Test
    void testConstructorAndGetters() {
        assertEquals(LocalDate.of(2025, 4, 15), payment.getPaymentDate());
        assertEquals(99.99, payment.getAmount());
        assertEquals(reservation, payment.getReservation());
    }

    @Test
    void testSetPaymentDate() {
        LocalDate date = LocalDate.of(2025, 5, 1);
        payment.setPaymentDate(date);
        assertEquals(date, payment.getPaymentDate());
    }

    @Test
    void testSetAmount() {
        payment.setAmount(120.50);
        assertEquals(120.50, payment.getAmount());
    }

    @Test
    void testSetReservation() {
        DummyReservation newReservation = new DummyReservation();
        payment.setReservation(newReservation);
        assertEquals(newReservation, payment.getReservation());
    }

}

