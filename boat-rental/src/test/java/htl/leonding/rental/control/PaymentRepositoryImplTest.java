package htl.leonding.rental.control;

import htl.leonding.rental.entity.Payment;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentRepositoryImplTest {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("testPU");
    EntityManager em = emf.createEntityManager();
    PaymentRepositoryImpl repository = new PaymentRepositoryImpl(em);

    @BeforeEach
    void setUp() {
        em.getTransaction().begin();
    }

    @AfterEach
    void tearDown() {
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
        em.close();
    }

    @AfterAll
    static void close() {
        emf.close();
    }

    @Test
    void testAddAndGetPayment() {
        Payment payment = new Payment();
        payment.setAmount(100.0);
        payment.setPaymentDate(LocalDate.of(2025, 5, 5));

        repository.add(payment);
        em.flush();

        Payment found = repository.getPayment(payment.getId());
        assertNotNull(found);
        assertEquals(payment.getAmount(), found.getAmount());
        assertEquals(payment.getPaymentDate(), found.getPaymentDate());
    }

    @Test
    void testGetAllPayments() {
        List<Payment> payments = repository.getAllPayments();
        assertNotNull(payments);
        assertTrue(!payments.isEmpty());
    }

    @Test
    void testRemovePayment() {
        Payment payment = new Payment();
        payment.setAmount(50.0);
        payment.setPaymentDate(LocalDate.of(2025,4,4));

        repository.add(payment);
        em.flush();

        repository.remove(payment);
        em.flush();

        Payment found = repository.getPayment(payment.getId());
        assertNull(found);
    }
}
