package template;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 * Created by rongb on 2016/10/30.
 */
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

}
