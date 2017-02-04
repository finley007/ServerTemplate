package com.template.component.module;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 * Created by rongb on 2016/10/30.
 */
@Component
@Path("/module")
public class Module {

    @GET
    @Path("/serviceA")
    public String serviceA() {
        return  "serviceA";
    }

    @GET
    @Path("/serviceB")
    public String serviceB(@QueryParam("param") String param) {
        return "serviceB:" + param;
    }

    @GET
    @Path("/serviceC")
    public String serviceC(@QueryParam("param1") String param1, @QueryParam("param2") String param2) {
        return "serviceC:" + param1 + "|" + param2;
    }

    @POST
    @Path("/serviceD")
    public String serviceD(@QueryParam("param1") String param1, @QueryParam("param2") String param2) {
        return "serviceD:" + param1 + "|" + param2;
    }

}
