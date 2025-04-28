package htl.leonding.rental;

import htl.leonding.rental.entity.Sailboat;
import org.junit.jupiter.api.Test;
import htl.leonding.rental.entity.SailboatType;

import static org.junit.jupiter.api.Assertions.*;

public class SailBoatTest {
    Sailboat sailboat = new Sailboat("Katamoran", false, "A Katamoran", 500.0, 6, 3, SailboatType.Catamaran);

    @Test
    void testConstructorAndGetters() {
        assertEquals("Katamoran", sailboat.getName());
        assertFalse(sailboat.isRented());
        assertEquals("A Katamoran", sailboat.getDescription());
        assertEquals(500.0, sailboat.getPrice());
        assertEquals(6, sailboat.getCapacity());
        assertEquals(3, sailboat.getSails());
        assertEquals(SailboatType.Catamaran, sailboat.getSailboatType());
    }

    @Test
    void testSetSails() {
        sailboat.setSails(4);
        assertEquals(4, sailboat.getSails());
    }

    @Test
    void testSetSailboatType() {
        sailboat.setSailboatType(SailboatType.Cutter);
        assertEquals(SailboatType.Cutter, sailboat.getSailboatType());
    }

    @Test
    void testSetName() {
        sailboat.setName("Saili");
        assertEquals("Saili", sailboat.getName());
    }

    @Test
    void testSetRented() {
        sailboat.setRented(true);
        assertTrue(sailboat.isRented());
    }

    @Test
    void testSetDescription() {
        sailboat.setDescription("A standard sailboat");
        assertEquals("A standard sailboat", sailboat.getDescription());
    }

    @Test
    void testSetPrice() {
        sailboat.setPrice(600.0);
        assertEquals(600.0, sailboat.getPrice());
    }

    @Test
    void testSetCapacity() {
        sailboat.setCapacity(8);
        assertEquals(8, sailboat.getCapacity());
    }

}
