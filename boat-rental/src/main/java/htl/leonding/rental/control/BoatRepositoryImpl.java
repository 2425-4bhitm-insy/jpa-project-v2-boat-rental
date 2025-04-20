package htl.leonding.rental.control;

import htl.leonding.rental.entity.Boat;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;

@ApplicationScoped
public class BoatRepositoryImpl implements BoatRepository {

    private final EntityManager entityManager;

    public BoatRepositoryImpl(EntityManager entityManager) {this.entityManager = entityManager;}

    @Override
    public void add(Boat boat) {
        entityManager.persist(boat);
    }

    @Override
    public Boat getBoat(Long boatId) {
        return entityManager.find(Boat.class, boatId);
    }
}
