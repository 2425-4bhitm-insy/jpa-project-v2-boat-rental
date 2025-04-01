package htl.leonding.rental.entity;

import jakarta.persistence.*;

@Entity
public class Lease {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn
    Reservation reservation;

    @ManyToOne
    @JoinColumn
    RentalItems rentalItems;

    public Lease() {

    }

    public Lease(Reservation reservation, RentalItems rentalItems) {
        this.reservation = reservation;
        this.rentalItems = rentalItems;
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
