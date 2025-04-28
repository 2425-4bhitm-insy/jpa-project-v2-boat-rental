package htl.leonding.rental.boundary;

import htl.leonding.rental.control.BoatRepository;
import htl.leonding.rental.control.BoatRepositoryImpl;
import htl.leonding.rental.entity.Boat;
import htl.leonding.rental.entity.Yacht;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("boat")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BoatResource {

    @Inject
    BoatRepository boatRepository;

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
    public Response rentBoat(@PathParam("id") Long id) {
        Boat boat = boatRepository.getBoat(id);
        if (boat == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Boat not found").build();
        }
        if (boat.isRented()) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Boat already rented").build();
        }
        boat.setRented(true);
        boatRepository.update(boat);
        return Response.ok(boat).build();
    }

}
