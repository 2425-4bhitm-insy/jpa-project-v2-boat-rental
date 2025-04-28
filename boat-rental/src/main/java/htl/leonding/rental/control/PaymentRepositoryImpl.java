package htl.leonding.rental.control;

import htl.leonding.rental.entity.Payment;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;

import java.util.List;

@ApplicationScoped
public class PaymentRepositoryImpl implements PaymentRepository {

    private final EntityManager entityManager;

    public PaymentRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void add(Payment payment) {
        entityManager.persist(payment);
    }

    @Override
    public void remove(Payment payment) {
        entityManager.remove(entityManager.contains(payment) ? payment : entityManager.merge(payment));
    }

    @Override
    public Payment getPayment(Long paymentId) {
        return entityManager.find(Payment.class, paymentId);
    }

    @Override
    public List<Payment> getAllPayments() {
        return entityManager.createQuery("SELECT p FROM br_payment p", Payment.class).getResultList();
    }
}
