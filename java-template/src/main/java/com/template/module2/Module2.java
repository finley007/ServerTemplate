package com.template.module2;

import com.template.BaseRequest;
import com.template.module2.service.Service1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by rongb on 2016/12/26.
 */

@Component
@Path("/module2")
public class Module2 {

    @Autowired
    private Service1 service1;

    @GET
    @Produces("application/json")
    public String service1() {
        return service1.function1(new BaseRequest() {
            @Override
            public void from(String strReq) {

            }
        });
    }

}
