package htl.leonding.rental.control;

import htl.leonding.rental.entity.Payment;

import java.util.List;

public interface PaymentRepository {
    void add(Payment payment);
    void remove(Payment payment);
    Payment getPayment(Long paymentId);
    List<Payment> getAllPayments();
}