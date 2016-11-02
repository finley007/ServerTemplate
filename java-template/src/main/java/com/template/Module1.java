package com.template;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import java.util.Enumeration;
import java.util.Map;

/**
 * Created by liuli on 11/2/2016.
 */
@Path("/module1")
public class Module1 {

    @GET
    @Path("{service}")
    public String service(@PathParam("service") String service, @Context HttpServletRequest request) {
        StringBuffer sb = new StringBuffer();
        Enumeration<String> params = request.getParameterNames();
        while (params.hasMoreElements()) {
            sb.append(params.nextElement() + "|");
        }
        return  service + ":" + sb.toString();
    }

}
