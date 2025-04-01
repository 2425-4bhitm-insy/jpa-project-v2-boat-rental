package htl.leonding.rental.entity;

import jakarta.persistence.*;

@Entity(name = "br_employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employee_id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "role")
    private String role;

    @Column(name = "telephoneNumber")
    private String telephoneNumber;

    public Employee() {

    }

    public long getEmployeeId() {
        return employee_id;
    }

    public long getEmplyeeId() {
        return employee_id;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public Employee(String firstname, String lastname, String role, String telephoneNumber) {
        setFirstname(firstname);
        setLastname(lastname);
        setRole(role);
        setTelephoneNumber(telephoneNumber);
    }
}
