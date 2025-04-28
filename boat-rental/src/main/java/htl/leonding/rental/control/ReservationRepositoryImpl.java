package htl.leonding.rental.control;

import htl.leonding.rental.entity.Reservation;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;

import java.util.List;

@ApplicationScoped
public class ReservationRepositoryImpl implements ReservationRepository {

    private final EntityManager entityManager;

    public ReservationRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void add(Reservation reservation) {
        entityManager.persist(reservation);
    }

    @Override
    public void remove(Reservation reservation) {
        entityManager.remove(entityManager.contains(reservation) ? reservation : entityManager.merge(reservation));
    }

    @Override
    public Reservation getReservation(Long reservationId) {
        return entityManager.find(Reservation.class, reservationId);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return entityManager.createQuery("SELECT r FROM br_reservation r", Reservation.class).getResultList();
    }
}
