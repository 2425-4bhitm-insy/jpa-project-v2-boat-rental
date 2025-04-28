package htl.leonding.rental.boundary;

import htl.leonding.rental.control.LeaseRepository;
import htl.leonding.rental.entity.Lease;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/leases")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LeaseResource {

    @Inject
    LeaseRepository leaseRepository;

    @GET
    public List<Lease> getAllLeases() {
        return leaseRepository.getAllLeases();
    }

    @GET
    @Path("/{id}")
    public Response getLease(@PathParam("id") Long id) {
        Lease lease = leaseRepository.getLease(id);
        if (lease == null) {
            return Response.status(404, "Lease with id '" + id + "' was not found.").build();
        }
        return Response.ok(lease).build();
    }

    @POST
    @Transactional
    public Response addLease(Lease lease) {
        leaseRepository.add(lease);
        return Response.ok(lease).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteLease(@PathParam("id") Long id) {
        Lease lease = leaseRepository.getLease(id);
        if (lease == null) {
            return Response.status(404, "Lease with id '" + id + "' was not found.").build();
        }
        leaseRepository.remove(lease);
        return Response.ok(lease).build();
    }
}
