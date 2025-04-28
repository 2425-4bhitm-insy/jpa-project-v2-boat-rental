package htl.leonding.rental.entity;

import jakarta.persistence.*;

@Entity(name = "br_yacht")
@DiscriminatorValue("Yacht")
public class Yacht extends Boat {

    @Column(name = "rooms")
    private int rooms;

    @Column(name = "extraBoats")
    private int extraBoats;

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getExtraBoats() {
        return extraBoats;
    }

    public void setExtraBoats(int extraBoats) {
        this.extraBoats = extraBoats;
    }

    public Yacht(String name, boolean isRented, String description, double price, int capacity,
                 int rooms, int extraBoats) {
        super(name, isRented, description, price, capacity);
        this.rooms = rooms;
        this.extraBoats = extraBoats;
    }

    public Yacht() {}
}
