package htl.leonding.rental.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoatTest {

    private TestBoat boat;

    static class TestBoat extends Boat {
        public TestBoat() {
            super();
        }

        public TestBoat(String name, boolean isRented, String description, double price, int capacity) {
            super(name, isRented, description, price, capacity);
        }
    }

    @BeforeEach
    void setUp() {
        boat = new TestBoat("Zar", false, "motorboat for the ocean", 199.99, 5);
    }

    @Test
    void testConstructorAndGetters() {
        assertEquals("Zar", boat.getName());
        assertFalse(boat.isRented());
        assertEquals("motorboat for the ocean", boat.getDescription());
        assertEquals(199.99, boat.getPrice());
        assertEquals(5, boat.getCapacity());
    }

    @Test
    void testSetName() {
        boat.setName("Zarli");
        assertEquals("Zarli", boat.getName());
    }

    @Test
    void testSetRented() {
        boat.setRented(true);
        assertTrue(boat.isRented());
    }

    @Test
    void testSetDescription() {
        boat.setDescription("Zar is a nice boat");
        assertEquals("Zar is a nice boat", boat.getDescription());
    }

    @Test
    void testSetPrice() {
        boat.setPrice(299.99);
        assertEquals(299.99, boat.getPrice());
    }

    @Test
    void testSetCapacity() {
        boat.setCapacity(8);
        assertEquals(8, boat.getCapacity());
    }
}



