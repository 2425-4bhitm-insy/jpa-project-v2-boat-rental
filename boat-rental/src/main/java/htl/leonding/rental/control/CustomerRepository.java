package htl.leonding.rental.control;
import htl.leonding.rental.entity.Customer;

public interface CustomerRepository {
    void add(Customer customer);
    Customer getCustomer(Long customerId);
}
