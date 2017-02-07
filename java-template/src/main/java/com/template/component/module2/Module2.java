package com.template.component.module2;

import com.template.component.module2.request.Module2Service1Request;
import com.template.component.module2.response.Module2Service1Response;
import com.template.component.module2.response.Module2Service2Response;
import com.template.component.module2.service.Service1;
import com.template.core.auth.annotation.Secured;
import com.template.core.log.LogUtil;
import com.template.core.payload.Payload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

/**
 * Created by rongb on 2016/12/26.
 */

@Component
@Path("/module2")
public class Module2 {

    private Service1 service1;

    @Autowired(required = true)
    public void setService1(@Qualifier("service1")Service1 service1) {
        this.service1 = service1;
    }

    @POST
    @Path("/service1")
    @Consumes("application/json")
    @Produces("application/json")
    public Response service1(@RequestParam String request) {
        LogUtil.info(this.getClass(), "Service 1 request: {} ", request);
        try {
            Module2Service1Request msrequest = new Payload(request).as(Module2Service1Request.class);
            Module2Service1Response response = service1.function1(msrequest);
            String responseContent = new Payload(response).from(Module2Service1Response.class);
            LogUtil.info(this.getClass(), "Service 1 response: {} ", responseContent);
            return Response.status(Response.Status.OK).entity(responseContent).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Response.status(Response.Status.EXPECTATION_FAILED).build();
    }

    @GET
    @Path("/service2")
    @Produces("application/json")
    @Secured
    public Response service2(@Context HttpServletRequest req, @Context HttpServletResponse res, @QueryParam("field1") String field1) {
        Module2Service2Response response = service1.function2(field1);
        try {
            return Response.status(Response.Status.OK).entity(new Payload(response).from(Module2Service2Response.class)).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Response.status(Response.Status.EXPECTATION_FAILED).build();
    }

}