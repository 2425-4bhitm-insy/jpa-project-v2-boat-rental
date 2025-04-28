package htl.leonding.rental.control;

import htl.leonding.rental.entity.Boat;
import htl.leonding.rental.entity.Motorboat;
import htl.leonding.rental.entity.Sailboat;
import htl.leonding.rental.entity.Yacht;

import java.util.List;

import java.util.Map;

public interface BoatRepository {
    void add(Boat boat);
    void remove(Boat boat);
    Boat getBoat(Long boatId);
    List<Boat> getAllBoats();
    List<Yacht> getAllYachts();
    List<Motorboat> getAllMotorboats();
    List<Sailboat> getAllSailBoats();
}