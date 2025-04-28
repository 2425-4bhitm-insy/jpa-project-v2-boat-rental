package htl.leonding.rental.control;
import htl.leonding.rental.entity.Reservation;
import java.util.List;

public interface ReservationRepository {
    void add(Reservation reservation);
    void remove(Reservation reservation);
    Reservation getReservation(Long reservationId);
    List<Reservation> getAllReservations();
}