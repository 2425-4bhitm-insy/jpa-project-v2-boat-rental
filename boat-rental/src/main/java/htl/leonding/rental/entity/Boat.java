package htl.leonding.rental.entity;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;

@Entity(name = "br_boat")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXTERNAL_PROPERTY, property = "boatType")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Sailboat.class, name = "sailboat"),
        @JsonSubTypes.Type(value = Motorboat.class, name = "motorboat"),
        @JsonSubTypes.Type(value = Yacht.class, name = "yacht")
})
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
