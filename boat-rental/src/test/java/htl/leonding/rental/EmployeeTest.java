package htl.leonding.rental;

import htl.leonding.rental.entity.Customer;
import htl.leonding.rental.entity.Employee;
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


}
