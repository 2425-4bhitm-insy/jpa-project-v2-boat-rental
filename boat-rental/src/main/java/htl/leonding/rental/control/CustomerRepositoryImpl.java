package htl.leonding.rental.control;

import htl.leonding.rental.entity.Customer;
import htl.leonding.rental.entity.dto.CustomerDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;

import java.util.List;

@ApplicationScoped
public class CustomerRepositoryImpl implements CustomerRepository {

    private final EntityManager entityManager;

    public CustomerRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void add(Customer customer) {
        entityManager.persist(customer);
    }

    @Override
    public void remove(Customer customer) {
        if (entityManager.contains(customer)) {
            entityManager.remove(customer);
        }
    }

    @Override
    public Customer getCustomer(Long customerId) {
        return entityManager.find(Customer.class, customerId);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return entityManager.createQuery("select c from br_customer c", Customer.class).getResultList();
    }

    public List<CustomerDTO> getCustomersWithMultipleRentals() {
        return entityManager.createQuery(
                        "SELECT new htl.leonding.rental.entity.dto.CustomerDTO(c.firstname, c.lastname, c.email, COUNT(l.rentalItems.id)) " +
                                "FROM br_customer c " +
                                "JOIN br_reservation r ON c.id = r.customer.id " +
                                "JOIN br_lease l ON r.id = l.reservation.id " +
                                "GROUP BY c.id, c.firstname, c.lastname " +
                                "HAVING COUNT(l.rentalItems.id) > 1 " +
                                "ORDER BY COUNT(l.rentalItems.id) desc", CustomerDTO.class)
                .getResultList();
    }
}
