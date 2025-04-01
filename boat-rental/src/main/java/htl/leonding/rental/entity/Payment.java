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
    private Long id;

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

    //TODO add methodes
}
