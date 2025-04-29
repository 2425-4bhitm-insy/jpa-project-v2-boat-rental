package htl.leonding.rental.entity.dto;

import java.time.LocalDate;

public class RentalDTO {
    private String boatName;
    private String customerName;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean active;

    public RentalDTO(String boatName, String customerName, LocalDate startDate, LocalDate endDate, boolean active) {
        this.boatName = boatName;
        this.customerName = customerName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.active = active;
    }

    public String getBoatName() {
        return boatName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public boolean isActive() {
        return active;
    }
}
