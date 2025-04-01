package htl.leonding.rental.entity;

import jakarta.persistence.*;

import java.math.BigInteger;
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity(name = "br_boat")
public abstract class Boat {

    //TODO Add attributes and methodes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "isRented")
    private Boolean isRented;

    public long getId() {
        return id;
    }

//    public void setId(long id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getRented() {
        return isRented;
    }

    public void setRented(Boolean rented) {
        isRented = rented;
    }

    public Boat() {}

    public Boat(String name, Boolean isRented) {
        setName(name);
        setRented(isRented);

    }
}
