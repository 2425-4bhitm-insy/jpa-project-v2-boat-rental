package htl.leonding.rental.control;

import htl.leonding.rental.entity.Boat;
import htl.leonding.rental.entity.Yacht;
import htl.leonding.rental.entity.dto.BoatDTO;
import htl.leonding.rental.entity.dto.RentalDTO;
import htl.leonding.rental.entity.dto.TopBoatDTO;

import java.time.LocalDate;
import java.util.List;

import java.util.Map;

public interface BoatRepository {
    void add(Boat boat);
    void remove(Boat boat);
    Boat getBoat(Long boatId);
    List<Boat> getAllBoats();
    List<Yacht> getAllYachts();
    void update(Boat boat);
    List<Boat> getAvailableBoatsBetweenDates(LocalDate startDate, LocalDate endDate);
    List<RentalDTO> getAllBoatRentals();
    List<TopBoatDTO> getTopRevenueBoats();
}
