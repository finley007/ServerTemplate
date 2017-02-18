package com.template.auth;

import com.template.core.annotation.Validate;
import com.template.core.exception.BusinessException;
import com.template.core.exception.SystemException;
import com.template.core.log.LogUtil;
import com.template.core.payload.Payload;
import com.template.core.response.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
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

    @Resource
    private AuthService authService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Validate
    public Response auth(@RequestParam String request) {
        LogUtil.info(this.getClass(), "Do authentication for user: {} ", request);
        try {
            AuthResponse response = this.authService.authenticate(new Payload(request).as(AuthRequest.class));
            return Response.status(Response.Status.OK).entity(new Payload(response).from(AuthResponse.class)).build();
        } catch (SystemException e) {
            return Response.status(Response.Status.OK).entity(new ErrorResponse(e.toString()).build()).build();
        } catch (BusinessException e) {
            return Response.status(Response.Status.OK).entity(new ErrorResponse(e.toString()).build()).build();
        } catch (Throwable t) {
            return Response.status(Response.Status.OK).entity(new ErrorResponse(t.getMessage()).build()).build();
        }
    }

}
