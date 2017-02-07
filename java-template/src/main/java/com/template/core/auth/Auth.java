package com.template.core.auth;

import com.template.core.auth.request.AuthRequest;
import com.template.core.auth.response.AuthResponse;
import com.template.core.log.LogUtil;
import com.template.core.payload.Payload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by finley on 1/18/17.
 */
@Component
@Path("/auth")
public class Auth {

    private AuthService authService;

    @Autowired(required = true)
    public void setAuthService(@Qualifier("authService")AuthService service) {
        this.authService = service;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response auth(@RequestParam String request) {
        LogUtil.info(this.getClass(), "Do authtication for user: {} ", request);
        try {
            AuthResponse response = this.authService.authenticate(new Payload(request).as(AuthRequest.class));
            return Response.status(Response.Status.OK).entity(new Payload(response).from(AuthResponse.class)).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }

}
