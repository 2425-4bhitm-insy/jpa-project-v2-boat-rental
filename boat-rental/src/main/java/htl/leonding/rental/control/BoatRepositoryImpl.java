package htl.leonding.rental.control;

import htl.leonding.rental.entity.*;
import htl.leonding.rental.entity.dto.BoatDTO;
import htl.leonding.rental.entity.dto.RentalDTO;
import htl.leonding.rental.entity.dto.TopBoatDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.time.LocalDate;
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
        List<Lease> leases = entityManager.createQuery(
                        "SELECT l FROM br_lease l WHERE l.rentalItems.id = :boatId", Lease.class)
                .setParameter("boatId", boat.getId())
                .getResultList();

        for (Lease lease : leases) {
            Reservation reservation = lease.getReservation();

            entityManager.remove(lease);

            Long count = entityManager.createQuery(
                            "SELECT COUNT(l) FROM br_lease l WHERE l.reservation.id = :reservationId", Long.class)
                    .setParameter("reservationId", reservation.getId())
                    .getSingleResult();

            if (count == 0) {
                entityManager.remove(reservation);
            }
        }

        Boat managedBoat = entityManager.find(Boat.class, boat.getId());
        if (managedBoat != null) {
            entityManager.remove(managedBoat);
        }
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

    @Override
    public void update(Boat boat) {
        entityManager.merge(boat);
    }

    public List<Boat> getAvailableBoatsBetweenDates(LocalDate startDate, LocalDate endDate) {
        return entityManager.createQuery(
                        "SELECT b FROM br_boat b " +
                                "WHERE b.id NOT IN (" +
                                "    SELECT l.rentalItems.id FROM br_lease l " +
                                "    WHERE l.reservation.startDate <= :endDate " +
                                "      AND l.reservation.endDate >= :startDate" +
                                ")", Boat.class)
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate)
                .getResultList();
    }

    public List<RentalDTO> getAllBoatRentals() {
        return entityManager.createQuery(
                "SELECT new htl.leonding.rental.entity.dto.RentalDTO( " +
                        "b.id, " +
                        "b.name, " +
                        "COALESCE(CONCAT(c.firstname, ' ', c.lastname), '---'), " +
                        "COALESCE(r.startDate, NULL), " +
                        "COALESCE(r.endDate, NULL), " +
                        "CASE WHEN r.startDate <= CURRENT_DATE AND r.endDate >= CURRENT_DATE THEN true ELSE false END " +
                        ") " +
                        "FROM br_boat b " +
                        "LEFT JOIN br_lease l ON b.id = l.rentalItems.id " +
                        "LEFT JOIN l.reservation r " +
                        "LEFT JOIN r.customer c",
                RentalDTO.class
        ).getResultList();
    }

    public List<TopBoatDTO> getTopRevenueBoats() {
        return entityManager.createQuery(
                "SELECT new htl.leonding.rental.entity.dto.TopBoatDTO(b.name, 'Sailboat', SUM(b.price)) " +
                        "FROM br_boat b " +
                        "JOIN br_lease l ON b.id = l.rentalItems.id " +
                        "GROUP BY b.id, b.name, 'Sailboat' " +
                        "ORDER BY SUM(b.price) DESC",
                TopBoatDTO.class
        ).getResultList();
    }

}
