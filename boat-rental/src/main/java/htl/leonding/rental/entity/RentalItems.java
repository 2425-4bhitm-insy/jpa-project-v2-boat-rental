package htl.leonding.rental.entity;

import jakarta.persistence.*;

@Entity(name = "br_rentalitems")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class RentalItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }
}
