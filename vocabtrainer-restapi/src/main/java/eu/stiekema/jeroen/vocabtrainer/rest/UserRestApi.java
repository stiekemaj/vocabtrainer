package eu.stiekema.jeroen.vocabtrainer.rest;

import eu.stiekema.jeroen.vocabtrainer.model.User;
import eu.stiekema.jeroen.vocabtrainer.service.UserService;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 * @author Jeroen Stiekema
 */
@Path("/users")
@RolesAllowed("USER")
@Singleton
public class UserRestApi {

    @EJB
    private UserService userService;

    public UserRestApi() {

    }

    @Path("user/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserById(@PathParam("id") Long id, @Context HttpServletRequest req) {
        return userService.getUserById(id);
    }

    @GET
    public String hello() {
        return "Hello World";
    }
}
