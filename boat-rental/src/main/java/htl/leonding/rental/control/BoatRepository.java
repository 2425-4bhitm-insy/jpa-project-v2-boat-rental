package htl.leonding.rental.control;

import htl.leonding.rental.entity.Boat;
import java.util.List;

import java.util.Map;

public interface BoatRepository {
    void add(Boat boat);
    void remove(Boat boat);
    Boat getBoat(Long boatId);
    List<Boat> getAllBoats();
}