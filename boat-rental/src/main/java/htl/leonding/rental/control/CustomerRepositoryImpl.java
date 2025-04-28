package htl.leonding.rental.control;

import htl.leonding.rental.entity.Customer;
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
}
