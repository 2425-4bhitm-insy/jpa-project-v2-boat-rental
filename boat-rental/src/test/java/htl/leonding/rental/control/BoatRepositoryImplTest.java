package htl.leonding.rental.control;

import htl.leonding.rental.entity.Yacht;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BoatRepositoryImplTest {

        static EntityManagerFactory emf = Persistence.createEntityManagerFactory("testPU");
        EntityManager em = emf.createEntityManager();
        BoatRepositoryImpl repository = new BoatRepositoryImpl(em);

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
        static void tearDownClass() {
            emf.close();
        }

        @Test
        void testAddAndGetBoat() {
            Yacht yacht = new Yacht("TestYacht", false, "A test yacht", 1000, 5, 3, 1);
            repository.add(yacht);
            em.flush(); // ensure it’s written
            em.clear(); // detach to force reload

            Yacht found = (Yacht) repository.getBoat(yacht.getId());
            assertNotNull(found);
            assertEquals("TestYacht", found.getName());
        }

        @Test
        void testGetAllYachts() {
            Yacht yacht1 = new Yacht("Y1", false, "Yacht 1", 900, 5, 2, 0);
            Yacht yacht2 = new Yacht("Y2", false, "Yacht 2", 1100, 6, 3, 1);
            repository.add(yacht1);
            repository.add(yacht2);
            em.flush();
            em.clear();

            List<Yacht> yachts = repository.getAllYachts();
            assertEquals(2, yachts.size());
        }
    }

