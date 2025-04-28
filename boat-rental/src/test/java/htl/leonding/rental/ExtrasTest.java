package htl.leonding.rental;

import htl.leonding.rental.entity.Extras;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExtrasTest {
    Extras extras = new Extras("Life Jacket", "Safety equipment", 15.99);


    @Test
    void testConstructorAndGetters() {
        assertEquals("Life Jacket", extras.getName());
        assertEquals("Safety equipment", extras.getDescription());
        assertEquals(15.99, extras.getPrice());
    }

    @Test
    void testSetName() {
        extras.setName("Anchor");
        assertEquals("Anchor", extras.getName());
    }

    @Test
    void testSetDescription() {
        extras.setDescription("An extra Anchor");
        assertEquals("An extra Anchor", extras.getDescription());
    }

    @Test
    void testSetPrice() {
        extras.setPrice(29.99);
        assertEquals(29.99, extras.getPrice());
    }
}
