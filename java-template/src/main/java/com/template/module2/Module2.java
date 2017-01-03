package com.template.module2;

import com.template.module2.request.Module2Service1Request;
import com.template.module2.response.Module2Service2Response;
import com.template.module2.service.Service1;
import com.template.serialize.Serializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import javax.ws.rs.*;
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

    private Serializer serializer;

    @Autowired(required = true)
    public void setSerializer(@Qualifier("serializer")Serializer serializer) {
        this.serializer = serializer;
    }

    @POST
    @Path("/service1")
    @Consumes("application/json")
    @Produces("application/json")
    public Response service1(@RequestParam String request) {
        System.out.println(request);
        Module2Service1Request msrequest = serializer.deserializeToBean(request, Module2Service1Request.class);
        System.out.println(msrequest.getField1());
        System.out.println(msrequest.getField2());
        Module2Service2Response response = service1.function1(new Module2Service1Request());
        return Response.status(Response.Status.OK).entity(serializer.serializeFromBean(response)).build();
    }

}
