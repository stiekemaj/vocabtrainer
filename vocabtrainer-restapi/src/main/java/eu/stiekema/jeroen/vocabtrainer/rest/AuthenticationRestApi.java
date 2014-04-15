package eu.stiekema.jeroen.vocabtrainer.rest;

import eu.stiekema.jeroen.vocabtrainer.model.User;
import eu.stiekema.jeroen.vocabtrainer.service.UserService;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Jeroen Stiekema
 */
@Path("/login")
@Singleton
public class AuthenticationRestApi {

    @EJB
    private UserService userService;


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(@FormParam("email") String email, @FormParam("password") String password,
            @Context HttpServletRequest req) {

        JsonResponse json = new JsonResponse();
        //only login if not already logged in...
        if (req.getUserPrincipal() == null) {
            try {
                req.login(email, password);
                req.getServletContext().log("Authentication Demo: successfully logged in " + email);
            } catch (ServletException e) {
                e.printStackTrace();
                json.setStatus("FAILED");
                json.setErrorMsg("Authentication failed");
                return Response.ok().entity(json).build();
            }
        } else {
            req.getServletContext().log("Skip logged because already logged in: " + email);
        }

        //read the user data from db and return to caller
        json.setStatus("SUCCESS");

        User user = userService.getUserByEmailAddress(email);
        req.getServletContext().log("Authentication Demo: successfully retrieved User Profile from DB for " + email);
        json.setData(user);

        //we don't want to send the hashed password out in the json response
        userService.detachUser(user);
        user.setPassword(null);
        user.setGroups(null);
        return Response.ok().entity(json).build();
    }

}

