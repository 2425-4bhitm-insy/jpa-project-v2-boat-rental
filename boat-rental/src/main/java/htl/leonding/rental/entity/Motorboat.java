package htl.leonding.rental.entity;

import jakarta.persistence.*;

@Entity(name = "br_motorboat")
@DiscriminatorValue("Motorboat")
public class Motorboat extends Boat {

    @Column(name = "motors")
    private int motors;

    @Column(name = "material")
    private String material;

    public int getMotors() {
        return motors;
    }

    public void setMotors(int motors) {
        this.motors = motors;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Motorboat(String name, boolean isRented, String description, double price, int capacity,
                    int motors, String material) {
        super(name, isRented, description, price, capacity);
        this.motors = motors;
        this.material = material;
    }

    public Motorboat() {}
}
