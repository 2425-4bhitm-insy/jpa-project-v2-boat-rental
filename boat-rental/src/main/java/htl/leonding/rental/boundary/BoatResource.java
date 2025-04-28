package htl.leonding.rental.boundary;

import htl.leonding.rental.control.BoatRepository;
import htl.leonding.rental.control.BoatRepositoryImpl;
import htl.leonding.rental.entity.*;
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

    @POST
    @Transactional
    public Response addBoat(Boat boat) {
        boatRepository.add(boat);
        return Response.status(201).entity(boat).build();
    }

    @DELETE
    @Path("delete/{id}")
    @Transactional
    public Response deleteBoat(@PathParam("id") Long id) {
        Boat boat = boatRepository.getBoat(id);
        if (boat == null) {
            return Response.status(404, "Boat with id '" + id + "' was not found.").build();
        }
        boatRepository.remove(boat);
        return Response.ok(boat).build();
    }

    @GET
    @Path("allBoats")
    public List<Boat> getAllBoats() {
        return boatRepository.getAllBoats();
    }

    @GET
    @Path("singleBoat/{id}")
    public Response getSingleBoat(@PathParam("id") Long id) {
        Boat boat = boatRepository.getBoat(id);
        if (boat == null) {
            return Response.status(404, "Boat with id '" + id + "' was not found.").build();
        }
        return Response.ok(boat).build();
    }

    @GET
    @Path("allYachts")
    public List<Yacht> getAllYachts() {
        return boatRepository.getAllYachts();
    }

    @GET
    @Path("allMotorboats")
    public List<Motorboat> getAllMotorboats() {
        return boatRepository.getAllMotorboats();
    }

    @GET
    @Path("allSailboats")
    public List<Sailboat> getAllSailboats() {
        return boatRepository.getAllSailBoats();
    }
}
