package htl.leonding.rental.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity(name = "br_motorboat")
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
}
