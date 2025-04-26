package htl.leonding.rental.boundary;

import htl.leonding.rental.control.BoatRepositoryImpl;
import htl.leonding.rental.entity.Boat;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("boat")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BoatResource {

    @Inject
    BoatRepositoryImpl boatRepository;

    @GET
    @Path("getAllBoats")
    public List<Boat> getAllBoats() {
        return boatRepository.getAllBoats();
    }

}
