package htl.leonding.rental.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeaseTest {

    // Dummy-Klassen für Testzwecke
    static class DummyReservation extends Reservation {
    }

    static class DummyRentalItem extends RentalItems {
    }

    DummyReservation reservation = new DummyReservation();
    DummyRentalItem rentalItem = new DummyRentalItem();
    Lease lease = new Lease(reservation, rentalItem);

    @Test
    void testConstructorAndGetters() {
        assertEquals(reservation, lease.getReservation());
        assertEquals(rentalItem, lease.getRentalItems());
    }

    @Test
    void testSetReservation() {
        DummyReservation newReservation = new DummyReservation();
        lease.setReservation(newReservation);
        assertEquals(newReservation, lease.getReservation());
    }

    @Test
    void testSetRentalItems() {
        DummyRentalItem newRentalItem = new DummyRentalItem();
        lease.setRentalItems(newRentalItem);
        assertEquals(newRentalItem, lease.getRentalItems());
    }


}

