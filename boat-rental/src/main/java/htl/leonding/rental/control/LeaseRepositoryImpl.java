package htl.leonding.rental.control;

import htl.leonding.rental.entity.Lease;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;

@ApplicationScoped
public class LeaseRepositoryImpl implements LeaseRepository {

    @Inject EntityManager entityManager;

    public LeaseRepositoryImpl(EntityManager em) {
    }

    @Override
    public void add(Lease lease) {
        entityManager.persist(lease);
    }

    @Override
    public void remove(Lease lease) {
        entityManager.remove(entityManager.contains(lease) ? lease : entityManager.merge(lease));
    }

    @Override
    public Lease getLease(Long leaseId) {
        return entityManager.find(Lease.class, leaseId);
    }

    @Override
    public List<Lease> getAllLeases() {
        return entityManager.createQuery("SELECT l FROM br_lease l", Lease.class).getResultList();
    }
}
