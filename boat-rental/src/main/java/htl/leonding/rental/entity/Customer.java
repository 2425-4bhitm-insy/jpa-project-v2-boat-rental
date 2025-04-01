package htl.leonding.rental.entity;

import jakarta.persistence.*;

@Entity(name = "br_customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long customer_id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "address")
    private String address;

    @Column(name = "telephoneNumber")
    private String telephoneNumber;

    @Column(name = "email")
    private String email;

    public Customer() {

    }

    public long getCustomerId() {
        return customer_id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Customer(String firstname, String lastname, String address, String telephoneNumber, String email) {
        setFirstname(firstname);
        setLastname(lastname);
        setAddress(address);
        setTelephoneNumber(telephoneNumber);
        setEmail(email);
    }
}
