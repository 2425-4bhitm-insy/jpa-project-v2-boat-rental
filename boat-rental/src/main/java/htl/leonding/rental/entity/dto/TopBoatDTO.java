package htl.leonding.rental.entity.dto;

public class TopBoatDTO {
    private String name;
    private String boatType;
    private double totalRevenue;

    public TopBoatDTO(String name, String boatType, double totalRevenue) {
        this.name = name;
        this.boatType = boatType;
        this.totalRevenue = totalRevenue;
    }

    public String getName() {
        return name;
    }

    public String getBoatType() {
        return boatType;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }
}
