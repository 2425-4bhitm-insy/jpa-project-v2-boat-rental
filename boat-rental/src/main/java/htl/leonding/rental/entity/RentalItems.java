package htl.leonding.rental.entity;

import jakarta.persistence.*;


@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity(name = "br_rentalItems")
public abstract class RentalItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
