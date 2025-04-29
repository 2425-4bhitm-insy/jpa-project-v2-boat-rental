package htl.leonding.rental.control;

import htl.leonding.rental.entity.Customer;
import htl.leonding.rental.entity.Reservation;
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

public class ReservationRepositoryImplTest {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("testPU");
    EntityManager em = emf.createEntityManager();
    ReservationRepositoryImpl repository = new ReservationRepositoryImpl(em);

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
    void testAddAndGetReservation() {
        Customer customer = new Customer();
        customer.setFirstname("Max");
        customer.setLastname("Mustermann");

        em.persist(customer);

        Reservation reservation = new Reservation();
        reservation.setCustomer(customer);  // Set the customer reference
        reservation.setStartDate(LocalDate.of(2025 ,5 ,5));
        reservation.setEndDate(LocalDate.of(2025, 5, 10));

        repository.add(reservation);
        em.flush();

        Reservation found = repository.getReservation(reservation.getCustomer().getCustomerId());
        assertNotNull(found);
        assertEquals(customer, found.getCustomer());
        assertEquals(reservation.getStartDate(), found.getStartDate());
        assertEquals(reservation.getEndDate(), found.getEndDate());
    }

    @Test
    void testGetAllReservations() {
        List<Reservation> reservations = repository.getAllReservations();
        assertNotNull(reservations);
        assertTrue(reservations.size() > 0);
    }

    @Test
    void testRemoveReservation() {
        Customer customer = new Customer();
        customer.setFirstname("Test");
        customer.setLastname("Customer");

        em.persist(customer);

        Reservation reservation = new Reservation();
        reservation.setCustomer(customer);
        reservation.setStartDate(LocalDate.of(2025 ,5 ,5));
        reservation.setEndDate(LocalDate.of(2025, 5, 10));

        repository.add(reservation);
        em.flush();

        repository.remove(reservation);
        em.flush();

        Reservation found = repository.getReservation(reservation.getCustomer().getCustomerId());
        assertNull(found);
    }
}
