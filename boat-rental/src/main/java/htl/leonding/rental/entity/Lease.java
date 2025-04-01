package htl.leonding.rental.entity;

import jakarta.persistence.*;

@Entity(name = "br_lease")
public class Lease {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    Reservation reservation;

    @ManyToOne
    RentalItems rentalItems;

    public Lease() {

    }

    public Lease(Reservation reservation, RentalItems rentalItems) {
        setRentalItems(rentalItems);
        setReservation(reservation);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public RentalItems getRentalItems() {
        return rentalItems;
    }

    public void setRentalItems(RentalItems rentalItems) {
        this.rentalItems = rentalItems;
    }

    //TODO add attributes
}
