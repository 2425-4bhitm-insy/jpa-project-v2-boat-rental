package htl.leonding.rental.entity;

import jakarta.persistence.*;

import java.math.BigInteger;
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity(name = "br_boat")
public abstract class Boat {

    //TODO Add attributes and methodes to class Boat
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long boat_id;

    @Column(name = "name")
    private String name;

    @Column(name = "isRented")
    private boolean isRented;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @Column(name = "capacity")
    private int capacity;

    public long getBoat_id() {
        return boat_id;
    }

//    public void setBoat_id(long boat_id) {
//        this.boat_id = boat_id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Boat(){}

    public Boat(String name, boolean isRented, String description, double price, int capacity) {
        setName(name);
        setRented(isRented);
        setDescription(description);
        setPrice(price);
        setCapacity(capacity);
    }
}
