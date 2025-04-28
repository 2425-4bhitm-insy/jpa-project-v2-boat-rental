package htl.leonding.rental.entity;

import org.junit.jupiter.api.Test;

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

    @Test
    void testSetFirstName() {
        customer.setFirstname("Alma");
        assertEquals("Alma", customer.getFirstname());
    }

    @Test
    void testSetLastName() {
        customer.setLastname("Baumann");
        assertEquals("Baumann", customer.getLastname());
    }

    @Test
    void testSetAddress() {
        customer.setAddress("Baustrasse");
        assertEquals("Baustrasse", customer.getAddress());
    }

    @Test
    void testSetTelephoneNumber() {
        customer.setTelephoneNumber("066011111");
        assertEquals("066011111", customer.getTelephoneNumber());
    }

    @Test
    void testSetEmail() {
        customer.setAddress("Alma.Baumann@gmail.com");
        assertEquals("Alma.Baumann@gmail.com", customer.getAddress());
    }

}


