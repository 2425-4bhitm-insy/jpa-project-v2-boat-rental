package htl.leonding.rental.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity(name = "br_yacht")
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

}
