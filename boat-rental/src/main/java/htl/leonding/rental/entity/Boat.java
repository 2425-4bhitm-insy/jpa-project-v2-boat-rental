package htl.leonding.rental.entity;

import jakarta.persistence.*;

@Entity(name = "br_boat")
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Boat extends RentalItems {

    @Column(nullable = false)
    private String name;

    @Column
    private boolean isRented;

    @Column
    private String description;

    @Column
    private double price;

    @Column
    private int capacity;

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

    public Boat() {}

    public Boat(String name, boolean isRented, String description, double price, int capacity) {
        this.name = name;
        this.isRented = isRented;
        this.description = description;
        this.price = price;
        this.capacity = capacity;
    }
}
