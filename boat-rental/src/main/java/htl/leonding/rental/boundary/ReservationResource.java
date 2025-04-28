package htl.leonding.rental.boundary;

import htl.leonding.rental.control.ReservationRepository;
import htl.leonding.rental.entity.Reservation;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/reservations")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ReservationResource {

    @Inject
    ReservationRepository reservationRepository;

    @GET
    public List<Reservation> getAllReservations() {
        return reservationRepository.getAllReservations();
    }

    @GET
    @Path("/{id}")
    public Response getReservation(@PathParam("id") Long id) {
        Reservation reservation = reservationRepository.getReservation(id);
        if (reservation == null) {
            return Response.status(404, "Reservation with id '" + id + "' was not found.").build();
        }
        return Response.ok(reservation).build();
    }

    @POST
    @Transactional
    public Response addReservation(Reservation reservation) {
        reservationRepository.add(reservation);
        return Response.status(201).entity(reservation).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteReservation(@PathParam("id") Long id) {
        Reservation reservation = reservationRepository.getReservation(id);
        if (reservation == null) {
            return Response.status(404, "Reservation with id '" + id + "' was not found.").build();
        }
        reservationRepository.remove(reservation);
        return Response.ok(reservation).build();
    }
}
