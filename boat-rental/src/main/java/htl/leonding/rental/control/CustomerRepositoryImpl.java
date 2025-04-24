package htl.leonding.rental.control;

import htl.leonding.rental.entity.Customer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;

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
    public Customer getCustomer(Long customerId) {
        return entityManager.find(Customer.class, customerId);
    }
}
