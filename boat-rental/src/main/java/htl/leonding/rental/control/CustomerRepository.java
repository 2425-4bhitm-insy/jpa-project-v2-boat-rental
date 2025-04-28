package htl.leonding.rental.control;
import htl.leonding.rental.entity.Customer;
import java.util.List;

public interface CustomerRepository {
    void add(Customer customer);
    void remove(Customer customer);
    Customer getCustomer(Long customerId);
    List<Customer> getAllCustomers();
}
