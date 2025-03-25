package htl.leonding.rental.entity;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity(name = "br_boat")
public class Boat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @Column(name = "name")
    private String name;

    @Column(name = "type_id")
    private BigInteger typeId;

    @Column(name = "isRented")
    private Boolean isRented;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getTypeId() {
        return typeId;
    }

    public void setTypeId(BigInteger typeId) {
        this.typeId = typeId;
    }

    public Boolean getRented() {
        return isRented;
    }

    public void setRented(Boolean rented) {
        isRented = rented;
    }

    public Boat() {}

    public Boat(String name, BigInteger typeId, Boolean isRented) {
        this.name = name;
        this.typeId = typeId;
        this.isRented = isRented;
    }
}
