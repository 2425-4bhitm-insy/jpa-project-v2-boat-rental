package htl.leonding.rental.boundary;

import htl.leonding.rental.control.CustomerRepository;
import htl.leonding.rental.entity.Boat;
import htl.leonding.rental.entity.Customer;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/customers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomerResource {

    @Inject
    CustomerRepository customerRepository;

    @GET
    @Path("/{id}")
    public Response getCustomer(@PathParam("id") Long id) {
        Customer customer = customerRepository.getCustomer(id);
        if (customer == null) {
            return Response.status(404, "Customer with id '" + id + "' was not found.").build();
        }
        return Response.ok(customer).build();
    }

    @POST
    @Transactional
    public Response addCustomer(Customer customer) {
        customerRepository.add(customer);
        return Response.status(201).entity(customer).build();
    }

    @DELETE
    @Path("/delete/{id}")
    @Transactional
    public Response deleteCustomer(@PathParam("id") Long id) {
        Customer customer = customerRepository.getCustomer(id);
        if (customer == null) {
            return Response.status(404, "Customer with id '" + id + "' was not found.").build();
        }
        customerRepository.remove(customer);
        return Response.ok(customer).build();
    }
}
