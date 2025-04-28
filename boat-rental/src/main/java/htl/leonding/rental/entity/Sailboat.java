package htl.leonding.rental.entity;

import jakarta.persistence.*;

@Entity(name = "br_sailboat")
@DiscriminatorValue("Sailboat")
public class Sailboat extends Boat {

    @Column(name = "sails")
    private int sails;

    @Column(name = "sailboatType")
    private SailboatType sailboatType;

    public int getSails() {
        return sails;
    }

    public void setSails(int sails) {
        this.sails = sails;
    }

    public SailboatType getSailboatType() {
        return sailboatType;
    }

    public void setSailboatType(SailboatType sailboatType) {
        this.sailboatType = sailboatType;
    }

    public Sailboat(String name, boolean isRented, String description, double price, int capacity,
                 int sails, SailboatType sailboatType) {
        super(name, isRented, description, price, capacity);
        this.sails = sails;
        this.sailboatType = sailboatType;
    }

    public Sailboat() {}
}
