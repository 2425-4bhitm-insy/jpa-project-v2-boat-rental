package htl.leonding.rental.control;

import htl.leonding.rental.entity.Boat;
import htl.leonding.rental.entity.Yacht;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;

import java.util.List;

@ApplicationScoped
public class BoatRepositoryImpl implements BoatRepository {

    private final EntityManager entityManager;

    public BoatRepositoryImpl(EntityManager entityManager) {this.entityManager = entityManager;}

    @Override
    public void add(Boat boat) {
        entityManager.persist(boat);
    }

    @Override
    public void remove(Boat boat) {
        entityManager.remove(boat);
    }

    @Override
    public Boat getBoat(Long boatId) {
        return entityManager.find(Boat.class, boatId);
    }

    @Override
    public List<Boat> getAllBoats() {
        return entityManager.createQuery("select b from br_boat b", Boat.class).getResultList();
    }

    @Override
    public List<Yacht> getAllYachts() {
        return entityManager.createQuery("select b from br_yacht b", Yacht.class).getResultList();
    }
}
