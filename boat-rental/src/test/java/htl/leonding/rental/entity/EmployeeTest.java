package htl.leonding.rental.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeTest {
    Employee employee = new Employee("Pia", "Smith", "Admin", "06600000");

    @Test
    void testConstructorAndGetters() {
        assertEquals("Pia", employee.getFirstname());
        assertEquals("Smith", employee.getLastname());
        assertEquals("Admin", employee.getRole());
        assertEquals("06600000", employee.getTelephoneNumber());
    }

    @Test
    void testSetFirstName() {
        employee.setFirstname("Pia");
        assertEquals("Pia", employee.getFirstname());
    }

    @Test
    void testSetLastName() {
        employee.setLastname("Smith");
        assertEquals("Smith", employee.getLastname());
    }


    @Test
    void testSetTelephoneNumber() {
        employee.setTelephoneNumber("06600000");
        assertEquals("06600000", employee.getTelephoneNumber());
    }

    @Test
    void testSetRole(){
        employee.setRole("Admin");
        assertEquals("Admin", employee.getRole());
    }


}
