package htl.leonding.rental.boundary;

import htl.leonding.rental.control.*;
import htl.leonding.rental.entity.*;
import htl.leonding.rental.entity.dto.BoatDTO;
import htl.leonding.rental.entity.dto.RentalDTO;
import htl.leonding.rental.entity.dto.TopBoatDTO;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.time.LocalDate;
import java.util.List;

@Path("boat")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BoatResource {

    @Inject
    BoatRepository boatRepository;

    @Inject
    CustomerRepository customerRepository;

    @Inject
    PaymentRepository paymentRepository;

    @Inject
    EmployeeRepository employeeRepository;

    @Inject
    ReservationRepository reservationRepository;

    @Inject
    LeaseRepository leaseRepository;

    @GET
    @Path("allBoats")
    public List<Boat> getAllBoats() {
        return boatRepository.getAllBoats();
    }

    @GET
    @Path("singleBoat/{id}")
    public Boat getSingleBoat(@PathParam("id") Long id) {
        return boatRepository.getBoat(id);
    }

    @GET
    @Path("allYachts")
    public List<Yacht> getAllYachts() {
        return boatRepository.getAllYachts();
    }

    @PUT
    @Path("rent/{id}")
    @Transactional
    public Response rentBoat(@PathParam("id") Long boatId) {
        Boat boat = boatRepository.getBoat(boatId);
        if (boat == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Boat not found").build();
        }
        if (boat.isRented()) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Boat already rented").build();
        }

        // 1. Hardcode a customer and employee for now
        Customer customer = customerRepository.getCustomer(1L);
        Employee employee = employeeRepository.getEmployee(1L);

        if (customer == null || employee == null) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Customer or Employee not found").build();
        }

        // 2. Create Reservation
        Reservation reservation = new Reservation();
        reservation.setCustomer(customer);
        reservation.setEmployee(employee);

        reservation.setStartDate(LocalDate.now());
        reservation.setEndDate(LocalDate.now().plusDays(3));
        reservationRepository.add(reservation);

        // 3. Create Lease (connect boat -> reservation)
        Lease lease = new Lease();
        lease.setRentalItems(boat);
        lease.setReservation(reservation);
        leaseRepository.add(lease);

        // 4. Optional: Create Payment -> needs to be paid at the end
        Payment payment = new Payment();
        payment.setAmount(boat.getPrice());
        payment.setPaymentDate(LocalDate.now());
        payment.setReservation(reservation);
        paymentRepository.add(payment);

        // 5. Update Boat status
        boat.setRented(true);
        boatRepository.update(boat);

        return Response.ok("Boat rented successfully").build();
    }


    @GET
    @Path("availableBoats")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAvailableBoats(@QueryParam("startDate") String startDateStr,
                                      @QueryParam("endDate") String endDateStr) {
        LocalDate startDate = LocalDate.parse(startDateStr);
        LocalDate endDate = LocalDate.parse(endDateStr);
        List<Boat> availableBoats = boatRepository.getAvailableBoatsBetweenDates(startDate, endDate);
        return Response.ok(availableBoats).build();
    }

    @GET
    @Path("allRentals")
    @Produces(MediaType.APPLICATION_JSON)
    public List<RentalDTO> getAllBoatRentals() {
        return boatRepository.getAllBoatRentals();
    }

    @POST
    @Path("addBoat")
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response addNewBoat(Boat boat) {
        boatRepository.add(boat);
        return Response.status(Response.Status.CREATED).entity(boat).build();
    }

    @GET
    @Path("topRevenueBoats")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TopBoatDTO> getTopRevenueBoats() {
        return boatRepository.getTopRevenueBoats();
    }
}