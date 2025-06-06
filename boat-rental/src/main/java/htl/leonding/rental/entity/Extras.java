package htl.leonding.rental.entity;

import jakarta.persistence.*;

@Entity(name = "br_extras")
public class Extras extends RentalItems {

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @Column(nullable = false)
    private double price;

    public Extras() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Extras(String name, String description, double price) {
        setName(name);
        setDescription(description);
        setPrice(price);
    }
}
