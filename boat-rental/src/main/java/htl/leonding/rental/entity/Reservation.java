package htl.leonding.rental.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "br_reservation")
public class Reservation {

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Employee employee;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "startDate")
    private LocalDate startDate;

    @Column(name = "endDate")
    private LocalDate endDate;

    public Reservation(Customer customer, Employee employee, LocalDate startDate, LocalDate endDate) {
       setCustomer(customer);
       setEndDate(endDate);
       setEmployee(employee);
       setStartDate(startDate);
    }

    public Reservation() {

    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Long getId() {
        return this.id;
    }

    //TODO add attributes
}
