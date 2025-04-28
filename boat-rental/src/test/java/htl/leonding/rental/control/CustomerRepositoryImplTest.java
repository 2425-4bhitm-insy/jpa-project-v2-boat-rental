package htl.leonding.rental.control;

import htl.leonding.rental.entity.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CustomerRepositoryImplTest {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("testPU");
    EntityManager em = emf.createEntityManager();
    CustomerRepositoryImpl repository = new CustomerRepositoryImpl(em);

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
    void testAddAndGetCustomer() {
        Customer customer = new Customer();
        customer.setFirstname("Max");

        repository.add(customer);
        em.flush(); // wichtig, um persistierte Objekte wirklich in die DB zu schreiben

        Customer found = repository.getCustomer(customer.getCustomerId());
        assertNotNull(found);
        assertEquals("Max", found.getFirstname());
    }
}
