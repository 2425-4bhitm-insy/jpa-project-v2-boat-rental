package htl.leonding.rental;

import htl.leonding.rental.entity.Yacht;
import org.junit.jupiter.api.Test;

import static io.smallrye.common.constraint.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class YachtTest {
       Yacht yacht = new Yacht("Cruiser", false, "A luxurious yacht", 1000.0, 10, 5, 2);

        @Test
        void testConstructorAndGetters() {
            assertEquals("Cruiser", yacht.getName());
            assertFalse(yacht.isRented());
            assertEquals("A luxurious yacht", yacht.getDescription());
            assertEquals(1000.0, yacht.getPrice());
            assertEquals(10, yacht.getCapacity());
            assertEquals(5, yacht.getRooms());
            assertEquals(2, yacht.getExtraBoats());
        }

        @Test
        void testSetRooms() {
            yacht.setRooms(6);
            assertEquals(6, yacht.getRooms());
        }

        @Test
        void testSetExtraBoats() {
            yacht.setExtraBoats(3);
            assertEquals(3, yacht.getExtraBoats());
        }

        @Test
        void testSetName() {
            yacht.setName("Top Cruiser");
            assertEquals("Top Cruiser", yacht.getName());
        }

        @Test
        void testSetRented() {
            yacht.setRented(true);
            assertTrue(yacht.isRented());
        }

        @Test
        void testSetDescription() {
            yacht.setDescription("A new luxurious yacht");
            assertEquals("A new luxurious yacht", yacht.getDescription());
        }

        @Test
        void testSetPrice() {
            yacht.setPrice(1200.0);
            assertEquals(1200.0, yacht.getPrice());
        }

        @Test
        void testSetCapacity() {
            yacht.setCapacity(12);
            assertEquals(12, yacht.getCapacity());
        }
    }
