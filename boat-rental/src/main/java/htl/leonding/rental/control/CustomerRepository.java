package htl.leonding.rental.control;
import htl.leonding.rental.entity.Customer;
import htl.leonding.rental.entity.dto.CustomerDTO;

import java.util.List;

public interface CustomerRepository {
    void add(Customer customer);
    Customer getCustomer(Long customerId);
    List<CustomerDTO> getCustomersWithMultipleRentals();
}
