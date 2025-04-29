package htl.leonding.rental.entity.dto;

public class CustomerDTO {
    private String firstname;
    private String lastname;
    private String email;
    private long reservationCount;

    public CustomerDTO(String firstname, String lastname, String email, long reservationCount) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.reservationCount = reservationCount;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public long getReservationCount() {
        return reservationCount;
    }
}
