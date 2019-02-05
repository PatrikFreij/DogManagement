package service;

import entity.Dog;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import repository.DogRepository;

@Stateless
@Path("")
public class RESTDogManagement {

    @Inject
    DogRepository dr;
    
    @POST
    @Path("/add")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void createDog(Dog d) {
        dr.create(d);
    }
    
    @GET
    @Path("/all")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Dog> getAll() {
        return dr.findAll();
    }
    
    @DELETE
    @Path("/delete/{id}")
    public void removeById(@PathParam("id") Long id) {
        dr.deleteById(id);
    }
    
    @PUT
    @Path("/update/{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void updateDog(@PathParam("id") Long id, Dog d) {
        dr.update(d);
    }
    
    @GET
    @Path("/find/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Dog find(@PathParam("id") Long id) {
        return dr.read(id);
    }
    
}
