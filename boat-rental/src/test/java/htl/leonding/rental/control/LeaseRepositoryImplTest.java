package htl.leonding.rental.control;

import htl.leonding.rental.entity.Lease;
import htl.leonding.rental.entity.RentalItems;
import htl.leonding.rental.entity.Reservation;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LeaseRepositoryImplTest {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("testPU");
    EntityManager em;
    LeaseRepositoryImpl repository;

    // Concrete subclass for testing
    static class RentalItemTestImpl extends RentalItems {
        @Override
        public String toString() {
            return "RentalItemTestImpl{}";
        }
    }

    @BeforeEach
    void setUp() {
        em = emf.createEntityManager();
        repository = new LeaseRepositoryImpl(em);
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
    void testAddAndGetLease() {

        Reservation reservation = new Reservation();
        RentalItems rentalItems = new RentalItemTestImpl();


        Lease lease = new Lease(reservation, rentalItems);
        repository.add(lease);
        em.flush();


        Lease found = repository.getLease(lease.getId());
        assertNotNull(found);
        assertEquals(reservation, found.getReservation());
        assertEquals(rentalItems, found.getRentalItems());
    }

    @Test
    void testGetAllLeases() {
        List<Lease> leases = repository.getAllLeases();
        assertNotNull(leases);
        assertTrue(leases.size() > 0);
    }

    @Test
    void testRemoveLease() {
        Lease lease = new Lease(new Reservation(), new RentalItemTestImpl());
        repository.add(lease);
        em.flush();

        repository.remove(lease);
        em.flush();

        Lease found = repository.getLease(lease.getId());
        assertNull(found);
    }
}
