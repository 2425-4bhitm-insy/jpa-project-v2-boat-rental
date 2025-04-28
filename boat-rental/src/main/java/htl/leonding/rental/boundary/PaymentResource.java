package htl.leonding.rental.boundary;

import htl.leonding.rental.control.PaymentRepository;
import htl.leonding.rental.entity.Payment;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/payments")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PaymentResource {

    @Inject
    PaymentRepository paymentRepository;

    @GET
    public List<Payment> getAllPayments() {
        return paymentRepository.getAllPayments();
    }

    @GET
    @Path("/{id}")
    public Response getPayment(@PathParam("id") Long id) {
        Payment payment = paymentRepository.getPayment(id);
        if (payment == null) {
            return Response.status(404, "Payment with id '" + id + "' was not found.").build();
        }
        return Response.ok(payment).build();
    }

    @POST
    @Transactional
    public Response addPayment(Payment payment) {
        paymentRepository.add(payment);
        return Response.status(201).entity(payment).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deletePayment(@PathParam("id") Long id) {
        Payment payment = paymentRepository.getPayment(id);
        if (payment == null) {
            return Response.status(404, "Payment with id '" + id + "' was not found.").build();
        }
        paymentRepository.remove(payment);
        return Response.ok(payment).build();
    }
}
