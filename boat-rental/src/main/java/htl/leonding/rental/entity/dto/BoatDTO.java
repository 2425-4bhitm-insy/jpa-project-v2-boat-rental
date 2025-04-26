package htl.leonding.rental.entity.dto;

public record BoatDTO(
        String name,
        boolean isRented,
        String description,
        double price,
        int capacity
) {
}
