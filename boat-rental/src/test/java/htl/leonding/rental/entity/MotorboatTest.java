package htl.leonding.rental.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MotorboatTest {
    Motorboat motorboat = new Motorboat("Zar", false, "Nice boat", 300.0, 4, 2, "Gummi");;

    @Test
    void testConstructorAndGetters() {
        assertEquals("Zar", motorboat.getName());
        assertFalse(motorboat.isRented());
        assertEquals("Nice boat", motorboat.getDescription());
        assertEquals(300.0, motorboat.getPrice());
        assertEquals(4, motorboat.getCapacity());
        assertEquals(2, motorboat.getMotors());
        assertEquals("Gummi", motorboat.getMaterial());
    }

    @Test
    void testSetMotors() {
        motorboat.setMotors(1);
        assertEquals(1, motorboat.getMotors());
    }

    @Test
    void testSetMaterial() {
        motorboat.setMaterial("Hartschale");
        assertEquals("Hartschale", motorboat.getMaterial());
    }

    @Test
    void testSetName() {
        motorboat.setName("Quicksilver");
        assertEquals("Quicksilver", motorboat.getName());
    }

    @Test
    void testSetRented() {
        motorboat.setRented(true);
        assertTrue(motorboat.isRented());
    }

    @Test
    void testSetDescription() {
        motorboat.setDescription("Good for a long journey");
        assertEquals("Good for a long journey", motorboat.getDescription());
    }

    @Test
    void testSetPrice() {
        motorboat.setPrice(450.5);
        assertEquals(450.5, motorboat.getPrice());
    }

    @Test
    void testSetCapacity() {
        motorboat.setCapacity(6);
        assertEquals(6, motorboat.getCapacity());
    }

}
