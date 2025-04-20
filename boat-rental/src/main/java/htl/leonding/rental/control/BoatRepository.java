package htl.leonding.rental.control;

import htl.leonding.rental.entity.Boat;

import java.util.Map;

public interface BoatRepository {
    void add(Boat boat);
    Boat getBoat(Long boatId);
}