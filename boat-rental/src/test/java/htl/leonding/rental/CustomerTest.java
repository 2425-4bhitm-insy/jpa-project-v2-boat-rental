package htl.leonding.rental;

import htl.leonding.rental.entity.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {

    Customer customer = new Customer("Nia", "Mayer", "Mauerstrasse", "0660121212", "Nia.mayer@gmail.com");

    @Test
    void testConstructorAndGetters() {
        assertEquals("Nia", customer.getFirstname());
        assertEquals("Mayer", customer.getLastname());
        assertEquals("Mauerstrasse", customer.getAddress());
        assertEquals("0660121212", customer.getTelephoneNumber());
        assertEquals("Nia.mayer@gmail.com", customer.getEmail());
    }


}
