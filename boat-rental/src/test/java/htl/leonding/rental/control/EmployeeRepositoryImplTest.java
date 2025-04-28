package htl.leonding.rental.control;

import htl.leonding.rental.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EmployeeRepositoryImplTest {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("testPU");
    EntityManager em = emf.createEntityManager();
    EmployeeRepositoryImpl repository = new EmployeeRepositoryImpl(em);

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
    void testAddAndGetEmployee() {
        Employee employee = new Employee();
        employee.setFirstname("Anna");

        repository.add(employee);
        em.flush();

        Employee found = repository.getEmployee(employee.getEmployeeId());
        assertNotNull(found);
        assertEquals("Anna", found.getFirstname());
    }
}
