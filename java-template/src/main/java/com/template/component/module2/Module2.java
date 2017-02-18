package com.template.component.module2;

import com.template.component.module2.request.Module2Service1Request;
import com.template.component.module2.response.Module2Service1Response;
import com.template.component.module2.response.Module2Service2Response;
import com.template.component.module2.service.Service1;
import com.template.core.LogUtil;
import com.template.core.Payload;
import com.template.core.annotation.Secured;
import com.template.core.exception.ExceptionHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
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

    @Resource
    private Service1 service1;

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
        } catch (Throwable t) {
            LogUtil.error(this.getClass(), "Call module2 service1 failed: ", t);
            String res = ExceptionHandler.handle(t);
            return Response.status(Response.Status.OK).entity(res).build();
        }
    }

    @GET
    @Path("/service2")
    @Produces("application/json")
    @Secured
    public Response service2(@Context HttpServletRequest req, @Context HttpServletResponse res, @QueryParam("field1") String field1) {
        Module2Service2Response response = service1.function2(field1);
        try {
            return Response.status(Response.Status.OK).entity(new Payload(response).from(Module2Service2Response.class)).build();
        } catch (Throwable t) {
            LogUtil.error(this.getClass(), "Call module2 service2 failed: ", t);
            String responseContent = ExceptionHandler.handle(t);
            return Response.status(Response.Status.OK).entity(responseContent).build();
        }
    }

}
