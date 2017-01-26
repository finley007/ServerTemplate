package com.template.auth;

import com.template.module2.service.Service1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.ws.rs.Path;

/**
 * Created by finley on 1/18/17.
 */
@Path("/auth")
public class Auth {

    private AuthService authService;

    @Autowired(required = true)
    public void setAuthService(@Qualifier("service")AuthService service) {
        this.authService = service;
    }

}
