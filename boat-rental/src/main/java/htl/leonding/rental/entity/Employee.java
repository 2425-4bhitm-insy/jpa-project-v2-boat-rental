package htl.leonding.rental.entity;

import jakarta.persistence.*;

@Entity(name = "br_employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employee_id;

    @Column(name = "name")
    private String name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Employee(String name, String role, String telephoneNumber) {
        setName(name);
        setRole(role);
        setTelephoneNumber(telephoneNumber);
    }
}
