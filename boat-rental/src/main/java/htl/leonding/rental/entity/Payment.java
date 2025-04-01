package htl.leonding.rental.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Payment {

    @ManyToOne
    @JoinColumn
    Reservation reservation;

    @Column (name = "amount")
    private double amount;

    @Column(name = "paymentDate")
    private LocalDate paymentDate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Payment() {

    }

    public Payment(LocalDate paymentDate, double amount, Reservation reservation) {
        setAmount(amount);
        setPaymentDate(paymentDate);
        setReservation(reservation);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }



    //TODO add methodes
}
