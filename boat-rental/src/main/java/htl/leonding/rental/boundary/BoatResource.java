package htl.leonding.rental.boundary;

import htl.leonding.rental.control.BoatRepository;
import htl.leonding.rental.control.BoatRepositoryImpl;
import htl.leonding.rental.entity.Boat;
import htl.leonding.rental.entity.Motorboat;
import htl.leonding.rental.entity.Sailboat;
import htl.leonding.rental.entity.Yacht;
import jakarta.inject.Inject;
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
